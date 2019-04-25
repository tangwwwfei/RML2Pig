REGISTER ./out/artifacts/LoadTurtle_jar/LoadTurtle.jar;
DEFINE extractJson my.udf.extractJson;
DEFINE extractXML my.udf.extractXML;
DEFINE extractCSV my.udf.extractCSV;
DEFINE FORMAT my.udf.FORMAT;
DEFINE LoadSourceData my.udf.LoadSourceData;

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
--<#AirportMapping>
    --<LogicalSource>

    %default AirportMapping_source 'Airport.csv'
    %default AirportMapping_iterator ''
    %default AirportMapping_formulation 'ql:CSV'
    %default AirportMapping_template '<http://airport.example.com/%s>'

    AirportMapping_data = load '${AirportMapping_source}' using LoadSourceData('${AirportMapping_formulation}') as (cont:chararray);
    --<LogicalSource End>
    --<subjectMap>
    AirportMapping_subjectMaps = foreach AirportMapping_data generate
        FLATTEN(extractCSV(cont,'id')) as subject,
        FORMAT('${rdf}','type') as predicate,
        FORMAT('${ex}','Stop') as object,
        cont;
    AirportMapping_subjectMaps = foreach AirportMapping_subjectMaps generate
        FLATTEN($0) as subject,
        FLATTEN($1) as predicate,
        FLATTEN($2) as object,
        $3 as cont;
    AirportMapping_subjectMaps_fullname = foreach AirportMapping_subjectMaps generate
        FORMAT('${AirportMapping_template}',subject) as subject,
        predicate as predicate,
        object as object;
    --first time
    RDFS = foreach AirportMapping_subjectMaps_fullname generate subject, predicate, object;
    --second time --RDFS = RDFS union subjectMaps;
    --<SubjectMap End>
--<#AirportMappingEnd>

--<#LocationMapping_CSV>
    --<LogicalSource>
    %default LocationMapping_CSV_source 'Airport.csv'
    %default LocationMapping_CSV_iterator ''
    %default LocationMapping_CSV_formulation 'ql:CSV'
    %default LocationMapping_CSV_template '<http://loc.example.com/latlong/%s,%s>'
    LocationMapping_CSV_data = load '${LocationMapping_CSV_source}' using LoadSourceData('${LocationMapping_CSV_formulation}') as (cont:chararray);
    --<LogicalSource End>
    --<subjectMap>
    LocationMapping_CSV_subjectMaps = foreach LocationMapping_CSV_data generate FLATTEN(extractCSV(cont,'latitude', 'longitude')) as subject, cont;
    LocationMapping_CSV_subjectMaps = foreach LocationMapping_CSV_subjectMaps generate FLATTEN($0) as subject, $1 as cont;
    LocationMapping_CSV_subjectMaps_fullname = foreach LocationMapping_CSV_subjectMaps generate FORMAT('${LocationMapping_CSV_template}', $0,$1) as subject;
    --<SubjectMap End>
--<#LocationMapping_CSV End>

--<#VenueMapping>
    --<LogicalSource>
    %default VenueMapping_source 'Venue.json'
    %default VenueMapping_iterator '$'
    %default VenueMapping_formulation 'ql:JSONPath'
    %default VenueMapping_template '<http://loc.example.com/city/%s>'
    VenueMapping_data =  load '${VenueMapping_source}' using LoadSourceData('${VenueMapping_formulation}') as (cont:chararray);
    --dump VenueMapping_data;
    --<LogicalSource End>
    --<subjectMap>
    VenueMapping_subjectMaps = foreach VenueMapping_data generate
        FLATTEN(extractJson(cont,'$.venue[*].location.city')) as subject,
        FORMAT('${rdf}','type') as predicate,
        FORMAT('${ex}','City') as object,cont;
    VenueMapping_subjectMaps = foreach VenueMapping_subjectMaps generate
        FLATTEN($0) as subject,
        FLATTEN($1) as predicate,
        FLATTEN($2) as object, $3 as cont;
    --dump VenueMapping_subjectMaps;
    VenueMapping_subjectMaps_fullname = foreach VenueMapping_subjectMaps generate
        FORMAT('${VenueMapping_template}',subject) as subject,
        predicate as predicate,
        object as object;
    RDFS = union RDFS,VenueMapping_subjectMaps_fullname;
    --dump VenueMapping_subjectMaps_fullname;
    --<subjectMap End>
--<#VenueMapping End>

--<#LocationMapping_JSON>
    --<LogicalSource>
    %default LocationMapping_JSON_source 'Venue.json'
    %default LocationMapping_JSON_iterator '$'
    %default LocationMapping_JSON_formulation 'ql:JSONPath'
    %default LocationMapping_JSON_template '<http://loc.example.com/latlong/%s,%s>'
    LocationMapping_JSON_data =  load '${LocationMapping_JSON_source}' using LoadSourceData('${LocationMapping_JSON_formulation}') as (cont:chararray);
    --<LogicalSource End>
    --<subjectMap>
    LocationMapping_JSON_subjectMaps = foreach LocationMapping_JSON_data generate
        FLATTEN(extractJson(cont,'$.venue[*].latitude', '$.venue[*].longitude')) as subject,
        cont;
    LocationMapping_JSON_subjectMaps = foreach LocationMapping_JSON_subjectMaps generate FLATTEN($0), $1 as cont;
    LocationMapping_JSON_subjectMaps_fullname = foreach LocationMapping_JSON_subjectMaps generate FORMAT('${LocationMapping_JSON_template}',$0,$1) as subject;
    --dump LocationMapping_JSON_subjectMaps;
    --<subjectMap End>
--<#LocationMapping_JSON End>

--<#TransportMapping>
    --<LogicalSource>
    %default TransportMapping_source 'Transport.xml'
    %default TransportMapping_iterator '/transport/bus'
    %default TransportMapping_formulation 'ql:XPath'
    %default TransportMapping_template '<http://trans.example.com/bus/%s>'
    TransportMapping_data =  load '${TransportMapping_source}' using LoadSourceData('${TransportMapping_formulation}') as (cont:chararray);
    --<LogicalSource End>
    --<subjectMap>
    TransportMapping_subjectMaps = foreach TransportMapping_data generate
         FLATTEN(extractXML(cont,'${TransportMapping_iterator}/@id')) as subject,
         FORMAT('${rdf}','type') as predicate,
         FORMAT('${ex}','Transport') as object,
         cont;
    --dump TransportMapping_subjectMaps;
    TransportMapping_subjectMaps = foreach TransportMapping_subjectMaps generate
        FLATTEN($0) as subject, FLATTEN($1) as predicate, FLATTEN($2) as object, $3 as cont;
    TransportMapping_subjectMaps_fullname = foreach TransportMapping_subjectMaps generate
        FORMAT('${TransportMapping_template}',subject) as subject, predicate as predicate, object as object;
    RDFS = union RDFS, TransportMapping_subjectMaps_fullname;
    --<subjectMap End>
--<#TransportMapping End>

--<#StopMapping>
    --<LogicalSource>
    %default StopMapping_source 'Transport.xml'
    %default StopMapping_iterator '/transport/bus/route/stop'
    %default StopMapping_formulation 'ql:XPath'
    %default StopMapping_template '<http://trans.example.com/bus/%s>'
    StopMapping_data =  load '${StopMapping_source}' using LoadSourceData('${StopMapping_formulation}') as (cont:chararray);
    --<LogicalSource End>
    --<subjectMap>
    StopMapping_subjectMaps = foreach StopMapping_data generate FLATTEN(extractXML(cont,'${StopMapping_iterator}/@id')) as subject,FORMAT('${rdf}','type') as predicate,FORMAT('${ex}','Stop') as object,cont;
    StopMapping_subjectMaps = foreach StopMapping_subjectMaps generate FLATTEN($0) as subject, FLATTEN($1) as predicate, FLATTEN($2) as object, $3 as cont;
    StopMapping_subjectMaps_fullname = foreach StopMapping_subjectMaps generate FORMAT('${StopMapping_template}',subject) as subject, predicate as predicate, object as object;
    RDFS = union RDFS, StopMapping_subjectMaps_fullname;
    --<subjectMap End>
--<#StopMapping End>
dump RDFS;

--Generate PredicateObjectMaps
--<#AirportMapping>
    --Generate PredicateObjectMap1
    AirportMapping_preobjMap1 = cross (foreach AirportMapping_subjectMaps_fullname generate subject, FORMAT('${ex}','latlong')),
        (foreach LocationMapping_CSV_subjectMaps_fullname generate subject);
    RDFS = union RDFS, AirportMapping_preobjMap1;
    --Generate PredicateObjectMap2
    childMap = foreach AirportMapping_subjectMaps generate FORMAT('${AirportMapping_template}',subject), FORMAT('${ex}', 'route'),FLATTEN(extractCSV(cont, 'bus'));
    childMap = foreach childMap generate FLATTEN($0) as subject, FLATTEN($1) as predicate, FLATTEN($2) as child;
    parentMap = foreach TransportMapping_subjectMaps generate subject, FLATTEN(extractXML(cont, FORMAT('/transport/bus[@id="%s"]/@id', subject))) as parent;
    parentMap = foreach parentMap generate FLATTEN($0) as subject, FLATTEN($1) as parent;
    parentMap = foreach parentMap generate FORMAT('${TransportMapping_template}',subject), parent as parent;
    AirportMapping_preobjMap2 = join childMap by child, parentMap by parent;
    RDFS = union RDFS, (foreach AirportMapping_preobjMap2 generate $0, $1, $3);
    --Generate PredicateObjectMap3
    A = foreach AirportMapping_subjectMaps generate FORMAT('${AirportMapping_template}',subject), FORMAT('${ex}', 'location'),FLATTEN(extractCSV(cont, 'city'));
    A = foreach A generate FLATTEN($0) as subject, FLATTEN($1) as predicate, FLATTEN($2) as child;
    B = foreach VenueMapping_subjectMaps generate subject, subject as parent;
    B = foreach B generate FORMAT('${VenueMapping_template}',subject), parent;
    AirportMapping_preobjMap3 = join A by child, B by parent;
    RDFS = union RDFS, (foreach AirportMapping_preobjMap3 generate $0, $1, $3);
--<#AirportMapping End>

--<#LocationMapping_JSON>
    LocationMapping_JSON_preobjMap1 = foreach LocationMapping_JSON_subjectMaps generate
        FORMAT('${LocationMapping_JSON_template}', $0,$1),
        FORMAT('${ex}', 'lat'),
        $0;
    RDFS = union RDFS, LocationMapping_JSON_preobjMap1;
    LocationMapping_JSON_preobjMap2 = foreach LocationMapping_JSON_subjectMaps generate
        FORMAT('${LocationMapping_JSON_template}', $0,$1),
        FORMAT('${ex}', 'long'),
        $1;
    RDFS = union RDFS, LocationMapping_JSON_preobjMap2;
--<#LocationMapping_JSON End>

--<#VenueMapping>
    VenueMapping_preobjMap1 = foreach VenueMapping_data generate
        FLATTEN(extractJson(cont,'$.venue[*].location.city','$.venue[*].latitude','$.venue[*].longitude')),
        'lat','longt';
    VenueMapping_preobjMap1 = foreach VenueMapping_preobjMap1 generate
        FLATTEN($0),$1,$2;
    VenueMapping_preobjMap1 = foreach VenueMapping_preobjMap1 generate
        FORMAT('${VenueMapping_template}',$0) as subject,
        FORMAT('${ex}', 'latlong'),
        FORMAT('${LocationMapping_JSON_template}',$1,$2) as object;
    RDFS = union RDFS, VenueMapping_preobjMap1;

    VenueMapping_preobjMap2 = foreach VenueMapping_subjectMaps generate
        FORMAT('${VenueMapping_template}',subject),
        FORMAT('${ex}','countryCode'),
        FLATTEN(extractJson(cont, FORMAT('$.venue[*].location[?(@.city==\'%s\')].country', subject)));
        --                               '$.venue[*].location[?(@.city==\'%s\')].country'
    VenueMapping_preobjMap2 = foreach VenueMapping_preobjMap2 generate
        $0 as subject,
        $1 as predicate,
        FLATTEN($2) as object;
     RDFS = union RDFS, VenueMapping_preobjMap2;

     VenueMapping_preobjMap3 = foreach VenueMapping_subjectMaps generate
         FORMAT('${VenueMapping_template}',subject),
         FORMAT('${ex}','onContinent'),
         FLATTEN(extractJson(cont, FORMAT('$.venue[*].location[?(@.city==\'%s\')].continent', subject)));
     VenueMapping_preobjMap3 = foreach VenueMapping_preobjMap3 generate $0 as subject,$1 as predicate, FLATTEN($2) as object;
     RDFS = union RDFS, VenueMapping_preobjMap3;
--<#VenueMapping End>

--<#LocationMapping_CSV>
    LocationMapping_CSV_preobjMap1 = foreach LocationMapping_CSV_subjectMaps generate
         FORMAT('${LocationMapping_CSV_template}', $0,$1),
         FORMAT('${ex}', 'lat'),
         $0;
    RDFS = union RDFS, LocationMapping_CSV_preobjMap1;
    LocationMapping_CSV_preobjMap2 = foreach LocationMapping_CSV_subjectMaps generate
         FORMAT('${LocationMapping_CSV_template}', $0,$1),
         FORMAT('${ex}', 'long'),
         $1;
    RDFS = union RDFS, LocationMapping_CSV_preobjMap1;
--<#LocationMapping_CSV End>

--output RDFS
RDFS = distinct RDFS;
RDFS = order RDFS by subject;
--RDFS = union (foreach RDFS generate '@prefix','rr:','<http://www.w3.org/ns/r2rml#>'),RDFS;
RDFS = distinct RDFS;
--dump RDFS;