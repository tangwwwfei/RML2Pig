DEFINE TM1_iterator ''
DEFINE TM1_referenceFormulation 'ql:CSV'
DEFINE TM1_paramters '{"name":"Companies.csv"}'

TM1_data = load 'Companies.csv' using LoadSourceData('${TM1_paramters}') as (data:chararray);
TM1_table = foreach TM1_data generate 
FLATTEN(extract(cont,
  '${TM1_referenceFormulation}',
  '${TM1_iterator}',
  toTuple('id'),
  toTuple('country'),
  toTuple('country')
));
DEFINE TM1_template 'http://ex.com/comp/{id}'

DEFINE TM2_iterator ''
DEFINE TM2_referenceFormulation 'ql:CSV'
DEFINE TM2_paramters '{"name":"Companies.csv"}'
TM2_data = load 'Companies.csv' using LoadSourceData('${TM1_paramters}') as (data:chararray);
TM2_table = foreach TM2_data generate 
FLATTEN(extract(cont,
  '${TM2_referenceFormulation}',
  '${TM2_iterator}',
  toTuple('country')
));

DEFINE TM2_template 'http://ex.com/country/{country}'

DEFINE TM3_iterator ''
DEFINE TM3_referenceFormulation 'ql:CSV'
DEFINE TM3_paramters '{"name":"Companies.csv"}'
TM3_data = load 'Companies.csv' using LoadSourceData('${TM1_paramters}') as (data:chararray);
TM3_table = foreach TM3_data generate 
FLATTEN(extract(cont,
  '${TM3_referenceFormulation}',
  '${TM3_iterator}',
  toTuple('country')
));
DEFINE TM3_template 'http://dbpedia.org/resource/{country}'

TM1_subjects=foreach TM1_data generate 
  FORMAT('${TM1_template}',$0),
  'rdf:type',
  toBag('ex:Company');

RDFs = RDFs union TM1_subjects;

--reference variable condition
TM1_pom1 = foreach TM1_data generate
  FORMAT('${TM1_template}',$0),
  FLATTEN(toBag('ex:country')),
  FORMAT('${TM3_template}',$1);
TM1_pom1 = FILTER TM1_pom1 BY equalCondition($3, 'country','!match(%%country%%,\%22NewZealand\%22)');

TM1_pom2=foreach TM1_table generate
  FORMAT('${TM1_template}',$0),
  FLATTEN(toBag('ex:country2')), 
  FORMAT('${TM2_template}',$2);

TM1_pom1 = filter TM1_pom1 by 
  ($0 is not null) and 
  ($1 is not null) and 
  ($2 is not null); 
gpom1 = group TM1_pom1 all;
gpom2 = group TM1_pom2 all;
cgp = cross gpom1,gpom2;
TM1_pom=foreach cgp generate 
FLATTEN(Fallback(COUNT(TM1_pom1),
$1,$3));

RDFs = union RDFs,TM1_pom1;