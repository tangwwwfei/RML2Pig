REGISTER file:///E:/RML2PigAndScala/LoadTurtle/target/LoadTurtle.jar;
DEFINE R2PFORMAT r2ps.udf.pig.R2PFORMAT;
DEFINE R2PTOBAG r2ps.udf.pig.R2PTOBAG;
DEFINE R2PTOTUPLE r2ps.udf.pig.R2PTOTUPLE;
DEFINE equalCondition r2ps.udf.pig.equalCondition;
DEFINE execFunction r2ps.udf.pig.execFunction;
%default TriplesMap1_source '{"iterator":"","referenceFormulation":"","query":"SELECT+FirstName%2C+LastName+FROM+student","sqlVersion":"","tableName":"student","name":"","database":{"jdbcDSN":"CONNECTIONDSN","jdbcDriver":"com.mysql.cj.jdbc.Driver","username":"root","password":""}}'

%default TriplesMap1_referenceFormulation ''

%default TriplesMap1_iterator ''

%default TriplesMap1_template '<http://example.com/{ID}/{Name}>'

TriplesMap1_data = load 'UnusedPath' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMap1_source}','[["ID,Name"],["IDs"]]') as (f1:tuple(chararray,chararray),f2:tuple(chararray));

TriplesMap1_table = foreach TriplesMap1_data generate 
	R2PFORMAT('${TriplesMap1_template}', $0),
	$0,
	$1;

TriplesMap1_subjectMap = TriplesMap1_table;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'ex:id',
	R2PFORMAT('"%s"',$2);

result = TriplesMap1_objectMap;

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

ns = foreach ns generate 
	'@prefix',
	'd2rq:',
	'<http://www.wiwiss.fu-berlin.de/suhl/bizer/D2RQ/0.1#>';

result = union result,ns;

result = distinct result;

dump result;