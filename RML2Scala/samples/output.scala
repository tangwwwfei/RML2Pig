import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import r2ps.udf.scala.ScalaUDF.R2PLOADSOURCE
import r2ps.udf.scala.ScalaUDF.R2PEXTRACT
import r2ps.udf.scala.ScalaUDF.R2PTOTUPLE
import mt.R2PFORMAT
import mt.createDF

object test extends App {
	val spark = SparkSession
		.builder()
		.appName("RML2SCALA")
		.master("local")
		.getOrCreate()
	val sqlContext = spark.sqlContext
	var sparkContext = spark.sparkContext
	import spark.implicits._

	val AirportMapping_source = """{"iterator":"","referenceFormulation":"ql:CSV","query":"","sqlVersion":"","tableName":"","name":"Airport.csv"}"""

	val AirportMapping_referenceFormulation = """ql:CSV"""

	val AirportMapping_iterator = """"""

	val AirportMapping_template = """http://airport.example.com/{id}"""

	var AirportMapping_data = R2PLOADSOURCE(AirportMapping_source)

	val LocationMapping_CSV_source = """{"iterator":"","referenceFormulation":"ql:CSV","query":"","sqlVersion":"","tableName":"","name":"Airport.csv"}"""

	val LocationMapping_CSV_referenceFormulation = """ql:CSV"""

	val LocationMapping_CSV_iterator = """"""

	val LocationMapping_CSV_template = """http://loc.example.com/latlong/{latitude},{longitude}"""

	var LocationMapping_CSV_data = R2PLOADSOURCE(LocationMapping_CSV_source)

	val VenueMapping_source = """{"iterator":"$","referenceFormulation":"ql:JSONPath","query":"","sqlVersion":"","tableName":"","name":"Venue.json"}"""

	val VenueMapping_referenceFormulation = """ql:JSONPath"""

	val VenueMapping_iterator = """$"""

	val VenueMapping_template = """http://loc.example.com/city/{$.venue[*].location.city}"""

	var VenueMapping_data = R2PLOADSOURCE(VenueMapping_source)

	val LocationMapping_JSON_source = """{"iterator":"$","referenceFormulation":"ql:JSONPath","query":"","sqlVersion":"","tableName":"","name":"Venue.json"}"""

	val LocationMapping_JSON_referenceFormulation = """ql:JSONPath"""

	val LocationMapping_JSON_iterator = """$"""

	val LocationMapping_JSON_template = """http://loc.example.com/latlong/{$.venue[*].latitude},{$.venue[*].longitude}"""

	var LocationMapping_JSON_data = R2PLOADSOURCE(LocationMapping_JSON_source)

	val TransportMapping_source = """{"iterator":"/transport/bus","referenceFormulation":"ql:XPath","query":"","sqlVersion":"","tableName":"","name":"Transport.xml"}"""

	val TransportMapping_referenceFormulation = """ql:XPath"""

	val TransportMapping_iterator = """/transport/bus"""

	val TransportMapping_template = """http://trans.example.com/bus/{@id}"""

	var TransportMapping_data = R2PLOADSOURCE(TransportMapping_source)

	val StopMapping_source = """{"iterator":"/transport/bus/route/stop","referenceFormulation":"ql:XPath","query":"","sqlVersion":"","tableName":"","name":"Transport.xml"}"""

	val StopMapping_referenceFormulation = """ql:XPath"""

	val StopMapping_iterator = """/transport/bus/route/stop"""

	val StopMapping_template = """http://trans.example.com/stop/{@id}"""

	var StopMapping_data = R2PLOADSOURCE(StopMapping_source)

	var LocationMapping_CSV_temptable = R2PEXTRACT(LocationMapping_CSV_data,LocationMapping_CSV_referenceFormulation,LocationMapping_CSV_iterator,R2PTOTUPLE("latitude,longitude"),R2PTOTUPLE("latitude"),R2PTOTUPLE("longitude"))

	var LocationMapping_CSV_df = createDF(LocationMapping_CSV_temptable);

	var LocationMapping_CSV_table = LocationMapping_CSV_df.map(r=>(R2PFORMAT(LocationMapping_CSV_template, r.getString(0)),r.getString(0),r.getString(1),r.getString(2)))

	var AirportMapping_temptable = R2PEXTRACT(AirportMapping_data,AirportMapping_referenceFormulation,AirportMapping_iterator,R2PTOTUPLE("id"),R2PTOTUPLE("latitude,longitude"),R2PTOTUPLE("bus"),R2PTOTUPLE("city"))

	var AirportMapping_df = createDF(AirportMapping_temptable);

	var AirportMapping_table = AirportMapping_df.map(r=>(R2PFORMAT(AirportMapping_template, r.getString(0)),r.getString(0),r.getString(1),r.getString(2),r.getString(3)))

	var VenueMapping_temptable = R2PEXTRACT(VenueMapping_data,VenueMapping_referenceFormulation,VenueMapping_iterator,R2PTOTUPLE("$.venue[*].location.city"),R2PTOTUPLE("$.venue[*].latitude,$.venue[*].longitude"),R2PTOTUPLE("$.venue[*].location.country"),R2PTOTUPLE("$.venue[*].location.continent"))

	var VenueMapping_df = createDF(VenueMapping_temptable);

	var VenueMapping_table = VenueMapping_df.map(r=>(R2PFORMAT(VenueMapping_template, r.getString(0)),r.getString(0),r.getString(1),r.getString(2),r.getString(3)))

	var TransportMapping_temptable = R2PEXTRACT(TransportMapping_data,TransportMapping_referenceFormulation,TransportMapping_iterator,R2PTOTUPLE("/transport/bus/@id"),R2PTOTUPLE("/transport/bus/@type"),R2PTOTUPLE("/transport/bus/route/stop/@id"))

	var TransportMapping_df = createDF(TransportMapping_temptable);

	var TransportMapping_table = TransportMapping_df.map(r=>(R2PFORMAT(TransportMapping_template, r.getString(0)),r.getString(0),r.getString(1),r.getString(2)))

	var LocationMapping_JSON_temptable = R2PEXTRACT(LocationMapping_JSON_data,LocationMapping_JSON_referenceFormulation,LocationMapping_JSON_iterator,R2PTOTUPLE("$.venue[*].latitude,$.venue[*].longitude"),R2PTOTUPLE("$.venue[*].latitude"),R2PTOTUPLE("$.venue[*].longitude"))

	var LocationMapping_JSON_df = createDF(LocationMapping_JSON_temptable);

	var LocationMapping_JSON_table = LocationMapping_JSON_df.map(r=>(R2PFORMAT(LocationMapping_JSON_template, r.getString(0)),r.getString(0),r.getString(1),r.getString(2)))

	var StopMapping_temptable = R2PEXTRACT(StopMapping_data,StopMapping_referenceFormulation,StopMapping_iterator,R2PTOTUPLE("/transport/bus/route/stop/@id"),R2PTOTUPLE("/transport/bus/route/stop/."))

	var StopMapping_df = createDF(StopMapping_temptable);

	var StopMapping_table = StopMapping_df.map(r=>(R2PFORMAT(StopMapping_template, r.getString(0)),r.getString(0),r.getString(1)))

	subject = AirportMapping_table.map(r=>(r._1,"rdf:type","ex:Stop"))
	result = subject;

	subject = VenueMapping_table.map(r=>(r._1,"rdf:type","ex:City"))
	result = result.union(subject)

	subject = TransportMapping_table.map(r=>(r._1,"rdf:type","ex:Transport"))
	result = result.union(subject)

	subject = StopMapping_table.map(r=>(r._1,"rdf:type","ex:Stop"))
	result = result.union(subject)

	objects = AirportMapping_table.map(r=>(r._1,"ex:latlong",R2PFORMAT("<http://loc.example.com/latlong/%s,%s>",r._3)))
	result = result.union(objects)

	child = AirportMapping_table.map(r=>(r._1,r._4))
	parent = TransportMapping_table.map(r=>(r._1,r._2))
	joinTemp = child.join(parent,"_2")

	objects = joinTemp.map(r=>(r.getString(1),"ex:route",r.getString(2)))
	result = result.union(objects)

	child = AirportMapping_table.map(r=>(r._1,r._5))
	parent = VenueMapping_table.map(r=>(r._1,r._2))
	joinTemp = child.join(parent,"_2")

	objects = joinTemp.map(r=>(r.getString(1),"ex:location",r.getString(2)))
	result = result.union(objects)

	objects = LocationMapping_CSV_table.map(r=>(r._1,"ex:lat",R2PFORMAT("\"%s\"",r._3)))
	result = result.union(objects)

	objects = LocationMapping_CSV_table.map(r=>(r._1,"ex:long",R2PFORMAT("\"%s\"",r._4)))
	result = result.union(objects)

	objects = VenueMapping_table.map(r=>(r._1,"ex:latlong",R2PFORMAT("<http://loc.example.com/latlong/%s,%s>",r._3)))
	result = result.union(objects)

	objects = VenueMapping_table.map(r=>(r._1,"ex:countryCode",R2PFORMAT("\"%s\"",r._4)))
	result = result.union(objects)

	objects = VenueMapping_table.map(r=>(r._1,"ex:onContinent",R2PFORMAT("\"%s\"",r._5)))
	result = result.union(objects)

	objects = LocationMapping_JSON_table.map(r=>(r._1,"ex:lat",R2PFORMAT("\"%s\"",r._3)))
	result = result.union(objects)

	objects = LocationMapping_JSON_table.map(r=>(r._1,"ex:long",R2PFORMAT("\"%s\"",r._4)))
	result = result.union(objects)

	objects = TransportMapping_table.map(r=>(r._1,"ex:type",R2PFORMAT("<http://trans.example.com/vehicle/%s>",r._3)))
	result = result.union(objects)

	objects = TransportMapping_table.map(r=>(r._1,"ex:stop",R2PFORMAT("<http://trans.example.com/stop/%s>",r._4)))
	result = result.union(objects)

	objects = StopMapping_table.map(r=>(r._1,"ex:stop",R2PFORMAT("\"%s\"^^xsd:int",r._2)))
	result = result.union(objects)

	objects = StopMapping_table.map(r=>(r._1,"ex:stopLabel",R2PFORMAT("\"%s\"",r._3)))
	result = result.union(objects)

	var prefixes = Seq(	("@prefix","rdf:","<http://www.w3.org/1999/02/22-rdf-syntax-ns#>."),
	("@prefix","xsd:","<http://www.w3.org/2001/XMLSchema#>."),
	("@prefix","ex:","<http://example.com/ns#>."),
	("@prefix","xsd:","<http://www.w3.org/2001/XMLSchema#>."),
	("@prefix","rdfs:","<http://www.w3.org/2000/01/rdf-schema#>."),
	("@prefix","rr:","<http://www.w3.org/ns/r2rml#>."),
	("@prefix","rml:","<http://semweb.mmlab.be/ns/rml#>."),
	("@prefix","ql:","<http://semweb.mmlab.be/ns/ql#>."),
	("@base","","<http://example.com/base/>."))
	result = result.union(prefixes.toDS())

	result = result.distinct()
}