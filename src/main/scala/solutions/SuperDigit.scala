package solutions

object SuperDigit {

  def main(args: Array[String]): Unit = {
    val line = scala.io.StdIn.readLine().split("\\s+")
    val inputInteger = line(0)
    val occNumber = line(1).toLong
    if(occNumber % 10 != 0) {
      println(superDigit((occNumber * superDigit(inputInteger).toLong).toString))
    }else{
      println(superDigit(inputInteger))
    }

  }

  //  super_digit(9875) = super_digit(9+8+7+5)
  //    = super_digit(29)
  //    = super_digit(2+9)
  //    = super_digit(11)
  //    = super_digit(1+1)
  //    = super_digit(2)
  //    = 2.


  def superDigit(inputInteger: String): String = {
    val compoaratorInt = 9.223372e+18.toLong.toString
    if (inputInteger.length == 1) {
      return inputInteger
    } else if (inputInteger.length > 19) {
      // superDigit(Sum) = sum(superDigit)
      if (inputInteger.distinct.length == 1) {
        return superDigit((inputInteger.distinct.toInt * inputInteger.length).toString)
      } else {

        val subInteger = buildInteger(inputInteger, compoaratorInt, "0L")._1.toCharArray.map(e=>e.toString().toLong).sum.toString
        val restOfSub = buildInteger(inputInteger, compoaratorInt, "0L")._2.toCharArray.map(e=>e.toString().toLong).sum.toString
        return superDigit((superDigit(subInteger).toLong+superDigit(restOfSub).toLong).toString)
      }

    } else {

        return superDigit(inputInteger.toCharArray.map(e => e.toString.toLong).sum.toString)


    }
    "1"
  }

  def buildInteger(initialInt: String, comparatorInt: String, restOfInitialInt: String): (String, String) = {

    if((initialInt.length < 19)) {
      //&& (initialInt.toLong <= comparatorInt.toLong)
      return (initialInt, restOfInitialInt)
    } else {
//      println("difference is =" + (initialInt.toLong - comparatorInt.toLong).toString)
      val firstInt = initialInt.substring(0,19).filter(_.isDigit)
      val restInt = initialInt.substring(19,initialInt.length).filter(_.isDigit)
      if(restInt.length>=1) {
        return (firstInt, restInt)
      }else{
        return (firstInt,"0")
      }
    }
    ("1", "1")

  }

  //def super_digit(n:Int ,k) = 1 + (n*k - 1) % 9

}
