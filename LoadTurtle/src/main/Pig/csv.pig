REGISTER C:/Users/tangs/OneDrive/source/LoadTurtle/out/artifacts/LoadTurtle_jar/LoadTurtle.jar;
REGISTER C:/Users/tangs/.m2/repository/com/twitter/elephantbird/elephant-bird-pig/4.17/elephant-bird-pig-4.17.jar;

DEFINE extractJson my.udf.extractJson;
DEFINE extractXML my.udf.extractXML;
DEFINE extractCSV my.udf.extractCSV;
DEFINE extract my.udf.extract;
DEFINE CONCAT_STRBAG my.udf.CONCAT_STRBAG;
DEFINE toBag my.udf.toBag;
DEFINE toTuple my.udf.toTuple;
DEFINE FORMAT my.udf.FORMAT;
DEFINE equalCondition my.udf.equalCondition;
DEFINE Fallback my.udf.Fallback;

%default PersonMapping_source '{"iterator":"","referenceFormulation":"ql:CSV","query":"","sqlVersion":"","tableName":"","name":"persons.csv"}'

%default PersonMapping_iterator ''

%default PersonMapping_template 'http://example.org/person/{PersonId}{Name}'

PersonMapping_data = load 'persons.csv' using my.udf.LoadSource('${PersonMapping_source}') as (cont:chararray);

PersonMapping_table = foreach PersonMapping_data generate
	FLATTEN(extractCSV(cont,
	'',
	'${PersonMapping_iterator}',
	toTuple('PersonId','Name'),
	toTuple('Name'),
	toTuple('Email'),
	toTuple('Phone'),
	toTuple('Birthdate'),
	toTuple('Height'),
	toTuple('Weight')
	));
--dump PersonMapping_table;
PersonMapping_subjectMaps = foreach PersonMapping_table generate
	FORMAT('<${PersonMapping_template}>',$0),
	'rdf:type',
	'foaf:Person';
RDFS = PersonMapping_subjectMaps;

PersonMapping_predicateObjectMap = foreach PersonMapping_table generate
	FORMAT('<${PersonMapping_template}>',$0),
	FLATTEN(toBag('foaf:name')),
	FLATTEN(toBag(FORMAT('"%s"',$1)));
RDFS = union RDFS,PersonMapping_predicateObjectMap;

PersonMapping_predicateObjectMap = foreach PersonMapping_table generate
	FORMAT('<${PersonMapping_template}>',$0),
	FLATTEN(toBag('foaf:mbox')),
	FLATTEN(toBag(FORMAT('<mailto:%s>',$2)));
RDFS = union RDFS,PersonMapping_predicateObjectMap;

PersonMapping_predicateObjectMap = foreach PersonMapping_table generate
	FORMAT('<${PersonMapping_template}>',$0),
	FLATTEN(toBag('foaf:phone')),
	FLATTEN(toBag(FORMAT('<tel:%s>',$3)));
RDFS = union RDFS,PersonMapping_predicateObjectMap;

PersonMapping_predicateObjectMap = foreach PersonMapping_table generate
	FORMAT('<${PersonMapping_template}>',$0),
	FLATTEN(toBag('schema:birthDate')),
	FLATTEN(toBag(FORMAT('"%s"^^xsd:dateTime',$4)));
RDFS = union RDFS,PersonMapping_predicateObjectMap;

PersonMapping_predicateObjectMap = foreach PersonMapping_table generate
	FORMAT('<${PersonMapping_template}>',$0),
	FLATTEN(toBag('schema:birthDate')),
	FLATTEN(toBag(FORMAT('"%s"^^xsd:decimal',$5)));
RDFS = union RDFS,PersonMapping_predicateObjectMap;

PersonMapping_predicateObjectMap = foreach PersonMapping_table generate
	FORMAT('<${PersonMapping_template}>',$0),
	FLATTEN(toBag('schema:birthDate')),
	FLATTEN(toBag(FORMAT('"%s"^^xsd:decimal',$6)));
RDFS = union RDFS,PersonMapping_predicateObjectMap;

ns = foreach RDFS generate
	'@prefix',
	'rr:',
	'http://www.w3.org/ns/r2rml#.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@prefix',
	'rml:',
	'http://semweb.mmlab.be/ns/rml#.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@prefix',
	'ql:',
	'http://semweb.mmlab.be/ns/ql#.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@prefix',
	'xsd:',
	'http://www.w3.org/2001/XMLSchema#.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@prefix',
	'ex:',
	'http://www.example.org/.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@prefix',
	'foaf:',
	'http://xmlns.com/foaf/0.1/.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@prefix',
	'schema:',
	'http://schema.org/.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@base',
	'',
	'http://example.org/.';
RDFS = union RDFS,ns;

RDFS = distinct RDFS;
dump RDFS;