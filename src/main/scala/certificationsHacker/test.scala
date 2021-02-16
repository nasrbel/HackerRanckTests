package certificationsHacker

object test {


  import scala.io._

  object Result {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    def fizzBuzz(n: Int) {
      for (i <- 1 to n) {
        if (i % 5 == 0 && (i % 3 == 0)) {
          println("FizzBuzz")
        } else if (i % 5 != 0 && i % 3 == 0) {
          println("Fizz")
        }else if ( i % 5 == 0 && i % 3 != 0){
          println("Buzz")
        }else {
          println(i)
        }
      }
    }
  }

  object Solution {
    def main(args: Array[String]) {
      val n = StdIn.readLine.trim.toInt

      Result.fizzBuzz(n)
    }
  }


}
