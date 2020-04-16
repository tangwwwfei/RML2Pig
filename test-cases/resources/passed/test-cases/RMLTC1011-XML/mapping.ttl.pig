REGISTER file:///E:/RML2PigAndScala/LoadTurtle/target/LoadTurtle.jar;
DEFINE R2PFORMAT r2ps.udf.pig.R2PFORMAT;
DEFINE R2PTOBAG r2ps.udf.pig.R2PTOBAG;
DEFINE R2PTOTUPLE r2ps.udf.pig.R2PTOTUPLE;
DEFINE equalCondition r2ps.udf.pig.equalCondition;
DEFINE execFunction r2ps.udf.pig.execFunction;
%default TriplesMapStudent_source '{"iterator":"/students/student","referenceFormulation":"ql:XPath","query":"","sqlVersion":"","tableName":"","name":"student.xml"}'

%default TriplesMapStudent_referenceFormulation 'ql:XPath'

%default TriplesMapStudent_iterator '/students/student'

%default TriplesMapStudent_template '<Name>'

TriplesMapStudent_data = load 'student.xml' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMapStudent_source}','[["/students/student/Name"]]') as (f1:tuple(chararray));

TriplesMapStudent_table = foreach TriplesMapStudent_data generate 
	R2PFORMAT('${TriplesMapStudent_template}', $0),
	$0;

%default TriplesMapAddress_source '{"iterator":"/students/student/Address","referenceFormulation":"ql:XPath","query":"","sqlVersion":"","tableName":"","name":"student.xml"}'

%default TriplesMapAddress_referenceFormulation 'ql:XPath'

%default TriplesMapAddress_iterator '/students/student/Address'

%default TriplesMapAddress_template '<http://example.com/{City}>'

TriplesMapAddress_data = load 'student.xml' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMapAddress_source}','[["/students/student/Address/City"]]') as (f1:tuple(chararray));

TriplesMapAddress_table = foreach TriplesMapAddress_data generate 
	R2PFORMAT('${TriplesMapAddress_template}', $0),
	$0;

TriplesMapStudent_subjectMap = TriplesMapStudent_table;

TriplesMapAddress_subjectMap = TriplesMapAddress_table;

TriplesMapStudent_objectMap = TriplesMapStudent_table;

TriplesMapStudent_objectMap = foreach TriplesMapStudent_objectMap generate 
	$0,
	'rdf:type',
	'foaf:Person';

result = TriplesMapStudent_objectMap;

TriplesMapAddress_objectMap = TriplesMapAddress_table;

TriplesMapAddress_objectMap = foreach TriplesMapAddress_objectMap generate 
	$0,
	'rdf:type',
	'ex:Address';

result = union result,TriplesMapAddress_objectMap;

result = distinct result;

result = filter result by $0 is not null and $1 is not null and $2 is not null;

ns = limit result 1;

ns = foreach ns generate 
	'@prefix',
	'rr:',
	'<http://www.w3.org/ns/r2rml#>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'foaf:',
	'<http://xmlns.com/foaf/0.1/>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'ex:',
	'<http://example.com/>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'xsd:',
	'<http://www.w3.org/2001/XMLSchema#>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'rdf:',
	'<http://www.w3.org/1999/02/22-rdf-syntax-ns#>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'rml:',
	'<http://semweb.mmlab.be/ns/rml#>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'ql:',
	'<http://semweb.mmlab.be/ns/ql#>';

result = union result,ns;

ns = foreach ns generate 
	'@base',
	'',
	'<http://example.com/base/>';

result = union result,ns;

result = distinct result;

dump result;