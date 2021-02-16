package solutions

import java.io._

import scala.collection.mutable

object Solution {

  case class Memo[A,B](f: A => B) extends (A => B) {
    private val cache = mutable.Map.empty[A, B]
    def apply(x: A) = cache getOrElseUpdate (x, f(x))
  }

  // Complete the stepPerms function below.
  def stepPerms(n: Int): Int = {
    val dp: Memo[Int, Int] = Memo {
      if(n==1){
        return 1
      }else if(n==2){
        return 2
      }else if(n==3){
        return 4
      }else{
        return stepPerms(n-1)+stepPerms(n-2)+stepPerms(n-3)
      }
    }
    dp(n)

  }

  def stepPerms0(n: Int): Int  = {
    if (n == 1) return 1
    if (n == 2) return 2
    if (n == 3) return 4
    var n1 = 1L
    var n2 = 2L
    var n3 = 4L
    var ans = 0L
    for (i <- 4 to n) {
      ans = (n1 + n2 + n3) % 10000000007L
      n1 = n2
      n2 = n3
      n3 = ans
    }
    ans.toInt
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("./"))

    val s = stdin.readLine.trim.toInt

    for (sItr <- 1 to s) {
      val n = stdin.readLine.trim.toInt

      val res = stepPerms(n)

      printWriter.println(res)
    }

    printWriter.close()
  }
}

