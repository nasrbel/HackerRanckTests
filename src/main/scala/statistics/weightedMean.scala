package statistics

object  weightedMean {

  def main(args: Array[String]): Unit = {

   val n =  scala.io.StdIn.readInt()

    val arr = scala.io.StdIn.readLine().split(" ").map(_.trim.toLong)
    val weight = scala.io.StdIn.readLine().split(" ").map(_.trim.toLong)
   val w =  arr.zip(weight).map(e => e._1*e._2).sum.toFloat/weight.sum.toFloat
    val wPrecision = BigDecimal(w).setScale(1, BigDecimal.RoundingMode.HALF_UP)
    println(wPrecision)


  }

}
