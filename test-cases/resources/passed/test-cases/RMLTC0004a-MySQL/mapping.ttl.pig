REGISTER file:///E:/RML2PigAndScala/LoadTurtle/target/LoadTurtle.jar;
DEFINE R2PFORMAT r2ps.udf.pig.R2PFORMAT;
DEFINE R2PTOBAG r2ps.udf.pig.R2PTOBAG;
DEFINE R2PTOTUPLE r2ps.udf.pig.R2PTOTUPLE;
DEFINE equalCondition r2ps.udf.pig.equalCondition;
DEFINE execFunction r2ps.udf.pig.execFunction;
%default TriplesMap1_source '{"iterator":"","referenceFormulation":"","query":"","sqlVersion":"rr:SQL2008","tableName":"student_sport","name":"","database":{"jdbcDSN":"CONNECTIONDSN","jdbcDriver":"com.mysql.cj.jdbc.Driver","username":"root","password":""}}'

%default TriplesMap1_referenceFormulation ''

%default TriplesMap1_iterator ''

%default TriplesMap1_template '<http://example.com/{Student}>'

TriplesMap1_data = load 'UnusedPath' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMap1_source}','[["Student"]]') as (f1:tuple(chararray));

TriplesMap1_table = foreach TriplesMap1_data generate 
	R2PFORMAT('${TriplesMap1_template}', $0),
	$0;

%default TriplesMap2_source '{"iterator":"","referenceFormulation":"","query":"","sqlVersion":"rr:SQL2008","tableName":"student_sport","name":"","database":{"jdbcDSN":"CONNECTIONDSN","jdbcDriver":"com.mysql.cj.jdbc.Driver","username":"root","password":""}}'

%default TriplesMap2_referenceFormulation ''

%default TriplesMap2_iterator ''

%default TriplesMap2_template '<http://example.com/{Sport}>'

TriplesMap2_data = load 'UnusedPath' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMap2_source}','[["Sport"]]') as (f1:tuple(chararray));

TriplesMap2_table = foreach TriplesMap2_data generate 
	R2PFORMAT('${TriplesMap2_template}', $0),
	$0;

TriplesMap1_subjectMap = TriplesMap1_table;

TriplesMap1_subjectMap = foreach TriplesMap1_subjectMap generate 
	$0,
	'rdf:type',
	FLATTEN(R2PTOBAG('ex:Student'));

result = TriplesMap1_subjectMap;

TriplesMap2_subjectMap = TriplesMap2_table;

TriplesMap2_subjectMap = foreach TriplesMap2_subjectMap generate 
	$0,
	'rdf:type',
	FLATTEN(R2PTOBAG('ex:Sport'));

result = union result,TriplesMap2_subjectMap;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'foaf:name',
	R2PFORMAT('"%s"',$1);

result = union result,TriplesMap1_objectMap;

TriplesMap2_objectMap = TriplesMap2_table;

TriplesMap2_objectMap = foreach TriplesMap2_objectMap generate 
	$0,
	'foaf:name',
	R2PFORMAT('"%s"',$1);

result = union result,TriplesMap2_objectMap;

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

ns = foreach ns generate 
	'@prefix',
	'd2rq:',
	'<http://www.wiwiss.fu-berlin.de/suhl/bizer/D2RQ/0.1#>';

result = union result,ns;

result = distinct result;

dump result;