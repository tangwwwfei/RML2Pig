REGISTER file:///E:/RML2PigAndScala/LoadTurtle/target/LoadTurtle.jar;
DEFINE R2PFORMAT r2ps.udf.pig.R2PFORMAT;
DEFINE R2PTOBAG r2ps.udf.pig.R2PTOBAG;
DEFINE R2PTOTUPLE r2ps.udf.pig.R2PTOTUPLE;
DEFINE equalCondition r2ps.udf.pig.equalCondition;
DEFINE execFunction r2ps.udf.pig.execFunction;
%default TriplesMap1_source '{"iterator":"","referenceFormulation":"","query":"","sqlVersion":"rr:SQL2008","tableName":"IOUs","name":"","database":{"jdbcDSN":"CONNECTIONDSN","jdbcDriver":"org.postgresql.Driver","username":"postgres","password":""}}'

%default TriplesMap1_referenceFormulation ''

%default TriplesMap1_iterator ''

%default TriplesMap1_template '_:{fname}_{lname}_{amount}'

TriplesMap1_data = load 'UnusedPath' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMap1_source}','[["fname,lname,amount"],["fname"],["lname"],["amount"]]') as (f1:tuple(chararray,chararray,chararray),f2:tuple(chararray),f3:tuple(chararray),f4:tuple(chararray));

TriplesMap1_table = foreach TriplesMap1_data generate 
	R2PFORMAT('${TriplesMap1_template}', $0),
	$0,
	$1,
	$2,
	$3;

%default TriplesMap2_source '{"iterator":"","referenceFormulation":"","query":"","sqlVersion":"rr:SQL2008","tableName":"Lives","name":"","database":{"jdbcDSN":"CONNECTIONDSN","jdbcDriver":"org.postgresql.Driver","username":"postgres","password":""}}'

%default TriplesMap2_referenceFormulation ''

%default TriplesMap2_iterator ''

%default TriplesMap2_template '_:{fname}_{lname}_{city}'

TriplesMap2_data = load 'UnusedPath' using r2ps.udf.pig.R2PLOADSOURCE('${TriplesMap2_source}','[["fname,lname,city"],["fname"],["lname"],["city"]]') as (f1:tuple(chararray,chararray,chararray),f2:tuple(chararray),f3:tuple(chararray),f4:tuple(chararray));

TriplesMap2_table = foreach TriplesMap2_data generate 
	R2PFORMAT('${TriplesMap2_template}', $0),
	$0,
	$1,
	$2,
	$3;

TriplesMap1_subjectMap = TriplesMap1_table;

TriplesMap2_subjectMap = TriplesMap2_table;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'rdf:type',
	'<http://example.com/base/IOUs>';

result = TriplesMap1_objectMap;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'<http://example.com/base/IOUs#fname>',
	R2PFORMAT('"%s"',$2);

result = union result,TriplesMap1_objectMap;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'<http://example.com/base/IOUs#lname>',
	R2PFORMAT('"%s"',$3);

result = union result,TriplesMap1_objectMap;

TriplesMap1_objectMap = TriplesMap1_table;

TriplesMap1_objectMap = foreach TriplesMap1_objectMap generate 
	$0,
	'<http://example.com/base/IOUs#amount>',
	R2PFORMAT('"%s"',$4);

result = union result,TriplesMap1_objectMap;

TriplesMap2_objectMap = TriplesMap2_table;

TriplesMap2_objectMap = foreach TriplesMap2_objectMap generate 
	$0,
	'rdf:type',
	'<http://example.com/base/Lives>';

result = union result,TriplesMap2_objectMap;

TriplesMap2_objectMap = TriplesMap2_table;

TriplesMap2_objectMap = foreach TriplesMap2_objectMap generate 
	$0,
	'<http://example.com/base/IOUs#fname>',
	R2PFORMAT('"%s"',$2);

result = union result,TriplesMap2_objectMap;

TriplesMap2_objectMap = TriplesMap2_table;

TriplesMap2_objectMap = foreach TriplesMap2_objectMap generate 
	$0,
	'<http://example.com/base/IOUs#lname>',
	R2PFORMAT('"%s"',$3);

result = union result,TriplesMap2_objectMap;

TriplesMap2_objectMap = TriplesMap2_table;

TriplesMap2_objectMap = foreach TriplesMap2_objectMap generate 
	$0,
	'<http://example.com/base/IOUs#city>',
	R2PFORMAT('"%s"',$4);

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
	'rdf:',
	'<http://www.w3.org/1999/02/22-rdf-syntax-ns#>';

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