package solutions
import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

class magicMatrix {

  /**
   * In the case of 3x3 matrix the magic sum is 15
   * Please to take a look to this link: https://en.wikipedia.org/wiki/Magic_square
   * We need to define wether an Int is having a good place in the matrix or not
   * Having a good place means that the sum ( row or column) is 15
   * than from te list(1,9) get what is missing
   * replace
   * @param
   * @return
   */

    def getMissingNumbers(matrix:Array[Array[Int]]): List[Int]={
      matrix.map(_.distinct)
    }

    def isItAGoodPosition(matrix: Array[Array[Int]],i:Int, j: Int ) : (Int,Int) = {
      // test horizontal sums
      var i0 =i
      var j0 = j
      val n = matrix.length
      if(i > n || j > n  ){
        return (-1,-1)
      }else {
        val sumOfLine = matrix(i).sum
        val sumOfColumn = matrix.map(line => line(j) ).sum

      }

    }

  def formingMagicSquare(s: Array[Array[Int]]): Int = {


  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn


    val s = Array.ofDim[Int](3, 3)

    for (i <- 0 until 3) {
      s(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = formingMagicSquare(s)

    println(result)

  }


}
