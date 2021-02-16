package solutions

object maxMinArray {



    // Complete the miniMaxSum function below.

    def miniMaxSum(arr: Array[Long]) {
      println(arr.sorted.dropRight(1).sum+" "+ arr.sorted.tail.sum)

    }

    def main(args: Array[String]) {
      val stdin = scala.io.StdIn

      val arr = stdin.readLine.split(" ").map(_.trim.toLong)
      miniMaxSum(arr)
    }



}
