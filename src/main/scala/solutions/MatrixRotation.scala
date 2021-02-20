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


  def getCircle(arr: Array[Array[Int]]): List[Int] = {


    // the idea is to get the first circle of tha matrix
    val n = arr.length // number of rows
    val m = arr(0).length // number of cols
    val circleArray = Array.ofDim[Int](2 * n + 2 * m - 4)
    var k = 0
    for (j <- m - 1 to 0 by -1) {
      circleArray(k) = arr(0)(j)
      k += 1
    }
    for (i <- 1 until n) {
      circleArray(k) = arr(i)(0)
      k += 1
    }
    for (j <- 1 until m) {
      circleArray(k) = arr(n - 1)(j)
      k += 1
    }
    for (i <- n - 2 to 1 by -1) {
      circleArray(k) = arr(i)(m - 1)
      k += 1
    }
    circleArray.toList
  }


  def rotateCircle(l: List[Int], r: Int): List[Int] = {
    if (r == 0) {
      return l
    } else {
      val xs2 = new RotatedIterator(l, l.length - 1)
      return rotateCircle(xs2.toList, r - 1)

    }

    List(1)

  }


  def getCircles(inputArray: Array[Array[Int]], filter1: (Int, Int), filter2: (Int, Int), r: Int): List[List[Int]] = {
    var filter10 = filter1
    var filter20 = filter2

    val n = inputArray.length
    val m = inputArray(0).length
    var l = List[List[Int]]()

    if (filter10._2 == 1 && filter20._2 == 1) {
      l = l :+ rotateCircle(getCircle(inputArray), r)
      return l

    } else {
      val newArr: Array[Array[Int]] = inputArray.zipWithIndex.filter(e => e._2 >= filter10._1 && e._2 <= filter10._2)
        .map(_._1).map(e => e.zipWithIndex).map(e => e.filter(el => el._2 >= filter20._1 && el._2 <= filter20._2))
        .map(e => e.map(el => el._1))
      val circle = rotateCircle(getCircle(newArr), r)
      filter10 = (filter10._1 + 1, filter10._2 - 1)
      filter20 = (filter20._1 + 1, filter20._2 - 1)
      //        l = l :+circle
      // println(filter10,filter20)
      l = getCircles(inputArray, filter10, filter20, r) :+ circle
      return l


    }
    List(List(1))


  }

  def constructNewArray(seq: List[List[Int]], n: Int, m: Int): Array[List[Int]] = {

    val outputArray = Array.ofDim[Int](n, m)
    var s = seq
    //println(s)
    val xs10 = s.head
    outputArray(0) = xs10.slice(0, n).toArray.reverse
    for (i <- 1 until n - 1) {
      outputArray(i)(0) = xs10(n + i - 1)

    }
    outputArray(n - 1) = xs10.slice(n+m-2, 2 * n+m-2).toArray
    println(outputArray(n-1).toList)
    //*****************************************
    var xs = xs10
    for (i <- 1 to n - 2) {
      outputArray(i)(m - 1) = xs.last
      xs = xs.dropRight(1)
      println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
      println(xs)
      println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
    }
    s = s.tail
   // println(s)
    val xs20 = s.head

    //****************************************************************
    for (j <- 1 until m - 1) {
      outputArray(1)(j) = xs20.slice(0, n - 2).toArray.reverse(j - 1)
      // outputArray(1)(2) = xs20.slice(0, 3 - 1).toArray.reverse(1)

    }

    for (j <- 1 until m - 1) outputArray(2)(j) = xs20(j + 1)
    //outputArray(2)(2) = xs20(3)

    outputArray.map(_.toList)


  }

  class RotatedIterator[A](seq: Seq[A], start: Int) extends Iterator[A] {
    var (before, after) = seq.splitAt(start)

    def next: A = after match {
      case Seq() =>
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
    val arr = Array.ofDim[Int](n, m)
    (0 until n).foreach(k => arr(k) = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt))
    val seq1 = getCircle(arr)
    //println(getCircle(arr))
    val xs1 = new RotatedIterator(seq1, 11)
    val xs10 = xs1.toList
    val newArr: Array[Array[Int]] = arr.zipWithIndex.filter(e => e._2 >= 1 && e._2 <= n - 2)
      .map(_._1).map(e => e.zipWithIndex).map(e => e.filter(el => el._2 >= 1 && el._2 <= m - 2))
      .map(e => e.map(el => el._1))
    val seq2 = getCircle(newArr)
    val xs2 = new RotatedIterator(seq2, seq2.length - 1)
    val xs20 = xs2.toList
    //construct the new array
    // val outputArray = Array.ofDim[Int](n, m)
    //    println(xs1.length)
    //    println(xs1.toList)

    val l = getCircles(arr, (0, n - 1), (0, m - 1), 1).dropRight(1)
    println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&")

    println(l)


    val outputArray = constructNewArray(l, n, m)


   outputArray.foreach(e => println(e))

  }

}
