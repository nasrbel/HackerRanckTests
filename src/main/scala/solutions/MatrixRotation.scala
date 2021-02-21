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

    val n = arr.length // number of rows
    val m = arr(0).length // number of cols
//    println("%%%%%%%%%%%%%%%%%%%%% The input arr %%%%%%%%%%%%%%%%%%%%")
//    println("%%%%%%%%%%%%%%%%%%% m ="+m)
//    println("%%%%%%%%%%%%%%%%%%% n ="+n)
//
//    arr.foreach(e => println(e.toList))
//    println("%%%%%%%%%%%%%%%%%%%%%    %%%%%%%%%%%%%%%%%%%%")


    // the idea is to get the first circle of tha matrix

    val circleArray = Array.ofDim[Int](2 * n + 2 * m - 4)

    //println(2 * n + 2 * m - 4)
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
     // println(n-1,j)
      circleArray(k) = arr(n - 1)(j)
      k += 1
    }

    for (i <- n - 2 to 1 by -1) {
   //println(arr(i)(m-1))
      circleArray(k) = arr(i)(m - 1)
      k += 1
    }
//    println(k)

    println("%%%%%%%%%%%%%%%%%%% The circle got is : %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
   //println(circleArray.toList)
    return circleArray.toList

    List(1)
  }


  def rotateCircle(l: List[Int]): List[Int] = {

    val xs2 = new RotatedIterator(l, l.length - 1)
    xs2.toList


  }


  def getCircles(inputArray: Array[Array[Int]], filter1: (Int, Int), filter2: (Int, Int)): List[List[Int]] = {
    var filter10 = filter1
    var filter20 = filter2

    val n = inputArray.length
    val m = inputArray(0).length

    if(n <= 2 || m <= 2){
      return List(rotateCircle(getCircle(inputArray)))
    }else {
      var l = List[List[Int]]()

      if ((filter10._2 == 1 || filter20._2 == 1)) {
        l = l :+ rotateCircle(getCircle(inputArray))
        println(l)
        return l

      } else {

        val newArr: Array[Array[Int]] = inputArray.zipWithIndex.filter(e => e._2 >= filter10._1 && e._2 <= filter10._2)
          .map(_._1).map(e => e.zipWithIndex).map(e => e.filter(el => el._2 >= filter20._1 && el._2 <= filter20._2))
          .map(e => e.map(el => el._1))


        val circle = rotateCircle(getCircle(newArr))
        filter10 = (filter10._1 + 1, filter10._2 - 1)
        filter20 = (filter20._1 + 1, filter20._2 - 1)
        //        l = l :+circle
        // println(filter10,filter20)
        l = getCircles(inputArray, filter10, filter20) :+ circle
        return l


      }
    }
    List(List(1))


  }

  def constructNewArray(inputArray : Array[Array[Int]], n: Int, m: Int, r: Int): Array[List[Int]] = {


    if (r == 0) {
      return inputArray.map(_.toList)
    }else {

      val outputArray = Array.ofDim[Int](n, m)


      var s0 = getCircles(inputArray.map(_.toArray), (0, n - 1), (0, m - 1)).filterNot(_.equals(List(Int.MinValue)))
      var s = if(s0.length <=1) s0 else s0.dropRight(1)
      println("the lsit in question is "+s0)

      //if s contains only one list : m==2 or n==2
//      if (s.length == 1) {
//        val xs10 = s(0)
//        outputArray(0) = xs10.slice(0, n - 1).toArray.reverse
//        for (i <- 1 until n - 1) {
//          outputArray(i)(0) = xs10(m + i - 1)
//
//        }
//
//        outputArray(n - 1) = xs10.slice(n + m - 2, n + 2 * m - 2).toArray
//        var xs = xs10
//        for (i <- 1 to n - 2) {
//          outputArray(i)(m - 1) = xs.last
//          xs = xs.dropRight(1)
//        }
//
//
//      } else if(s.length >=2) {

      val xs10 = s.head

      /**
       * here editing n-1 to n in slice
       */
      outputArray(0) = xs10.slice(0, n - 1).toArray.reverse
      for (i <- 1 until n - 1) {
        outputArray(i)(0) = xs10(m + i - 1)

      }


      //**************************************************************
      outputArray(n - 1) = xs10.slice(n + m - 2, n + 2 * m - 2).toArray
      var xs = xs10
      for (i <- 1 to n - 2) {
        outputArray(i)(m - 1) = xs.last
        xs = xs.dropRight(1)
      }


      if(s0.length>=2) {
        s = s.tail

        val xs20 = s.head
        // println(xs20)
        // either n - 3 or  n- n%2
        // println(xs20.slice(0, n - n%2).toArray.reverse.toList)
        val p = math.min(m, n)
        for (j <- 1 until m - 1) {
          outputArray(1)(j) = xs20.slice(0, n - n % 2).toArray.reverse(j - 1)

        }
        for (i <- 2 until n - 1) outputArray(i)(1) = xs20(m - 3 + i - 1)
        for (i <- 2 until n - 1) {
          // println(i)
          outputArray(i)(m - 2) = xs20.slice(n + m - 5, xs20.length).reverse(i - 2)
        }
      }



      return constructNewArray(outputArray,n,m,r-1)




    }


    Array(List(1))


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


    //val l = getCircles(arr, (0, n - 1), (0, m - 1)).filterNot(_.equals(List(Int.MinValue)))


    val outputArray = constructNewArray(arr, n, m, r)

   println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%ù")
    outputArray.foreach(e => println(e))

  }

}
