package solutions

object twoSubarrays {


  def isIncreasglySubSeq(seq: List[Int]): Boolean = seq.length == 1 || seq.sliding(2).forall(x => x.head < x(1))


  def subsequences(list: List[Int]): List[List[Int]] =
    list match {
      case Nil =>
        List(List())
      case hd :: tl =>
        val subs = subsequences(tl)

        subs.map(hd +: _) ++ subs
    }


  def getSubArray(l: Int, r: Int, arr: List[Int]): List[Int] = {

      if (l == r) {
        return List(arr(l))
      } else {

        return arr.slice(l, r + 1)
      }


    List(1)

  }




    def getPrpos(sizeOfSlice: Int, arr: List[Int], maxEl0: Int) : (Int,List[List[Int]])={
      var maxEl = maxEl0
      val maxF = arr.sliding(sizeOfSlice).map(e => f(e)).max

      if(sizeOfSlice == 1 ){
        return (maxF,arr.sliding(1).toList)
      }else if (maxF > maxEl) {
          maxEl = maxF
          return getPrpos(sizeOfSlice -1, arr, maxF)
        }else{
          return getPrpos(sizeOfSlice -1, arr, maxEl)
        }


      (0,List(Nil))

    }










  def f(Subarr: List[Int]): Int = {
    Subarr.sum - maxSum(Subarr)


  }

  def maxSum(arr: List[Int]): Int = {
    val T = new Array[Int](arr.length)
    for (i <- T.indices) {
      T(i) = arr(i)
    }
    for (i <- 1 until T.length) {
      for (j <- 0 until i) {
        if (arr(j) < arr(i)) T(i) = Math.max(T(i), T(j) + arr(i))
      }
    }
    var max = T(0)
    for (i <- 1 until T.length) {
      if (T(i) > max) max = T(i)
    }
    max
  }

  def main(args: Array[String]): Unit = {
    var subArraysProps = List[(Int, Int)]()

    val n = scala.io.StdIn.readInt()
    val arr = scala.io.StdIn.readLine().split(" ").map(e => e.trim.toInt).toList
    val nums = (0 until n).toList
    var listOfTuple = nums.flatMap(x => nums.map(y => if (x <= y) (x, y) else (-1, -1))).filterNot(_.equals((-1, -1)))
    listOfTuple = listOfTuple.sortBy(_._1)
    println("I have finished Tuples")
    var maxF = Int.MinValue


    val subArraysPropsEdited = listOfTuple.map(e => {
      (getSubArray(e._1, e._2, arr).length, f(getSubArray(e._1, e._2, arr)))


    }).toList

    println(subArraysPropsEdited)
    //    for (e <- listOfTuple) {
    //      val subArr = getSubArray(e._1, e._2, arr)
    //
    //      val fValue: Int = f(subArr)
    //      println(e+ "########################### "+fValue)
    //
    //      if (fValue >= maxF) {
    //
    //        maxF = fValue
    //
    //        subArraysProps = (subArr.length, fValue) :: subArraysProps
    //      }


    //    listOfTuple.map(e => {
    //      val subArr = getSubArray(e._1, e._2, arr)
    //      //val subSequence = subsequences(subArr).filter(e => isIncreasglySubSeq(e)).filter(_.nonEmpty)
    //      val fValue = f(subArr)
    //      println(fValue)
    //      if (fValue >= maxF) {
    //        maxF = fValue
    //
    //        (subArr.length, fValue)
    //      }
    //    }) :: subArraysProps


    /**
     * 14
     * 1 -5 2 2 -3 3 2 -4 4 2 -5 5 2 -6
     */
    //
    //    val g = subArraysProps.maxBy(_._2)._2
    //    val m = subArraysProps.filter(_._2 == g).minBy(_._1)._1
    //    val nb = subArraysProps.filter(_._2 == g).count(_._1 == m)
    //    println(g + " " + nb)


  }

}
