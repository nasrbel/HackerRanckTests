package solutions


  import scala.io._

  object Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    def diagonalDifference(arr: Array[Array[Int]]): Int = {
      // Write your code here
      val leftToRightDiag = arr.map(e => e(arr.indexOf(e))).sum
      val rightToLeftDiag = arr.reverse.map(e => e(arr.reverse.indexOf(e))).sum
      (leftToRightDiag-rightToLeftDiag).abs

    }

  }

   object matrixDiagonalDifference {

    def main(args: Array[String]) {
     // val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

      val n = StdIn.readLine.trim.toInt

      val arr = Array.ofDim[Int](n, n)

      for (i <- 0 until n) {
        arr(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
      }
      arr.reverse.map(e => println(e(arr.indexOf(e))))

      val result = Result.diagonalDifference(arr)

      println(result)

     // printWriter.close()
    }
  }



