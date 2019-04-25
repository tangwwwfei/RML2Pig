--REGISTER C:/Users/tangs/.m2/repository/org/apache/pig/piggybank/0.15.0/piggybank-0.15.0.jar;
REGISTER C:/source/LoadTurtle/out/artifacts/LoadTurtle_jar/LoadTurtle.jar;
DEFINE XPath org.apache.pig.piggybank.evaluation.xml.XPath();
DEFINE extractXML my.udf.extractXML;
DEFINE FORMAT my.udf.FORMAT;
src_data =  load 'transport.xml' using org.apache.pig.piggybank.storage.XMLLoader('transport') as (xml:chararray);
subjectMaps = foreach src_data generate FLATTEN(extractXML(xml, '/transport/bus/@id',true,false)), 'rdf:type', 'transit:Stop', xml;
subjectMaps = foreach subjectMaps generate FLATTEN($0) as id, $1 as predicate, $2 as object, $3 as x;

preobjMap1 = foreach subjectMaps generate id, 'transit:stop', FLATTEN(extractXML(x, FORMAT('/transport/bus[@id="%s"]/route/stop/@id',id)));
preobjMap1 = foreach preobjMap1 generate $0 as subject, $1 as predicate, FLATTEN($2) as object;

preobjMap2 = foreach subjectMaps generate id, 'rdfs:label', FLATTEN(extractXML(x, FORMAT('/transport/bus[@id="%s"]/route/stop',id)));
preobjMap2 = foreach preobjMap2 generate $0 as subject, $1 as predicate, FLATTEN($2) as object;




