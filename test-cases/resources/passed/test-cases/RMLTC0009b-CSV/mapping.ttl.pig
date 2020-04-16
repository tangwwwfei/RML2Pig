REGISTER file:///E:/RML2PigAndScala/LoadTurtle/target/LoadTurtle.jar;
DEFINE R2PFORMAT r2ps.udf.pig.R2PFORMAT;
DEFINE R2PTOBAG r2ps.udf.pig.R2PTOBAG;
DEFINE R2PTOTUPLE r2ps.udf.pig.R2PTOTUPLE;
DEFINE equalCondition r2ps.udf.pig.equalCondition;
DEFINE execFunction r2ps.udf.pig.execFunction;
%default TriplesMap1_source '{"iterator":"","referenceFormulation":"ql:CSV","query":"","sqlVersion":"","tableName":"","name":"student.csv"}'

%default TriplesMap1_referenceFormulation 'ql:CSV'

%default TriplesMap1_iterator ''

%default TriplesMap1_template '<http://example.com/resource/student_{ID}>'

TriplesMap1_data = load 'student.csv' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMap1_source}','[["ID"],["Name"],["Sport"]]') as (f1:tuple(chararray),f2:tuple(chararray),f3:tuple(chararray));

TriplesMap1_table = foreach TriplesMap1_data generate 
	R2PFORMAT('${TriplesMap1_template}', $0),
	$0,
	$1,
	$2;

%default TriplesMap2_source '{"iterator":"","referenceFormulation":"ql:CSV","query":"","sqlVersion":"","tableName":"","name":"sport.csv"}'

%default TriplesMap2_referenceFormulation 'ql:CSV'

%default TriplesMap2_iterator ''

%default TriplesMap2_template '<http://example.com/resource/sport_{ID}>'

TriplesMap2_data = load 'sport.csv' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMap2_source}','[["ID"],["Name"]]') as (f1:tuple(chararray),f2:tuple(chararray));

TriplesMap2_table = foreach TriplesMap2_data generate 
	R2PFORMAT('${TriplesMap2_template}', $0),
	$0,
	$1;

TriplesMap1_subjectMap = TriplesMap1_table;

TriplesMap1_subjectMap = foreach TriplesMap1_subjectMap generate 
	$0,
	'rdf:type',
	FLATTEN(R2PTOBAG('<http://example.com/ontology/Student>')),
	FLATTEN(R2PTOBAG('<http://example.com/graph/students>'));

result = TriplesMap1_subjectMap;

TriplesMap2_subjectMap = TriplesMap2_table;

TriplesMap2_subjectMap = foreach TriplesMap2_subjectMap generate 
	$0,
	'rdf:type',
	FLATTEN(R2PTOBAG('<http://example.com/ontology/Sport>')),
	FLATTEN(R2PTOBAG('<http://example.com/graph/sports>'));

result = union result,TriplesMap2_subjectMap;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'foaf:name',
	R2PFORMAT('"%s"',$2),
	FLATTEN(R2PTOBAG('<http://example.com/graph/students>','<http://example.com/graph/students>'));

result = union result,TriplesMap1_objectMap;

child = foreach TriplesMap1_table generate 
	$0,
	$3;

parent = foreach TriplesMap2_table generate 
	$0,
	$1;

TriplesMap1_predicateObjectMap = join child by ($1), parent by ($1);

TriplesMap1_predicateObjectMap = foreach TriplesMap1_predicateObjectMap generate 
	$0,
	'<http://example.com/ontology/practises>',
	$2,
	FLATTEN(R2PTOBAG('<http://example.com/graph/students>','<http://example.com/graph/practise>'));

result = union result,TriplesMap1_predicateObjectMap;

TriplesMap2_objectMap = TriplesMap2_table;

TriplesMap2_objectMap = foreach TriplesMap2_objectMap generate 
	$0,
	'rdfs:label',
	R2PFORMAT('"%s"',$2),
	FLATTEN(R2PTOBAG('<http://example.com/graph/sports>'));

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
	'@prefix',
	'activity:',
	'<http://example.com/activity/>';

result = union result,ns;

ns = foreach ns generate 
	'@base',
	'',
	'<http://example.com/base/>';

result = union result,ns;

result = distinct result;

dump result;