REGISTER ./out/artifacts/LoadTurtle_jar/LoadTurtle.jar;
DEFINE R2PEXTRACT my.udf.R2PEXTRACT;
DEFINE R2PFORMAT my.udf.R2PFORMAT;
DEFINE R2PTOBAT my.udf.toBag;
DEFINE R2PTOTUPLE my.udf.toTuple;
DEFINE equalCondition my.udf.equalCondition;
DEFINE execFunction my.udf.execFunction;
%default TriplesMap1_source '{"iterator":"/Persons/Person","referenceFormulation":"ql:XPath","query":"","sqlVersion":"","tableName":"","name":"persons.xml"}'

%default TriplesMap1_referenceFormulation 'ql:XPath'

%default TriplesMap1_iterator '/Persons/Person'

%default TriplesMap1_template '{fname}{lname}'

TriplesMap1_data = load 'persons.xml' using my.udf.R2PLOADSOURCE('${TriplesMap1_source}') as (data:chararray);

%default TriplesMap2_source '{"iterator":"/Lives/Live","referenceFormulation":"ql:XPath","query":"","sqlVersion":"","tableName":"","name":"lives.xml"}'

%default TriplesMap2_referenceFormulation 'ql:XPath'

%default TriplesMap2_iterator '/Lives/Live'

%default TriplesMap2_template '{fname}{lname}'

TriplesMap2_data = load 'lives.xml' using my.udf.R2PLOADSOURCE('${TriplesMap2_source}') as (data:chararray);

TriplesMap2_table = foreach TriplesMap2_data generate 
	FLATTEN(R2PEXTRACT(data,
	'${TriplesMap2_referenceFormulation}',
	'${TriplesMap2_iterator}',
	R2PTOTUPLE('/Lives/Live/fname,/Lives/Live/lname'),
	R2PTOTUPLE('/Lives/Live/city')));
TriplesMap2_table = foreach TriplesMap2_table generate 
	R2PFORMAT('${TriplesMap2_template}', $0),
	$0,
	$1;

TriplesMap1_table = foreach TriplesMap1_data generate 
	FLATTEN(R2PEXTRACT(data,
	'${TriplesMap1_referenceFormulation}',
	'${TriplesMap1_iterator}',
	R2PTOTUPLE('/Persons/Person/fname,/Persons/Person/lname')));
TriplesMap1_table = foreach TriplesMap1_table generate 
	R2PFORMAT('${TriplesMap1_template}', $0),
	$0;

TriplesMap1_subjectMap = TriplesMap1_table;

TriplesMap2_subjectMap = TriplesMap2_table;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'foaf:name',
	R2PFORMAT('"%s %s"',$1);
result = TriplesMap1_objectMap;

TriplesMap2_objectMap = TriplesMap2_table;

TriplesMap2_objectMap = foreach TriplesMap2_objectMap generate 
	$0,
	'ex:city',
	R2PFORMAT('"%s"',$2);
result = union result,TriplesMap2_objectMap;

ns = foreach result generate 
	'@prefix',
	'rr:',
	'http://www.w3.org/ns/r2rml#.';
result = union result,ns;

ns = foreach result generate 
	'@prefix',
	'foaf:',
	'http://xmlns.com/foaf/0.1/.';
result = union result,ns;

ns = foreach result generate 
	'@prefix',
	'ex:',
	'http://example.com/.';
result = union result,ns;

ns = foreach result generate 
	'@prefix',
	'xsd:',
	'http://www.w3.org/2001/XMLSchema#.';
result = union result,ns;

ns = foreach result generate 
	'@prefix',
	'rml:',
	'http://semweb.mmlab.be/ns/rml#.';
result = union result,ns;

ns = foreach result generate 
	'@prefix',
	'ql:',
	'http://semweb.mmlab.be/ns/ql#.';
result = union result,ns;

ns = foreach result generate 
	'@base',
	'',
	'http://example.com/base/.';
result = union result,ns;

result = distinct result;