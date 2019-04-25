REGISTER ./out/artifacts/LoadTurtle_jar/LoadTurtle.jar;
DEFINE extractJson my.udf.extractJson;
DEFINE extractXML my.udf.extractXML;
DEFINE extractCSV my.udf.extractCSV;
DEFINE FORMAT my.udf.FORMAT;
DEFINE LoadSourceData my.udf.LoadSourceData;
%default rml '<http://semweb.mmlab.be/ns/rml#%s>'

%default ql '<http://semweb.mmlab.be/ns/ql#%s>'

%default rr '<http://www.w3.org/ns/r2rml#%s>'

%default ex '<http://example.com/ns#%s>'

%default xsd '<http://www.w3.org/2001/XMLSchema#%s>'

%default rdf '<http://www.w3.org/2000/01/rdf-schema#%s>'

%default AirportMapping_source 'airport.csv'

%default AirportMapping_iterator 'org.eclipse.m2m.atl.engine.emfvm.lib.OclUndefined@1c6a7a06'

%default AirportMapping_formulation 'ql:CSV'

AirportMapping_data = load 'airport.csv' using LoadSourceData('${AirportMapping_formulation}') as (cont:chararray);

%default AirportMapping_template '<http://airport.example.com/%s>'

AirportMapping_subjectMaps = foreach AirportMapping_data generate
	FLATTEN(extractCSV(cont,'id')) as subject,
	'rdf:type' as predicate,
	ex:Stop as object,
	cont;
AirportMapping_subjectMaps = foreach AirportMapping_subjectMaps generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as object,
	$3 as cont;
AirportMapping_subjectMaps_fullname = foreach AirportMapping_subjectMaps generate
	FORMAT('${AirportMapping_template}',$0) as subject,
	predicate as predicate,
	object as object;
RDFS = foreach AirportMapping_subjectMaps_fullname generate
	$0,
	$1,
	$2;
%default LocationMapping_CSV_source 'airport.csv'

%default LocationMapping_CSV_iterator 'org.eclipse.m2m.atl.engine.emfvm.lib.OclUndefined@1c6a7a06'

%default LocationMapping_CSV_formulation 'ql:CSV'

LocationMapping_CSV_data = load 'airport.csv' using my.udf.LoadSourceData('${LocationMapping_CSV_formulation}') as (cont:chararray);

%default LocationMapping_CSV_template '<http://loc.example.com/latlong/%s,%s>'

LocationMapping_CSV_subjectMaps = foreach LocationMapping_CSV_data generate
	FLATTEN(extractCSV(cont,'latitude','longitude')) as subject,
	cont,
	' ';
LocationMapping_CSV_subjectMaps = foreach LocationMapping_CSV_subjectMaps generate
	FLATTEN($0) as subject,
	$1 as subject2,
	$2 as cont;
LocationMapping_CSV_subjectMaps_fullname = foreach LocationMapping_CSV_subjectMaps generate
	FORMAT('${LocationMapping_CSV_template}',$0,$1) as subject;
%default VenueMapping_source 'Venue.json'

%default VenueMapping_iterator '$'

%default VenueMapping_formulation 'ql:JSONPath'

VenueMapping_data = load 'Venue.json' using my.udf.LoadSourceData('${VenueMapping_formulation}') as (cont:chararray);

%default VenueMapping_template '<http://loc.example.com/city/%s>'

VenueMapping_subjectMaps = foreach VenueMapping_data generate
	FLATTEN(extractJson(cont,'$.venue[*].location.city')) as subject,
	'rdf:type' as predicate,
	ex:City as object,
	cont;
VenueMapping_subjectMaps = foreach VenueMapping_subjectMaps generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as object,
	$3 as cont;
VenueMapping_subjectMaps_fullname = foreach VenueMapping_subjectMaps generate
	FORMAT('${VenueMapping_template}',$0) as subject,
	predicate as predicate,
	object as object;
RDFS = union VenueMapping_subjectMaps_fullname,RDFS;

%default LocationMapping_JSON_source 'Venue.json'

%default LocationMapping_JSON_iterator '$'

%default LocationMapping_JSON_formulation 'ql:JSONPath'

LocationMapping_JSON_data = load 'Venue.json' using my.udf.LoadSourceData('${LocationMapping_JSON_formulation}') as (cont:chararray);

%default LocationMapping_JSON_template '<http://loc.example.com/latlong/%s,%s>'

LocationMapping_JSON_subjectMaps = foreach LocationMapping_JSON_data generate
	FLATTEN(extractJson(cont,'$.venue[*].latitude','$.venue[*].longitude')) as subject,
	cont,
	' ';
LocationMapping_JSON_subjectMaps = foreach LocationMapping_JSON_subjectMaps generate
	FLATTEN($0) as subject,
	$1 as subject2,
	$2 as cont;
LocationMapping_JSON_subjectMaps_fullname = foreach LocationMapping_JSON_subjectMaps generate
	FORMAT('${LocationMapping_JSON_template}',$0,$1) as subject;
%default TransportMapping_source 'transport.xml'

%default TransportMapping_iterator '/transport/bus'

%default TransportMapping_formulation 'ql:XPath'

TransportMapping_data = load 'transport.xml' using my.udf.LoadSourceData('${TransportMapping_formulation}') as (cont:chararray);

%default TransportMapping_template '<http://trans.example.com/bus/%s>'

TransportMapping_subjectMaps = foreach TransportMapping_data generate
	FLATTEN(extractXML(cont,'${TransportMapping_iterator}/@id')) as subject,
	'rdf:type' as predicate,
	ex:Transport as object,
	cont;
TransportMapping_subjectMaps = foreach TransportMapping_subjectMaps generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as object,
	$3 as cont;
TransportMapping_subjectMaps_fullname = foreach TransportMapping_subjectMaps generate
	FORMAT('${TransportMapping_template}',$0) as subject,
	predicate as predicate,
	object as object;
RDFS = union TransportMapping_subjectMaps_fullname,RDFS;

%default StopMapping_source 'transport.xml'

%default StopMapping_iterator '/transport/bus/route/stop'

%default StopMapping_formulation 'ql:XPath'

StopMapping_data = load 'transport.xml' using my.udf.LoadSourceData('${StopMapping_formulation}') as (cont:chararray);

%default StopMapping_template '<http://trans.example.com/stop/%s>'

StopMapping_subjectMaps = foreach StopMapping_data generate
	FLATTEN(extractXML(cont,'${StopMapping_iterator}/@id')) as subject,
	'rdf:type' as predicate,
	ex:Stop as object,
	cont;
StopMapping_subjectMaps = foreach StopMapping_subjectMaps generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as object,
	$3 as cont;
StopMapping_subjectMaps_fullname = foreach StopMapping_subjectMaps generate
	FORMAT('${StopMapping_template}',$0) as subject,
	predicate as predicate,
	object as object;
RDFS = union StopMapping_subjectMaps_fullname,RDFS;

A = foreach AirportMapping_subjectMaps_fullname generate
	subject,
	'ex:latlong';
B = foreach LocationMapping_CSV_subjectMaps_fullname generate
	subject;
AirportMapping_preobjMap1 = cross A,B;

RDFS = union RDFS,AirportMapping_preobjMap1;


A = foreach AirportMapping_subjectMaps generate
	FORMAT('${AirportMapping_template}',subject),
	'ex:route',
	FLATTEN(extractCSV(cont, 'bus'));
A = foreach A generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as child;
B = foreach TransportMapping_subjectMaps generate
	subject,
	FLATTEN(extractXML(cont, FORMAT('/transport/bus[@id="%s"]/@id', subject))) as parent;
B = foreach B generate
	FLATTEN($0) as subject,
	FLATTEN($1) as parent;
B = foreach B generate
	FORMAT('${TransportMapping_template}',subject),
	parent as parent;
AirportMapping_preobjMap2 = join A by child, B by parent;

AirportMapping_preobjMap2 = foreach AirportMapping_preobjMap2 generate
	$0,
	$1,
	$3;
RDFS = union RDFS,AirportMapping_preobjMap2;


A = foreach AirportMapping_subjectMaps generate
	FORMAT('${AirportMapping_template}',subject),
	'ex:location',
	FLATTEN(extractCSV(cont, 'city'));
A = foreach A generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as child;
B = foreach VenueMapping_subjectMaps generate
	subject,
	FLATTEN(extractJson(cont, FORMAT('$.venue[*].location[?(@.city==\'%s\')].city', subject))) as parent;
B = foreach B generate
	FLATTEN($0) as subject,
	FLATTEN($1) as parent;
B = foreach B generate
	FORMAT('${VenueMapping_template}',subject),
	parent as parent;
AirportMapping_preobjMap3 = join A by child, B by parent;

AirportMapping_preobjMap3 = foreach AirportMapping_preobjMap3 generate
	$0,
	$1,
	$3;
RDFS = union RDFS,AirportMapping_preobjMap3;


LocationMapping_CSV_preobjMap4 = foreach LocationMapping_CSV_subjectMaps generate
	FORMAT('${LocationMapping_CSV_template}', $0,$1),
	'ex:lat',
	FLATTEN(extractCSV(cont, FORMAT('latitude', $0)));
LocationMapping_CSV_preobjMap4 = foreach LocationMapping_CSV_preobjMap4 generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as object;
RDFS = union LocationMapping_CSV_preobjMap4,RDFS;


LocationMapping_CSV_preobjMap5 = foreach LocationMapping_CSV_subjectMaps generate
	FORMAT('${LocationMapping_CSV_template}', $0,$1),
	'ex:long',
	FLATTEN(extractCSV(cont, FORMAT('longitude', $1)));
LocationMapping_CSV_preobjMap5 = foreach LocationMapping_CSV_preobjMap5 generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as object;
RDFS = union LocationMapping_CSV_preobjMap5,RDFS;


A = foreach VenueMapping_subjectMaps_fullname generate
	subject,
	'ex:latlong';
B = foreach LocationMapping_JSON_subjectMaps_fullname generate
	subject;
VenueMapping_preobjMap6 = cross A,B;

RDFS = union RDFS,VenueMapping_preobjMap6;


VenueMapping_preobjMap7 = foreach VenueMapping_subjectMaps generate
	FORMAT('${VenueMapping_template}', $0),
	'ex:countryCode',
	FLATTEN(extractJson(cont, FORMAT('$.venue[*].location[?(@.city==\'%s\')].country', $0)));
VenueMapping_preobjMap7 = foreach VenueMapping_preobjMap7 generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as object;
RDFS = union VenueMapping_preobjMap7,RDFS;


VenueMapping_preobjMap8 = foreach VenueMapping_subjectMaps generate
	FORMAT('${VenueMapping_template}', $0),
	'ex:onContinent',
	FLATTEN(extractJson(cont, FORMAT('$.venue[*].location[?(@.city==\'%s\')].continent', $0)));
VenueMapping_preobjMap8 = foreach VenueMapping_preobjMap8 generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as object;
RDFS = union VenueMapping_preobjMap8,RDFS;


LocationMapping_JSON_preobjMap9 = foreach LocationMapping_JSON_subjectMaps generate
	FORMAT('${LocationMapping_JSON_template}', $0,$1),
	'ex:lat',
	FLATTEN(extractJson(cont, FORMAT('$.venue[*][?(@.longitude==\'%s\')].latitude', $0)));
LocationMapping_JSON_preobjMap9 = foreach LocationMapping_JSON_preobjMap9 generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as object;
RDFS = union LocationMapping_JSON_preobjMap9,RDFS;


LocationMapping_JSON_preobjMap10 = foreach LocationMapping_JSON_subjectMaps generate
	FORMAT('${LocationMapping_JSON_template}', $0,$1),
	'ex:long',
	FLATTEN(extractJson(cont, FORMAT('$.venue[*][?(@.longitude==\'%s\')].longitude', $1)));
LocationMapping_JSON_preobjMap10 = foreach LocationMapping_JSON_preobjMap10 generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as object;
RDFS = union LocationMapping_JSON_preobjMap10,RDFS;


TransportMapping_preobjMap11 = foreach TransportMapping_subjectMaps generate
	FORMAT('${TransportMapping_template}', $0),
	'ex:type',
	FLATTEN(extractXML(cont, FORMAT('${TransportMapping_iterator}[@type="%s"]/@type', $0)));
TransportMapping_preobjMap11 = foreach TransportMapping_preobjMap11 generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as object;
RDFS = union TransportMapping_preobjMap11,RDFS;


A = foreach TransportMapping_subjectMaps_fullname generate
	subject,
	'ex:stop';
B = foreach StopMapping_subjectMaps_fullname generate
	subject;
TransportMapping_preobjMap12 = cross A,B;

RDFS = union RDFS,TransportMapping_preobjMap12;


StopMapping_preobjMap13 = foreach StopMapping_subjectMaps generate
	FORMAT('${StopMapping_template}', $0),
	'ex:stop',
	FLATTEN(extractXML(cont, FORMAT('${StopMapping_iterator}[@id="%s"]/@id', $0)));
StopMapping_preobjMap13 = foreach StopMapping_preobjMap13 generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as object;
RDFS = union StopMapping_preobjMap13,RDFS;


StopMapping_preobjMap14 = foreach StopMapping_subjectMaps generate
	FORMAT('${StopMapping_template}', $0),
	'ex:stopLabel',
	FLATTEN(extractXML(cont, FORMAT('.', $0)));
StopMapping_preobjMap14 = foreach StopMapping_preobjMap14 generate
	FLATTEN($0) as subject,
	FLATTEN($1) as predicate,
	FLATTEN($2) as object;
RDFS = union StopMapping_preobjMap14,RDFS;


