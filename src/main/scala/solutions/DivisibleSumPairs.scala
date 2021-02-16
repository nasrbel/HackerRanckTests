package solutions

object DivisibleSumPairs {
  // Complete the divisibleSumPairs function below.

  def numberOfTuple(n:Int,  k :Int,arr : Array[Int])={

    val list = (0 until n ).toList
    var listOfTuple = list.flatMap(x => list.map(y => if ((x < y) && (arr(x)+arr(y)) % k==0)  (x,y) else (-1, -1))).filterNot(_.equals((-1,-1)))
    listOfTuple.length
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn



    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt



    val ar = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = numberOfTuple(n, k, ar)

   println(result)
  }

}
