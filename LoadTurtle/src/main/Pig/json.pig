--REGISTER C:/source/LoadTurtle/out/artifacts/LoadTurtle_jar/LoadTurtle.jar;
REGISTER C:/Users/tangs/.m2/repository/org/apache/pig/piggybank/0.14.0/piggybank-0.14.0.jar;
DEFINE CSVLoader org.apache.pig.piggybank.storage.CSVLoader();
DEFINE extractJson my.udf.extractJson;
DEFINE FORMAT my.udf.FORMAT;
DEFINE equalCondition my.udf.equalCondition;
DEFINE Fallback my.udf.Fallback;
%default source1 'http://www.example.com/files/Venue.json'
%default iterator1 '$'
%default formulation1 'ql:JSONPath'

student = load 'C:\\Users\\tangs\\student.csv' using CSVLoader(',') as (ID:int, Name:chararray, Class:chararray,
 Sport:int, SportName:chararray);
sport = load 'C:\\Users\\tangs\\sport.csv' using CSVLoader(',')as (ID:int, Name:chararray, UID:int);

/*
student = load 'student.csv' using CSVLoader(',') as (ID:int, Name:chararray, Class:chararray,
 Sport:int, SportName:chararray);
sport = load 'sport.csv' using CSVLoader(',')as (ID:int, Name:chararray, UID:int);

*/

c = foreach student generate ID,Name,Sport,SportName;
p = foreach sport generate ID,Name,UID;

j = join c by Sport, p by ID;
f = filter j by equalCondition(c::SportName,p::Name,'extra condition');

gc = group c all;
gp = group p all;
cp = cross gc,gp;
rcp = foreach cp generate FLATTEN(Fallback(COUNT(c),$3,$1));

dump rcp;