import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import r2ps.udf.scala.ScalaUDF.R2PLOADSOURCE
import r2ps.udf.scala.ScalaUDF.R2PFORMAT

object persons_json extends App {
  val spark = SparkSession
    .builder()
    .master(args(1))
    .appName("RML2SCALA_JSON")
    .getOrCreate()
  val sqlContext = spark.sqlContext
  var sparkContext = spark.sparkContext

  import spark.implicits._

  var start_time = System.currentTimeMillis();
  print("start_time:", start_time)

  val PersonMapping_source = """{"iterator":"$.persons[*]","referenceFormulation":"ql:JSONPath","query":"","sqlVersion":"","tableName":"","name":""""+args(0)+"\"}"

  val PersonMapping_referenceFormulation = """ql:JSONPath"""

  val PersonMapping_iterator = """$.persons[*]"""

  val PersonMapping_template = """<http://example.org/person/{id}{name}>"""

  var PersonMapping_data = R2PLOADSOURCE(PersonMapping_source,"""[["$.persons[*].id,$.persons[*].name"],["$.persons[*].name"],["$.persons[*].email"],["$.persons[*].phone"],["$.persons[*].birthdate"],["$.persons[*].height"],["$.persons[*].weight"]]""")

  var PersonMapping_df = createDF(PersonMapping_data);

  var PersonMapping_table = PersonMapping_df.map(r=>(R2PFORMAT(PersonMapping_template, r.getString(0)),r.getString(0),r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6)))

  var subject = PersonMapping_table.map(r=>(r._1,"rdf:type","foaf:Person"))
  var result = subject;

  var objects = PersonMapping_table.map(r=>(r._1,"""foaf:name""",R2PFORMAT(""""%s"""",r._3)))
  result = objects;

  objects = PersonMapping_table.map(r=>(r._1,"""foaf:mbox""",R2PFORMAT("""<mailto:%s>""",r._4)))
  result = result.union(objects)

  objects = PersonMapping_table.map(r=>(r._1,"""foaf:phone""",R2PFORMAT("""<tel:%s>""",r._5)))
  result = result.union(objects)

  objects = PersonMapping_table.map(r=>(r._1,"""schema:birthDate""",R2PFORMAT(""""%s"^^xsd:dateTime""",r._6)))
  result = result.union(objects)

  objects = PersonMapping_table.map(r=>(r._1,"""schema:height""",R2PFORMAT(""""%s"^^xsd:decimal""",r._7)))
  result = result.union(objects)

  objects = PersonMapping_table.map(r=>(r._1,"""schema:weight""",R2PFORMAT(""""%s"^^xsd:decimal""",r._8)))
  result = result.union(objects)

  result.show(10, false)

  var prefixes = Seq(	("@prefix","rr:","<<http://www.w3.org/ns/r2rml#>>."),
    ("@prefix","rml:","<<http://semweb.mmlab.be/ns/rml#>>."),
    ("@prefix","ql:","<<http://semweb.mmlab.be/ns/ql#>>."),
    ("@prefix","xsd:","<<http://www.w3.org/2001/XMLSchema#>>."),
    ("@prefix","ex:","<<http://www.example.org/>>."),
    ("@prefix","foaf:","<<http://xmlns.com/foaf/0.1/>>."),
    ("@prefix","schema:","<<http://schema.org/>>."),
    ("@base","","<<http://example.org/>>."))
  result = result.union(prefixes.toDS())


  var cur_time = System.currentTimeMillis()
  print("cur_time:", cur_time)
  result.rdd.map(r=>(r._1 + " " +r._2 + " " +r._3+".")).saveAsTextFile("rml2scala/"+cur_time)
  var use_time = cur_time - start_time;
  print("use_time:", use_time)

  def createDF(ar: String): DataFrame = {
    var df = spark.read.option("header", true).option("delimiter", "|").csv(ar).toDF();
    return df
  }
}
