REGISTER file:///E:/RML2PigAndScala/LoadTurtle/target/LoadTurtle.jar;
DEFINE R2PFORMAT r2ps.udf.pig.R2PFORMAT;
DEFINE R2PTOBAG r2ps.udf.pig.R2PTOBAG;
DEFINE R2PTOTUPLE r2ps.udf.pig.R2PTOTUPLE;
DEFINE equalCondition r2ps.udf.pig.equalCondition;
DEFINE execFunction r2ps.udf.pig.execFunction;
%default TriplesMap1_source '{"iterator":"","referenceFormulation":"","query":"SELECT+Code%2C+Name%2C+Lan+FROM+Country+WHERE+Lan+%3D+%27EN%27%3B","sqlVersion":"rr:SQL2008","tableName":"","name":"","database":{"jdbcDSN":"CONNECTIONDSN","jdbcDriver":"com.microsoft.sqlserver.jdbc.SQLServerDriver","username":"sa","password":"YourSTRONG!Passw0rd;"}}'

%default TriplesMap1_referenceFormulation ''

%default TriplesMap1_iterator ''

%default TriplesMap1_template '<http://example.com/{Code}>'

TriplesMap1_data = load 'UnusedPath' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMap1_source}','[["Code"],["Name"]]') as (f1:tuple(chararray),f2:tuple(chararray));

TriplesMap1_table = foreach TriplesMap1_data generate 
	R2PFORMAT('${TriplesMap1_template}', $0),
	$0,
	$1;

%default TriplesMap2_source '{"iterator":"","referenceFormulation":"","query":"SELECT+%22Code%22%2C+%22Name%22%2C+%22Lan%22+FROM+%22Country%22+WHERE+%22Lan%22+%3D+%27ES%27%3B","sqlVersion":"rr:SQL2008","tableName":"","name":"","database":{"jdbcDSN":"CONNECTIONDSN","jdbcDriver":"com.microsoft.sqlserver.jdbc.SQLServerDriver","username":"sa","password":"YourSTRONG!Passw0rd;"}}'

%default TriplesMap2_referenceFormulation ''

%default TriplesMap2_iterator ''

%default TriplesMap2_template '<http://example.com/{Code}>'

TriplesMap2_data = load 'UnusedPath' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMap2_source}','[["Code"],["Name"]]') as (f1:tuple(chararray),f2:tuple(chararray));

TriplesMap2_table = foreach TriplesMap2_data generate 
	R2PFORMAT('${TriplesMap2_template}', $0),
	$0,
	$1;

TriplesMap1_subjectMap = TriplesMap1_table;

TriplesMap2_subjectMap = TriplesMap2_table;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'rdfs:label',
	R2PFORMAT('"%s"@english',$2);

result = TriplesMap1_objectMap;

TriplesMap2_objectMap = TriplesMap2_table;

TriplesMap2_objectMap = foreach TriplesMap2_objectMap generate 
	$0,
	'rdfs:label',
	R2PFORMAT('"%s"@spanish',$2);

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
	'd2rq:',
	'<http://www.wiwiss.fu-berlin.de/suhl/bizer/D2RQ/0.1#>';

result = union result,ns;

ns = foreach ns generate 
	'@base',
	'',
	'<http://example.com/base/>';

result = union result,ns;

result = distinct result;

dump result;