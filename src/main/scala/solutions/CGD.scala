package solutions

object CGD {



    def gcd(x: Int, y: Int): Int = {
      if (x == y) {
        return x
      } else if (x >= y) {
        if (x % y == 0) {
          return y
        } else if (x % y != 0) {
           return gcd(x-y,y)
        }

      }else{
        return gcd(y,x)
      }
      1
      // You only need to fill up this function
      // To return the value of the GCD of x and y

    }


    /** This part handles the input/output. Do not change or modify it **/
    def acceptInputAndComputeGCD(pair: List[Int]) = {
      println(gcd(pair.head, pair.reverse.head))
    }

    def main(args: Array[String]) {
      /** The part relates to the input/output. Do not change or modify it **/
      acceptInputAndComputeGCD(scala.io.StdIn.readLine().trim().split(" ").map(x => x.toInt).toList)

    }
  }


