package solutions

object OrdersFulfill {


  import java.io._

  import scala.io._


  object Result {

    /*
     * Complete the 'filledOrders' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY order
     *  2. INTEGER k
     */

    def filledOrders(order: Array[Int], k: Int): Int = {
      //10 30 && 40
      //take the firdt element and
      var el = 0


      var orderedArray = order.sorted
      if (orderedArray.isEmpty || orderedArray.head > k) {
        return 0
      } else if (orderedArray.length == 1) {
        if (orderedArray.head > k) {
          return 0
        } else {
          return 1
        }
      } else {
        return filledOrders(orderedArray.tail, k - orderedArray.head) + filledOrders(Array(orderedArray.head), k)
      }

      1

    }


    def nearlySimilarRectangles(sides: Array[Array[Long]]): Long = {

      def divide(arr1: Array[Long], arr2: Array[Long]): Boolean = {
        if (arr2(0) == 0 || arr2(1) == 0) {
          return false
        } else if ((arr1(0) / arr2(0)).toFloat == (arr1(1) / arr2(1)).toFloat) {
          return true
        } else {
          return false
        }
        false
      }

      if (sides.length <= 1) {
        return 0
      } else if (sides.length == 2 && divide(sides(0), sides(1))) {
        return 1
      }else if (sides.length == 2 && !divide(sides(0), sides(1))) {
        return 0
      } else {
        return nearlySimilarRectangles(sides.tail) + nearlySimilarRectangles(Array(sides.head, sides.tail(0)))
      }

      1

    }



    //    def filledOrders(order: Array[Int], k: Int): Int = {
    //      var total = 0
    //      for (i <- 0 until order.length) {
    //        for (v <- order.sorted) {
    //          if (total + v <= k) {
    //            total += v
    //          }else {
    //            return i
    //          }
    //        }
    //      }
    //    }

  }

  object Solution {
    def main(args: Array[String]) {
      val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

      val orderCount = StdIn.readLine.trim.toInt

      val order = Array.ofDim[Int](orderCount)

      for (i <- 0 until orderCount) {
        val orderItem = StdIn.readLine.trim.toInt
        order(i) = orderItem
      }

      val k = StdIn.readLine.trim.toInt

      val result = Result.filledOrders(order, k)

      printWriter.println(result)

      printWriter.close()
    }
  }


}
