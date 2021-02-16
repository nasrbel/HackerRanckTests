package statistics

object meanMedianMode {

  def mode(arr: Array[Long]) = arr.map(e => (e, 1)).groupBy(_._1).mapValues(_.map(_._2).sum).toArray.sortBy(_._1).maxBy(_._2)._1


  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution

*/

    val n = scala.io.StdIn.readInt()
    val arr = scala.io.StdIn.readLine().split(" ").map(_.trim.toLong).sorted
    arr.map(e => (e, 1)).groupBy(_._1).mapValues(_.map(_._2).sum).foreach(println)
    val mean = arr.sum.toFloat / n.toFloat
    val median: Float = (arr(n/2 - 1).toFloat + arr(n/2).toFloat)/2
    val staticMode = mode(arr)
    val meanPrecision = BigDecimal(mean).setScale(1, BigDecimal.RoundingMode.HALF_UP)
    val medianPrecision = BigDecimal(median).setScale(1, BigDecimal.RoundingMode.HALF_UP)

    println(meanPrecision)
    println(medianPrecision)
    println(staticMode)

  }


}
