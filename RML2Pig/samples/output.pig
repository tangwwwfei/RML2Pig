%default current_date `date +%Y-%m-%d-%H-%M-%S`
REGISTER ./out/artifacts/LoadTurtle_jar/LoadTurtle.jar;
DEFINE R2PFORMAT r2ps.udf.pig.R2PFORMAT;
DEFINE R2PTOBAT r2ps.udf.pig.toBag;
DEFINE R2PTOTUPLE r2ps.udf.pig.toTuple;
DEFINE equalCondition r2ps.udf.pig.equalCondition;
DEFINE execFunction r2ps.udf.pig.execFunction;
%default TriplesMap1_source '{"iterator":"","referenceFormulation":"ql:CSV","query":"","sqlVersion":"","tableName":"","name":"data.csv"}'

%default TriplesMap1_referenceFormulation 'ql:CSV'

%default TriplesMap1_iterator ''

%default TriplesMap1_template 'http://example.com/{id}'

TriplesMap1_data = load 'data.csv' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMap1_source}','[["id"],["name"]]') as (f1:tuple(chararray),f2:tuple(chararray));

TriplesMap1_table = foreach TriplesMap1_data generate 
	R2PFORMAT('${TriplesMap1_template}', $0),
	$0,
	$1;

TriplesMap1_subjectMap = TriplesMap1_table;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'foaf:name',
	'';

result = TriplesMap1_objectMap;

ns = limit result,1;

ns = foreach ns generate 
	'@prefix',
	'rr:',
	'http://www.w3.org/ns/r2rml#.';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'foaf:',
	'http://xmlns.com/foaf/0.1/.';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'ex:',
	'http://example.com/.';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'xsd:',
	'http://www.w3.org/2001/XMLSchema#.';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'rml:',
	'http://semweb.mmlab.be/ns/rml#.';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'ql:',
	'http://semweb.mmlab.be/ns/ql#.';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'fnml:',
	'http://semweb.mmlab.be/ns/fnml#.';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'fno:',
	'https://w3id.org/function/ontology#.';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'grel:',
	'http://users.ugent.be/~bjdmeest/function/grel.ttl#.';

result = union result,ns;

ns = foreach ns generate 
	'@base',
	'',
	'http://example.com/base/.';

result = union result,ns;

result = distinct result;
store result into 'r2presult/$current_date';