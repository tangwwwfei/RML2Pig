REGISTER file:///E:/RML2PigAndScala/LoadTurtle/target/LoadTurtle.jar;
DEFINE R2PFORMAT r2ps.udf.pig.R2PFORMAT;
DEFINE R2PTOBAG r2ps.udf.pig.R2PTOBAG;
DEFINE R2PTOTUPLE r2ps.udf.pig.R2PTOTUPLE;
DEFINE equalCondition r2ps.udf.pig.equalCondition;
DEFINE execFunction r2ps.udf.pig.execFunction;
%default map_map_person_0_source '{"iterator":"","referenceFormulation":"ql:CSV","query":"","sqlVersion":"","tableName":"","name":"data.csv"}'

%default map_map_person_0_referenceFormulation 'ql:CSV'

%default map_map_person_0_iterator ''

%default map_map_person_0_template '<http://example.com/{name}>'

map_map_person_0_data = load 'data.csv' using r2ps.udf.pig.R2PLOADSOURCE('${map_map_person_0_source}','[["name"]]') as (f1:tuple(chararray));

map_map_person_0_table = foreach map_map_person_0_data generate 
	R2PFORMAT('${map_map_person_0_template}', $0),
	$0;

map_map_person_0_subjectMap = map_map_person_0_table;

map_map_person_0_objectMap = map_map_person_0_table;

map_map_person_0_objectMap = foreach map_map_person_0_objectMap generate 
	$0,
	'<http://example.com/name>',
	R2PFORMAT('<http://%s>',$1);

result = map_map_person_0_objectMap;

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
	'rml:',
	'<http://semweb.mmlab.be/ns/rml#>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'rdf:',
	'<http://www.w3.org/1999/02/22-rdf-syntax-ns#>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'rdfs:',
	'<http://www.w3.org/2000/01/rdf-schema#>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'ql:',
	'<http://semweb.mmlab.be/ns/ql#>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'map:',
	'<http://mapping.example.com/>';

result = union result,ns;

result = distinct result;

dump result;