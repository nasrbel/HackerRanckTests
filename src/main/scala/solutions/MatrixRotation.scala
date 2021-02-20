package solutions

object MatrixRotation {

  /**
   * You are given a 2D matrix, a, of dimension MxN and a positive integer R.
   * You have to rotate the matrix R times and print the resultant matrix.
   * Rotation should be in anti-clockwise direction.
   *
   * Rotation of a 4x5 matrix is represented by the
   * following figure. Note that in one rotation, you have
   * to shift elements by one step only (refer sample tests for more clarity).
   *
   *
   */


    def getCircle(arr: Array[Array[Int]]): List[Int]={


      // the idea is to get the first circle of tha matrix
      val n = arr.length // number of rows
      val m = arr(0).length // number of cols
      val circleArray = Array.ofDim[Int](2*n+2*m)
      var k = 0
      for (j <- 0 until m){
        circleArray(k) = arr(1)(j)
        k += 1
      }
      for(i <- 0 until n){
        circleArray(k) = arr(i)(1)
        k += 1
      }
      for(j <- 0 until m){
        circleArray(k) = arr(n-1)(j)
        k += 1
      }
      for(i <- n-1 to 0 by -1){
        circleArray(k) = arr(i)(m-1)
        k += 1
      }
      circleArray.toList
    }

  def main(args: Array[String]): Unit = {


  }

}
