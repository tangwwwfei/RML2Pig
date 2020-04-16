DROP TABLE IF EXISTS Patient;

CREATE TABLE Patient (
ID INTEGER,
FirstName VARCHAR(50),
LastName VARCHAR(50),
Sex VARCHAR(6),
Weight FLOAT,
Height FLOAT,
BirthDate DATE,
EntranceDate TIMESTAMP,
PaidInAdvance BOOLEAN,
Photo BYTEA,
PRIMARY KEY (ID)
);

INSERT INTO Patient (ID, FirstName,LastName,Sex,Weight,Height,BirthDate,EntranceDate,PaidInAdvance,Photo)
VALUES (10,'Monica','Geller','female',80.25,1.65,'1981-10-10','2009-10-10 12:12:22',FALSE,
'\\x89504E470D0A1A0A0000000D49484452000000050000000508060000008D6F26E50000001C4944415408D763F9FFFEBFC37F062005C3201284D031F18258CD04000EF535CBD18E0E1F0000000049454E44AE426082');

INSERT INTO Patient (ID, FirstName,LastName,Sex,Weight,Height,BirthDate,EntranceDate,PaidInAdvance,Photo)
VALUES (11,'Rachel','Green','female',70.22,1.70,'1982-11-12','2008-11-12 09:45:44',TRUE,
'\\x89504E470D0A1A0A0000000D49484452000000050000000508060000008D6F26E50000001C4944415408D763F9FFFF3FC37F062005C3201284D031F18258CD04000EF535CBD18E0E1F0000000049454E44AE426082');

INSERT INTO Patient (ID, FirstName,LastName,Sex,Weight,Height,BirthDate,EntranceDate,PaidInAdvance,Photo)
VALUES (12,'Chandler','Bing','male',90.31,1.76,'1978-04-06','2007-03-12 02:13:14',TRUE,
'\\x89504E470D0A1A0A0000000D49484452000000050000000508060000008D6F26E50000001C4944415408D763F9FFFEBFC37F062005C3201284D031F18258CD04000EF535CBD18E0E1F0000000049454E44AE426082');
