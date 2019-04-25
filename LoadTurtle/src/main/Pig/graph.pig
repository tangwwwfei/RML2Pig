REGISTER ./out/artifacts/LoadTurtle_jar/LoadTurtle.jar;
DEFINE extract my.udf.extract;
DEFINE FORMAT my.udf.FORMAT;
DEFINE toBag my.udf.toBag;
DEFINE toTuple my.udf.toTuple;
DEFINE equalCondition my.udf.equalCondition;
DEFINE execFunction my.udf.execFunction;
%default Companies_source '{"iterator":"","referenceFormulation":"ql:CSV","query":"","sqlVersion":"","tableName":"","name":"src/test/resources/exampleFallback/Companies.csv"}'

%default Companies_referenceFormulation 'ql:CSV'

%default Companies_iterator ''

%default Companies_template 'http://ex.com/comp/{id}'

Companies_data = load 'src/test/resources/exampleFallback/Companies.csv' using my.udf.LoadSource('${Companies_source}') as (data:chararray);

%default City_DBpedia_source '{"iterator":"/sparql:sparql/sparql:results/sparql:result","referenceFormulation":"ql:XPath","query":"SELECT+DISTINCT+%3FcountryName+%3Fcountry+WHERE+%7B%0D%0A%3Fcountry+a+dbo%3ACountry%3B+rdfs%3Alabel+%3FcountryName+.%0D%0AFILTER+%28+lang%28%3FcountryName%29+%3D+%2522en%2522+%29+%7D%0D%0AORDER+BY+DESC%28%3FcountryName%29%0D%0ALIMIT+7000","sqlVersion":"","tableName":"","name":"","sparql":{"endpoint":"http://dbpedia.org/sparql/","supportedLanguage":"sd:SPARQL11Query","resultFormat":"http://www.w3.org/ns/formats/SPARQL_Results_XML"}}'

%default City_DBpedia_referenceFormulation 'ql:XPath'

%default City_DBpedia_iterator '/sparql:sparql/sparql:results/sparql:result'

%default City_DBpedia_template 'sparql:binding/sparql:uri'

City_DBpedia_data = load 'UnusedPath' using my.udf.LoadSource('${City_DBpedia_source}') as (data:chararray);

%default Country_Local_source '{"iterator":"","referenceFormulation":"ql:CSV","query":"","sqlVersion":"","tableName":"","name":"src/test/resources/exampleFallback/Companies.csv"}'

%default Country_Local_referenceFormulation 'ql:CSV'

%default Country_Local_iterator ''

%default Country_Local_template 'http://ex.com/country/{country}'

Country_Local_data = load 'src/test/resources/exampleFallback/Companies.csv' using my.udf.LoadSource('${Country_Local_source}') as (data:chararray);

%default Country_DBpedia_source '{"iterator":"/sparql:sparql/sparql:results/sparql:result","referenceFormulation":"ql:XPath","query":"SELECT+DISTINCT+%3FcountryName+%3Fcountry+WHERE+%7B%0D%0A%3Fcountry+a+dbo%3ACountry%3B+rdfs%3Alabel+%3FcountryName+.%0D%0AFILTER+%28+lang%28%3FcountryName%29+%3D+%2522en%2522+%29+%7D%0D%0AORDER+BY+DESC%28%3FcountryName%29%0D%0ALIMIT+7000","sqlVersion":"","tableName":"","name":"","sparql":{"endpoint":"http://dbpedia.org/sparql/","supportedLanguage":"sd:SPARQL11Query","resultFormat":"http://www.w3.org/ns/formats/SPARQL_Results_XML"}}'

%default Country_DBpedia_referenceFormulation 'ql:XPath'

%default Country_DBpedia_iterator '/sparql:sparql/sparql:results/sparql:result'

%default Country_DBpedia_template 'sparql:binding/sparql:uri'

Country_DBpedia_data = load 'UnusedPath' using my.udf.LoadSource('${Country_DBpedia_source}') as (data:chararray);

Companies_table = foreach Companies_data generate
	FLATTEN(extract(data,
	'${Companies_referenceFormulation}',
	'${Companies_iterator}',
	toTuple('id'),
	toTuple('country')));
Companies_table = foreach Companies_table generate
	FORMAT('${Companies_template}', $0),
	$0,
	$1;

City_DBpedia_table = foreach City_DBpedia_data generate
	FLATTEN(extract(data,
	'${City_DBpedia_referenceFormulation}',
	'${City_DBpedia_iterator}',
	toTuple('/sparql:sparql/sparql:results/sparql:result/sparql:binding/sparql:uri')));
City_DBpedia_table = foreach City_DBpedia_table generate
	FORMAT('${City_DBpedia_template}', $0),
	$0;

Country_Local_table = foreach Country_Local_data generate
	FLATTEN(extract(data,
	'${Country_Local_referenceFormulation}',
	'${Country_Local_iterator}',
	toTuple('country')));
Country_Local_table = foreach Country_Local_table generate
	FORMAT('${Country_Local_template}', $0),
	$0;

Country_DBpedia_table = foreach Country_DBpedia_data generate
	FLATTEN(extract(data,
	'${Country_DBpedia_referenceFormulation}',
	'${Country_DBpedia_iterator}',
	toTuple('/sparql:sparql/sparql:results/sparql:result/sparql:binding/sparql:uri'),
	toTuple('sparql:binding/sparql:literal')));
Country_DBpedia_table = foreach Country_DBpedia_table generate
	FORMAT('${Country_DBpedia_template}', $0),
	$0,
	$1;

Companies_subjectMap = Companies_table;

Companies_subjectMap = foreach Companies_subjectMap generate
	$0,
	'rdf:type',
	'ex:Company';
RDFS = Companies_subjectMap;

City_DBpedia_subjectMap = City_DBpedia_table;

Country_Local_subjectMap = Country_Local_table;

Country_DBpedia_subjectMap = Country_DBpedia_table;

child = foreach Companies_table generate
	$0,
	$2;
parent = foreach Country_DBpedia_table generate
	$0,
	$2;
Companies_predicateObjectMap = join child by ($1), parent by ($1);

Companies_predicateObjectMap = foreach Companies_predicateObjectMap generate
	$0,
	'ex:country',
	$2;
RDFS = union RDFS,Companies_predicateObjectMap;

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
	'crml:',
	'http://semweb.mmlab.be/ns/crml#.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@prefix',
	'ql:',
	'http://semweb.mmlab.be/ns/ql#.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@prefix',
	'rdfs:',
	'http://www.w3.org/2000/01/rdf-schema#.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@prefix',
	'xsd:',
	'http://www.w3.org/2001/XMLSchema#.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@prefix',
	'dcat:',
	'http://www.w3.org/ns/dcat#.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@prefix',
	'sd:',
	'http://www.w3.org/ns/sparql-service-description#.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@prefix',
	'dcterms:',
	'http://purl.org/dc/terms/.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@prefix',
	'ex:',
	'http://example.com/.';
RDFS = union RDFS,ns;

ns = foreach RDFS generate
	'@base',
	'',
	'http://example.com/base.';
RDFS = union RDFS,ns;

RDFS = distinct RDFS;
dump RDFS;