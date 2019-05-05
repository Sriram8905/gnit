import scala.collection.mutable._
import net.liftweb.json._
import net.liftweb.json.Serialization.write

import scala.tools.nsc.doc.html.page.JSONObject
import scala.xml.Null
case class jsonHeader(Company:String,CEO:String,Greeting:String);
object CsvToJson {
  def main(args:Array[String]): Unit = {
    println(csvtoJson("Ganit", "Shiva", "Welcome to the team"))
    println(convertToJson("Ganit,sriram,welecome to the team"))
    println(convertToJson("Ganit,sriram"))
    println(convertToJson("Ganit"))
    println(convertToJson(null))
    println(convertToJson(",,,"))

  }
  def csvtoJson(company:String,CEO:String,Greeting:String):String={
    val p = jsonHeader(company,CEO,Greeting)
    implicit val formats = DefaultFormats
    val jsonString = write(p)
    jsonString;
  }
  def csvtoJson(company:String,CEO:String): String ={
    val greeting = "Welcome"
    csvtoJson(company:String,CEO:String,greeting:String)
  }
  def csvtoJson(company:String): String ={
    val greeting = "Welcome"
    val CEO ="CEO"
    csvtoJson(company:String,CEO:String,greeting:String)
  }
  def csvtoJson(): String ={
    val greeting = "Welcome"
    val CEO ="CEO"
    val company = "Ganit"
    csvtoJson(company:String,CEO:String,greeting:String)
  }
  def convertToJson( str :String ) : String = str match {
    case null  => "None"
    case _ if str.split(",").size == 3 =>
      csvtoJson(str.split(",")(0),str.split(",")(1),str.split(",")(2));
    case _ if (str.split(",").size ==2 ) =>
      csvtoJson(str.split(",")(0),str.split(",")(1))
    case _ if(str.split(",").size == 1) =>
       csvtoJson(str.split(",")(0))
    case _ if(str.split(",").size == 0) =>
      csvtoJson()
  }
}
