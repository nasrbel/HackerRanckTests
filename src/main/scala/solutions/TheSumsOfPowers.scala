package solutions

object TheSumsOfPowers {
  def main(args: Array[String]): Unit = {
    //program to count number of ways any
    //// given integer x can be expressed as n-th
    //// power of unique natural numbers.

    //check power representations recursively
    //test if the sum is equal the input int or not
    // if yes the number ++ else see another presentation


    def power(number: Int, n: Int): Int = {

      if (n == 0) {
        return 1
      } else if (n % 2 == 0) {
        return power(number, n / 2) * power(number, n / 2)
      } else {
        return number * power(number, n / 2) * power(number, n / 2)
      }
      1


    }

    def getConsectitivePresentation(x: Int, n: Int, curr_num: Int, curr_sum: Int): Int = {

      // Initialize number of ways to express
      // x as n-th powers of different natural
      // numbers
      var curr_num0 = curr_num

      var result = 0
      println("current num "+curr_num0)
      var p = power(curr_num0, n)
      println("power is "+p)
      while (p + curr_sum < x) {
        result += getConsectitivePresentation(x, n, curr_num0 + 1, curr_sum + p)
        curr_num0 += 1
        p = power(curr_num0, n)
      }
      if (p + curr_sum == x) {
        result += 1
      }
      result
      // the max number is itselt
      // start the iteration
    }

//    val x = scala.io.StdIn.readInt()
//    val n = scala.io.StdIn.readInt()

    println(getConsectitivePresentation(1000, 10, 1, 0))


  }

}
