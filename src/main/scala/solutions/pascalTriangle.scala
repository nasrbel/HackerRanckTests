package solutions

object pascalTriangle {
  def main(args: Array[String]): Unit = {
    def factorial(n: Int): Int = n match {
      case 0 => 1
      case _ => n * factorial(n - 1)
    }

    def binom(n: Int, k: Int): Int = {
      require(0 <= k && k <= n)

      @annotation.tailrec
      def binomtail(nIter: Int, kIter: Int, ac: Int): Int = {
        if (kIter > k) ac
        else binomtail(nIter + 1, kIter + 1, (nIter * ac) / kIter)
      }

      if (k == 0 || k == n) 1
      else binomtail(n - k + 1, 1, 1)
    }
    var str = ""
    val n = scala.io.StdIn.readInt()
     for (i <- 0 until n){
       for (j <- 0 to i ){
         str += binom(i,j).toString + " "
       }
       str += "\n"
     }
println(str)
  }
}
