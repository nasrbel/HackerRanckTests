package solutions

object SubarraySum {


  def main(args: Array[String]): Unit = {

  }

  def maxSubsetSum(arr: Array[Int]): Int
  = {
    if (arr.length == 0) return 0
    arr(0) = Math.max(0, arr(0))
    if (arr.length == 1) return arr(0)
    arr(1) = Math.max(arr(0), arr(1))
    for (i <- 2 until arr.length) {
      arr(i) = Math.min(arr(i - 1), arr(i) + arr(i - 2))
    }
    arr(arr.length - 1)
  }


//  def segment(x: Int, space: Array[Int]): Int = {
//    // Write your code here
//    space.flatMap(el =>) sliding (x).map(e => e.min).max
//    //    var setArr = ArrayBuffer[Array[Int]]()
//    //    val n = space.length
//    //    var i = 0
//    //    while (i < n) {
//    //      var j = 0
//    //      var arr = Array[Int](x)
//    //      while (j < x && i + j < n) {
//    //        arr(j) = space(i + j)
//    //      }
//    //      i = i + x - 1
//    //      setArr.append(arr)
//    //    }
//    //    setArr.map(e => e.min).max
//    //
//    //  }
//
//  }

//  //so it returns for each area code the hotel with the highest number of views by logged-in users.
//  def process(stream: BStream[InputMessage]): BStream[OutputMessage] = {
//    stream.reducByKey((x,y) => x.hotel_area_code ==y.
//
//
//      //stream.filter(x => x.hotel_area_code == "FR"  ) // filter for hotels in FR
//      stream.map(  // Map to a stream of tuples (key, value)
//      // key is hotel_id, value is an initiated PageviewCounter with views set to 1
//      x => (x.hotel_id, PageviewCounter( x.hotel_id, x.hotel_area_code,1))
//    ).reduceByKey( // reduce by hotel_id key
//      // a and b are values to reduce - 2 PageviewCounter objects - reduce function is summing counts
//      (a,b) => PageviewCounter(a.hotel_id, a.hotel_area_code, a.count+b.count )
//    ).map( // calculation is done, map the (hotel_id,PageviewCounter) pair to OutputMessage
//      x => OutputMessage(x._2.hotel_area_code,x._2.hotel_id,x._2.count)
//    ).reduceByKey(
//      (a,b) => OutputMessage( a.hotel_area_code, a.hotel_id, Math.max(a.count, b.count))            )
//
//  }
}
