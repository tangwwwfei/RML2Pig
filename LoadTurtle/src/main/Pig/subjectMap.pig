REGISTER C:/Users/tangs/.m2/repository/org/apache/pig/piggybank/0.14.0/piggybank-0.14.0.jar;
REGISTER ./out/artifacts/LoadTurtle_jar/LoadTurtle.jar;
DEFINE extract my.udf.extract;
DEFINE toBag my.udf.toBag;
DEFINE toTuple my.udf.toTuple;
DEFINE FORMAT my.udf.FORMAT;
DEFINE equalCondition my.udf.equalCondition;
DEFINE execFunction my.udf.execFunction;

%default TM1_iterator ''
%default TM1_referenceFormulation 'ql:CSV'
%default TM1_paramters '{"name":"Airport_b.csv"}'

TM1_data = load 'Airport_b.csv' using LoadSourceData('${TM1_paramters}') as (data:chararray);

TM1_table = foreach TM1_data generate 
    FLATTEN(extract(data,
      '${TM1_referenceFormulation}',
      '${TM1_iterator}',
      toTuple('id'),
      toTuple('city')
    ));

%default Companies_iterator ''
%default Companies_referenceFormulation 'ql:CSV'
%default Companies_paramters '{"name":"Companies.csv"}'
Companies_data = load '{Companies.csv' using LoadSourceData('${Companies_paramters}') as (data:chararray);
Companies_table = foreach Companies_data generate 
    FLATTEN(extract(data,
      '${Companies_referenceFormulation}',
      '${Companies_iterator}',
      toTuple('id'),
      toTuple('country')
          ));
Companies_table = foreach Companies_table generate 
      FORMAT('${template}', $0)
      toTuple('id'),
      toTuple('country')
          ));

%default TM1_template '<http://ex.com/comp/{id}>'

subject = TM1_table;
--subjectMap
--first process conditions
subject = FILTER subject BY equalCondition(TOBAG(TOTUPLE($0,'id')), '!match(%%id%%,"6523")');
--dump TM1_table;
--second process functionMaps
subject = FOREACH subject GENERATE execFunction(TOTUPLE('fno:executes','http://users.ugent.be/~bjdmeest/function/grel.ttl#toUppercase'),TOTUPLE('http://users.ugent.be/~bjdmeest/function/grel.ttl#valueParameter',$1));
--subject = FOREACH 'alias' GENERATE 'expression';
--third generate RDF triples
subject = FOREACH subject GENERATE FORMAT('${TM1_template}',$0), 'rdf:type', 'transit:Stop';
RDFs = subject;
--RDFs = union RDFs,subject;


--predicateObjectMap
--condition
com_pom1 = FILTER Companies_table BY equalCondition(TOBAG(TOTUPLE($1, 'country')), '!match(%%country%%,"NewZealand")');
--process normal predicateMaps and objectMaps
--fallback
com_pom2 = FILTER Companies_table BY not equalCondition(TOBAG(TOTUPLE($1, 'country')), '!match(%%country%%,"NewZealand")');
--process fallback predicateMaps and objectMaps
com_pom1 = UNION com_pom1, com_pom2;


--predicateMap

--objectMap


--RefObjectMap
--Case 1. with condition and fallback
--first process conditions
refObjectMap1 = FILTER TM1_table BY equalCondition(TOBAG(TOTUPLE($0,'id')), '!match(%%country%%,"NewZealand")');
--process normal p-o maps
--second process fallback
refObjectMap2 = FILTER TM1_table BY not equalCondition(TOBAG(TOTUPLE($0,'id')), '!match(%%country%%,"NewZealand")');
--process fallback refobjMaps
refObjectMap1 = UNION refObjectMap1, refObjectMap2;
--Case 2. No condition with fallback
--diff ls ,no jc, no bc
--diff ls ,witch jc 