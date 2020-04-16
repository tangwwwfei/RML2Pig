REGISTER file:///E:/RML2PigAndScala/LoadTurtle/target/LoadTurtle.jar;
DEFINE R2PFORMAT r2ps.udf.pig.R2PFORMAT;
DEFINE R2PTOBAG r2ps.udf.pig.R2PTOBAG;
DEFINE R2PTOTUPLE r2ps.udf.pig.R2PTOTUPLE;
DEFINE equalCondition r2ps.udf.pig.equalCondition;
DEFINE execFunction r2ps.udf.pig.execFunction;
%default TriplesMap2_source '{"iterator":"$.results.bindings[*]","referenceFormulation":"ql:JSONPath","query":"PREFIX+rdfs%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E+PREFIX+foaf%3A+%3Chttp%3A%2F%2Fxmlns.com%2Ffoaf%2F0.1%2F%3E+PREFIX+rdf%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E+SELECT+%3FSport+WHERE+%7B+%3Fx+a+%3Chttp%3A%2F%2Fexample.com%2FSport%3E+.+%3Fx+foaf%3Aname+%3FSport+.+%7D","sqlVersion":"","tableName":"","name":"","sparql":{"endpoint":"http://localhost:PORT/ds1/sparql","supportedLanguage":"sd:SPARQL11Query","resultFormat":"http://www.w3.org/ns/formats/SPARQL_Results_JSON"}}'

%default TriplesMap2_referenceFormulation 'ql:JSONPath'

%default TriplesMap2_iterator '$.results.bindings[*]'

%default TriplesMap2_template '<http://example.com/{Sport.value}>'

TriplesMap2_data = load 'UnusedPath' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMap2_source}','[["$.results.bindings[*].Sport.value"]]') as (f1:tuple(chararray));

TriplesMap2_table = foreach TriplesMap2_data generate 
	R2PFORMAT('${TriplesMap2_template}', $0),
	$0;

%default TriplesMap1_source '{"iterator":"$.results.bindings[*]","referenceFormulation":"ql:JSONPath","query":"PREFIX+rdfs%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E+PREFIX+foaf%3A+%3Chttp%3A%2F%2Fxmlns.com%2Ffoaf%2F0.1%2F%3E+PREFIX+rdf%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E+SELECT+%3FName+%3FID+WHERE+%7B+%3Fx+foaf%3Aname+%3FName+%3B+rdf%3AID+%3FID+%3B+%7D","sqlVersion":"","tableName":"","name":"","sparql":{"endpoint":"http://localhost:PORT/ds1/sparql","supportedLanguage":"sd:SPARQL11Query","resultFormat":"http://www.w3.org/ns/formats/SPARQL_Results_JSON"}}'

%default TriplesMap1_referenceFormulation 'ql:JSONPath'

%default TriplesMap1_iterator '$.results.bindings[*]'

%default TriplesMap1_template '<http://example.com/Student/{ID.value}/{Name.value}>'

TriplesMap1_data = load 'UnusedPath' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMap1_source}','[["$.results.bindings[*].ID.value,$.results.bindings[*].Name.value"],["$.results.bindings[*].ID.value"],["$.results.bindings[*].Name.value"]]') as (f1:tuple(chararray,chararray),f2:tuple(chararray),f3:tuple(chararray));

TriplesMap1_table = foreach TriplesMap1_data generate 
	R2PFORMAT('${TriplesMap1_template}', $0),
	$0,
	$1,
	$2;

TriplesMap2_subjectMap = TriplesMap2_table;

TriplesMap1_subjectMap = TriplesMap1_table;

TriplesMap2_objectMap = TriplesMap2_table;

TriplesMap2_objectMap = foreach TriplesMap2_objectMap generate 
	$0,
	'rdf:type',
	'activity:Sport';

result = TriplesMap2_objectMap;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'rdf:type',
	'foaf:Person';

result = union result,TriplesMap1_objectMap;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'ex:id',
	R2PFORMAT('"%s"',$2);

result = union result,TriplesMap1_objectMap;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'foaf:name',
	R2PFORMAT('"%s"',$3);

result = union result,TriplesMap1_objectMap;

child = foreach TriplesMap1_table generate 
	$0;

parent = foreach TriplesMap2_table generate 
	$0;

TriplesMap1_predicateObjectMap = cross child,parent;

TriplesMap1_predicateObjectMap = foreach TriplesMap1_predicateObjectMap generate 
	$0,
	'ex:Sport',
	$1;

result = union result,TriplesMap1_predicateObjectMap;

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
	'crml:',
	'<http://semweb.mmlab.be/ns/crml#>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'ql:',
	'<http://semweb.mmlab.be/ns/ql#>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'mail:',
	'<http://example.com/mail#>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'xsd:',
	'<http://www.w3.org/2001/XMLSchema#>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'sd:',
	'<http://www.w3.org/ns/sparql-service-description#>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'activity:',
	'<http://example.com/activity/>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'ex:',
	'<http://example.com/>';

result = union result,ns;

ns = foreach ns generate 
	'@prefix',
	'hydra:',
	'<http://www.w3.org/ns/hydra/core#>';

result = union result,ns;

ns = foreach ns generate 
	'@base',
	'',
	'<http://example.com/base>';

result = union result,ns;

result = distinct result;

dump result;