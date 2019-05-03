import scala.collection.mutable._
import net.liftweb.json._
import net.liftweb.json.Serialization.write
case class jsonHeader(Company:String,CEO:String,Greeting:String);
object CsvToJson {
  def main(args:Array[String]): Unit ={
    println(csvtoJson("Ganit", "Shiva", "Welcome to the team"))
  }
  def csvtoJson(company:String,CEO:String,Greeting:String):String={
    val p = jsonHeader(company,CEO,Greeting)
    implicit val formats = DefaultFormats
    val jsonString = write(p)
    jsonString;
  }

}
