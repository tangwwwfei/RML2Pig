REGISTER file:///E:/RML2PigAndScala/LoadTurtle/target/LoadTurtle.jar;
DEFINE R2PFORMAT r2ps.udf.pig.R2PFORMAT;
DEFINE R2PTOBAG r2ps.udf.pig.R2PTOBAG;
DEFINE R2PTOTUPLE r2ps.udf.pig.R2PTOTUPLE;
DEFINE equalCondition r2ps.udf.pig.equalCondition;
DEFINE execFunction r2ps.udf.pig.execFunction;
%default Country_source '{"iterator":"$.results.bindings[*]","referenceFormulation":"ql:JSONPath","query":"PREFIX+rdfs%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E+PREFIX+foaf%3A+%3Chttp%3A%2F%2Fxmlns.com%2Ffoaf%2F0.1%2F%3E+PREFIX+rdf%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E+SELECT+%3FFirstName+%3FLastName+%3FID+WHERE+%7B+%3Fx+foaf%3AfirstName+%3FFirstName+%3B+foaf%3AlastName+%3FLastName+%3B+rdf%3AID+%3FID+.+%7D","sqlVersion":"","tableName":"","name":"","sparql":{"endpoint":"http://localhost:PORT/ds1/sparql","supportedLanguage":"sd:SPARQL11Query","resultFormat":"http://www.w3.org/ns/formats/SPARQL_Results_JSON"}}'

%default Country_referenceFormulation 'ql:JSONPath'

%default Country_iterator '$.results.bindings[*]'

%default Country_template '<http://example.com/Student/{ID.value}/{FirstName.value}>'

Country_data = load 'UnusedPath' using r2ps.udf.pig.R2PLOADSOURCE('${Country_source}','[["$.results.bindings[*].ID.value,$.results.bindings[*].FirstName.value"],["$.results.bindings[*].FirstName.value"]]') as (f1:tuple(chararray,chararray),f2:tuple(chararray));

Country_table = foreach Country_data generate 
	R2PFORMAT('${Country_template}', $0),
	$0,
	$1;

Country_subjectMap = Country_table;

Country_objectMap = Country_table;

Country_objectMap = foreach Country_objectMap generate 
	$0,
	'rdf:type',
	'foaf:Person',
	FLATTEN(R2PTOBAG('ex:PersonGraph'));

result = Country_objectMap;

Country_objectMap = Country_table;

Country_objectMap = foreach Country_objectMap generate 
	$0,
	'foaf:name',
	R2PFORMAT('"%s"',$2),
	FLATTEN(R2PTOBAG('ex:PersonGraph'));

result = union result,Country_objectMap;

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