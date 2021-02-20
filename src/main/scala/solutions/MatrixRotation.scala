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
      val circleArray = Array.ofDim[Int](2*n+2*m-4)
      var k = 0
      for (j <- m-1 to 0 by -1){
        circleArray(k) = arr(0)(j)
        k += 1
      }
      for(i <- 1 until n){
        circleArray(k) = arr(i)(0)
        k += 1
      }
      for(j <- 1 until m){
        circleArray(k) = arr(n-1)(j)
        k += 1
      }
      for(i <- n-2 to 1 by -1){
        circleArray(k) = arr(i)(m-1)
        k += 1
      }
      circleArray.toList
    }

  class RotatedIterator[A](seq: Seq[A], start: Int) extends Iterator[A] {
    var (before, after) = seq.splitAt(start)
    def next: A = after match {
      case Seq()  =>
        val (h :: t) = before; before = t; h
      case h :: t => after = t; h
    }
    def hasNext: Boolean = after.nonEmpty || before.nonEmpty
  }

  def main(args: Array[String]): Unit = {

    val triplet = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt)
    val n = triplet(0)
    val m = triplet(1)
    val r = triplet(2)
    val arr = Array.ofDim[Int](n,m)
    (0 until n).foreach(k => arr(k) = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt))
    val seq = getCircle(arr)
    println(getCircle(arr))
    val xs = new RotatedIterator(seq, 11)
    println(xs.toList)

  }

}
