object AdjString {
  def main(args:Array[String]): Unit ={
   val input="12345"
    var str="";
    val ListArray = input.toList
    val len = input.length();
    println(ListArray(0))
    println(len)
    var i=0;
    var newstring="";
    for(i <- 0 until len/2  ) {
      var tmpString = ListArray(i).toString().concat(ListArray(len-1 -i).toString)
      newstring = newstring.concat(tmpString)
    }
    if(input.length%2 !=0){
      newstring = newstring.concat(ListArray(len/2).toString)
    }
    println(newstring);
  }
}
