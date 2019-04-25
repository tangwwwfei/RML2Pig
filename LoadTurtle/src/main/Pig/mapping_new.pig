REGISTER ./out/artifacts/LoadTurtle_jar/LoadTurtle.jar;
DEFINE extractJson my.udf.extractJson;
DEFINE extractXML my.udf.extractXML;
DEFINE extractCSV my.udf.extractCSV;
DEFINE FORMAT my.udf.FORMAT;
DEFINE CONCAT_STRBAG my.udf.CONCAT_STRBAG;
DEFINE toBag my.udf.toBag;
DEFINE toTuple my.udf.toTuple;

%default rr '<http://www.w3.org/ns/r2rml#%s>'
%default rml '<http://semweb.mmlab.be/ns/rml#%s>'
%default ql '<http://semweb.mmlab.be/ns/ql#%s>'
%default transit '<http://vocab.org/transit/terms/%s>'
%default xsd '<http://www.w3.org/2001/XMLSchema#%s>'
%default wgs84_pos '<http://www.w3.org/2003/01/geo/wgs84_pos#%s>'
%default rdf '<http://www.w3.org/1999/02/22-rdf-syntax-ns#%s>'
%default rr '<http://www.w3.org/ns/r2rml#%s>'
%default ex '<http://example.com/ns#%s>'
%default rdfs '<http://www.w3.org/2000/01/rdf-schema#%s>'

--Generate LogicalSources and subjectMaps
    %default AirportMapping_source 'Airport.csv'
    %default AirportMapping_iterator ''
    %default AirportMapping_formulation 'ql:CSV'
    %default AirportMapping_template 'http://airport.example.com/{id}'
    AirportMapping_data = load '${AirportMapping_source}' using LoadSourceData('${AirportMapping_formulation}') as (cont:chararray);

    %default LocationMapping_CSV_source 'Airport.csv'
    %default LocationMapping_CSV_iterator ''
    %default LocationMapping_CSV_formulation 'ql:CSV'
    %default LocationMapping_CSV_template 'http://loc.example.com/latlong/{latitude},{longitude}'
    LocationMapping_CSV_data = load '${LocationMapping_CSV_source}' using LoadSourceData('${LocationMapping_CSV_formulation}') as (cont:chararray);

     %default VenueMapping_source 'Venue.json'
    %default VenueMapping_iterator '$'
    %default VenueMapping_formulation 'ql:JSONPath'
    %default VenueMapping_template 'http://loc.example.com/city/{$.venue[*].location.city}'
    VenueMapping_data =  load '${VenueMapping_source}' using LoadSourceData('${VenueMapping_formulation}') as (cont:chararray);

    %default LocationMapping_JSON_source 'Venue.json'
    %default LocationMapping_JSON_iterator '$'
    %default LocationMapping_JSON_formulation 'ql:JSONPath'
    %default LocationMapping_JSON_template 'http://loc.example.com/latlong/{$.venue[*].latitude},{$.venue[*].longitude}'
    LocationMapping_JSON_data =  load '${LocationMapping_JSON_source}' using LoadSourceData('${LocationMapping_JSON_formulation}') as (cont:chararray);

    %default TransportMapping_source 'Transport.xml'
    %default TransportMapping_iterator '/transport/bus'
    %default TransportMapping_formulation 'ql:XPath'
    %default TransportMapping_template 'http://trans.example.com/bus/{@id}'
    TransportMapping_data =  load '${TransportMapping_source}' using LoadSourceData('${TransportMapping_formulation}') as (cont:chararray);

    %default StopMapping_source 'Transport.xml'
    %default StopMapping_iterator '/transport/bus/route/stop'
    %default StopMapping_formulation 'ql:XPath'
    %default StopMapping_template 'http://trans.example.com/stop/{@id}'
    StopMapping_data =  load '${StopMapping_source}' using LoadSourceData('${StopMapping_formulation}') as (cont:chararray);


    AirportMapping_table = foreach AirportMapping_data generate
        FLATTEN(extractCSV(
            cont,
            '${AirportMapping_iterator}',
            toTuple('http://airport.example.com/{id}'),--0
            toTuple('${LocationMapping_CSV_template}'),--1
            toTuple('bus'),--2
            toTuple('city')--3
        ));

    LocationMapping_CSV_table = foreach LocationMapping_CSV_data generate
            FLATTEN(extractCSV(
                cont,
                '${LocationMapping_CSV_iterator}',
                toTuple('http://loc.example.com/latlong/{latitude},{longitude}'),--0
                toTuple('latitude'),--1
                toTuple('longitude')
            ));

    VenueMapping_table = foreach VenueMapping_data generate
            FLATTEN(extractJson(
                cont,
                '${VenueMapping_iterator}',
                toTuple('http://loc.example.com/city/{$.venue[*].location.city}'),--0
                toTuple('${LocationMapping_JSON_template}'),--
                toTuple('$.venue[*].location.country'),--2
                toTuple('$.venue[*].location.continent'),--3
                toTuple('$.venue[*].location.city')--4
            ));

    LocationMapping_JSON_table = foreach LocationMapping_JSON_data generate
            FLATTEN(extractJson(
                cont,
                '${LocationMapping_JSON_iterator}',
                toTuple('http://loc.example.com/latlong/{$.venue[*].latitude},{$.venue[*].longitude}'),--0
                toTuple('$.venue[*].latitude'),--1
                toTuple('$.venue[*].longitude')--2
            ));

    TransportMapping_table = foreach TransportMapping_data generate
                FLATTEN(extractXML(
                    cont,
                    '${TransportMapping_iterator}',
                    toTuple('http://trans.example.com/bus/{@id}'),--0
                    toTuple('http://trans.example.com/vehicle/{@type}'),--1
                    toTuple('${StopMapping_template}'),--2
                    toTuple('/transport/bus@id')--3
                ));

    StopMapping_table = foreach StopMapping_data generate
                FLATTEN(extractXML(
                    cont,
                    '${StopMapping_iterator}',
                    toTuple('http://trans.example.com/stop/{@id}'),--0
                    toTuple('@id'),--1
                    toTuple('.')
                ));
--dump StopMapping_table;
    --template
    AirportMapping_subjectMap = foreach AirportMapping_table generate
        FORMAT('${AirportMapping_template}',$0),
        'rdf:type',
        'ex:Stop';
    RDFS = AirportMapping_subjectMap;

    --parentTriplesMap without joinCondition
    AirportMapping_predicateObjectMap1 = foreach AirportMapping_table generate
            FORMAT('${AirportMapping_template}',$0),
            'ex:latlong',
            FORMAT('${LocationMapping_CSV_template}',$1);

    RDFS = union RDFS, AirportMapping_predicateObjectMap1;

    --parentTriplesMap with joinCondition
    child = foreach AirportMapping_table generate
            FLATTEN($2),    --child
            FORMAT('${AirportMapping_template}',$0);
    parent = foreach TransportMapping_table generate
            FLATTEN($3),--parent
            FORMAT('${TransportMapping_template}',$0);
    AirportMapping_predicateObjectMap2 = join child by $0, parent by $0;
    AirportMapping_predicateObjectMap2 = foreach AirportMapping_predicateObjectMap2 generate
        $1,
        'ex:route',
        $3;
    RDFS = union RDFS,AirportMapping_predicateObjectMap2;

    --parentTriplesMap with joinCondition
    child = foreach AirportMapping_table generate
            FLATTEN($3),    --child
            FORMAT('${AirportMapping_template}',$0);
    parent = foreach VenueMapping_table generate
            FLATTEN($4),--parent
            FORMAT('${VenueMapping_template}',$0);
    AirportMapping_predicateObjectMap2 = join child by $0, parent by $0;
    AirportMapping_predicateObjectMap2 = foreach AirportMapping_predicateObjectMap2 generate
        $1,
        'ex:location',
        $3;
    RDFS = union RDFS,AirportMapping_predicateObjectMap2;



--output RDFS
RDFS = distinct RDFS;
RDFS = order RDFS by $0;
--RDFS = union (foreach RDFS generate '@prefix','rr:','<http://www.w3.org/ns/r2rml#>'),RDFS;
RDFS = distinct RDFS;
dump RDFS;