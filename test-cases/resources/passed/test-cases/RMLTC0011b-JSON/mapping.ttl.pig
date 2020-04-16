REGISTER file:///E:/RML2PigAndScala/LoadTurtle/target/LoadTurtle.jar;
DEFINE R2PFORMAT r2ps.udf.pig.R2PFORMAT;
DEFINE R2PTOBAG r2ps.udf.pig.R2PTOBAG;
DEFINE R2PTOTUPLE r2ps.udf.pig.R2PTOTUPLE;
DEFINE equalCondition r2ps.udf.pig.equalCondition;
DEFINE execFunction r2ps.udf.pig.execFunction;
%default TriplesMap1_source '{"iterator":"$.students[*]","referenceFormulation":"ql:JSONPath","query":"","sqlVersion":"","tableName":"","name":"student.json"}'

%default TriplesMap1_referenceFormulation 'ql:JSONPath'

%default TriplesMap1_iterator '$.students[*]'

%default TriplesMap1_template '<http://example.com/student/{ID}>'

TriplesMap1_data = load 'student.json' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMap1_source}','[["$.students[*].ID"],["$.students[*].FirstName"],["$.students[*].LastName"]]') as (f1:tuple(chararray),f2:tuple(chararray),f3:tuple(chararray));

TriplesMap1_table = foreach TriplesMap1_data generate 
	R2PFORMAT('${TriplesMap1_template}', $0),
	$0,
	$1,
	$2;

%default TriplesMap2_source '{"iterator":"$.sports[*]","referenceFormulation":"ql:JSONPath","query":"","sqlVersion":"","tableName":"","name":"sport.json"}'

%default TriplesMap2_referenceFormulation 'ql:JSONPath'

%default TriplesMap2_iterator '$.sports[*]'

%default TriplesMap2_template '<http://example.com/sport/{ID}>'

TriplesMap2_data = load 'sport.json' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMap2_source}','[["$.sports[*].ID"],["$.sports[*].Description"]]') as (f1:tuple(chararray),f2:tuple(chararray));

TriplesMap2_table = foreach TriplesMap2_data generate 
	R2PFORMAT('${TriplesMap2_template}', $0),
	$0,
	$1;

%default LinkMap_1_2_source '{"iterator":"$.links[*]","referenceFormulation":"ql:JSONPath","query":"","sqlVersion":"","tableName":"","name":"student_sport.json"}'

%default LinkMap_1_2_referenceFormulation 'ql:JSONPath'

%default LinkMap_1_2_iterator '$.links[*]'

%default LinkMap_1_2_template '<http://example.com/student/{ID_Student}>'

LinkMap_1_2_data = load 'student_sport.json' using r2ps.udf.pig.R2PLOADSOURCE('${LinkMap_1_2_source}','[["$.links[*].ID_Student"],["$.links[*].ID_Sport"]]') as (f1:tuple(chararray),f2:tuple(chararray));

LinkMap_1_2_table = foreach LinkMap_1_2_data generate 
	R2PFORMAT('${LinkMap_1_2_template}', $0),
	$0,
	$1;

TriplesMap1_subjectMap = TriplesMap1_table;

TriplesMap2_subjectMap = TriplesMap2_table;

LinkMap_1_2_subjectMap = LinkMap_1_2_table;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'ex:firstName',
	R2PFORMAT('"%s"',$2);

result = TriplesMap1_objectMap;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'ex:lastName',
	R2PFORMAT('"%s"',$3);

result = union result,TriplesMap1_objectMap;

TriplesMap2_objectMap = TriplesMap2_table;

TriplesMap2_objectMap = foreach TriplesMap2_objectMap generate 
	$0,
	'ex:id',
	R2PFORMAT('"%s"',$1);

result = union result,TriplesMap2_objectMap;

TriplesMap2_objectMap = TriplesMap2_table;

TriplesMap2_objectMap = foreach TriplesMap2_objectMap generate 
	$0,
	'ex:description',
	R2PFORMAT('"%s"',$2);

result = union result,TriplesMap2_objectMap;

LinkMap_1_2_objectMap = LinkMap_1_2_table;

LinkMap_1_2_objectMap = foreach LinkMap_1_2_objectMap generate 
	$0,
	'ex:plays',
	R2PFORMAT('<http://example.com/sport/%s>',$2);

result = union result,LinkMap_1_2_objectMap;

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

result = distinct result;

dump result;