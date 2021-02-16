package solutions

object positiveNegativeRatios {

  def plusMinus(arr: Array[Int]) {
    val n = arr.length
    val positiveRatio = (arr.map(e => if (e > 0) 1 else 0).sum.toDouble / n.toDouble)
    val negativeRatio = (arr.map(e => if (e < 0) 1 else 0).sum.toDouble / n.toDouble)
    val zeroRation = (arr.map(e => if (e == 0) 1 else 0).sum.toDouble / n.toDouble)
    val pos = BigDecimal(positiveRatio).setScale(6, BigDecimal.RoundingMode.HALF_UP)
    val neg = BigDecimal(negativeRatio).setScale(6, BigDecimal.RoundingMode.HALF_UP)
    val zer = BigDecimal(zeroRation).setScale(6, BigDecimal.RoundingMode.HALF_UP)
    println(pos)
    println(neg)
    println(zer)


    def staircase(n: Int) {
      val arr = Array.ofDim[String](n)
      for (i <- 0 until n) {
        var str = ""
        for (j <- 0 until n - i - 1) {
          str += " "
        }
        for (j <- n - i - 1 until n) {
          str += "#"
        }
        arr(i) = str
      }

      arr.map(e => e.toString).foreach(println)

    }

    def miniMaxSum(arr: Array[Int]) {
    println(arr.sorted.dropRight(1).sum,arr.sorted.tail.sum)

    }


  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    plusMinus(arr)
  }

}
