REGISTER C:/Users/tangs/.m2/repository/org/apache/pig/piggybank/0.14.0/piggybank-0.14.0.jar;
REGISTER ./out/artifacts/LoadTurtle_jar/LoadTurtle.jar;
DEFINE CSVLoader org.apache.pig.piggybank.storage.CSVLoader();
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

%default TM1_iterator ''
%default TM1_referenceFormulation 'ql:CSV'
%default TM1_paramters '{"name":"Companies.csv"}'

TM1_data = load 'Companies.csv' using LoadSourceData('${TM1_paramters}') as (data:chararray);

TM1_table = foreach TM1_data generate 
    FLATTEN(extract(data,
      '${TM1_referenceFormulation}',
      '${TM1_iterator}',
      toTuple('id'),
      toTuple('country'),
      toTuple('country')
    ));

%default TM1_template '<http://ex.com/comp/{id}>'

%default TM2_iterator ''
%default TM2_referenceFormulation 'ql:CSV'
%default TM2_paramters '{"name":"Companies.csv"}'
TM2_data = load 'Companies.csv' using LoadSourceData('${TM1_paramters}') as (data:chararray);
TM2_table = foreach TM2_data generate 
FLATTEN(extract(cont,
  '${TM2_referenceFormulation}',
  '${TM2_iterator}',
  toTuple('country')
));

%default TM2_template '<http://ex.com/country/{country}>'

%default TM3_iterator ''
%default TM3_referenceFormulation 'ql:CSV'
%default TM3_paramters '{"name":"Companies.csv"}'
TM3_data = load 'Companies.csv' using LoadSourceData('${TM1_paramters}') as (data:chararray);
TM3_table = foreach TM3_data generate 
FLATTEN(extract(cont,
  '${TM3_referenceFormulation}',
  '${TM3_iterator}',
  toTuple('country')
));
%default TM3_template '<http://dbpedia.org/resource/{country}>'

TM1_subjects = foreach TM1_table generate
  FORMAT('${TM1_template}',$0),
  'rdf:type',
  FLATTEN(toBag('ex:Company'));

RDFs = TM1_subjects;

--reference variable condition
TM1_pom1 = FILTER TM1_table BY equalCondition(toTuple($2), toTuple('country'),'!match(%%country%%,"NewZealand")');
TM1_pom1 = foreach TM1_pom1 generate
  FORMAT('${TM1_template}',$0),
  FLATTEN(toBag('ex:country')),
  FORMAT('${TM3_template}',$1);

TM1_pom2 = FILTER TM1_table BY not equalCondition(toTuple($2), toTuple('country'),'!match(%%country%%,"NewZealand")');
TM1_pom2 = foreach TM1_pom2 generate
  FORMAT('${TM1_template}',$0),
  FLATTEN(toBag('ex:country2')), 
  FORMAT('${TM2_template}',$2);

TM1_pom1 = union TM1_pom1,TM1_pom2;

RDFs = union RDFs,TM1_pom1;
dump RDFs;