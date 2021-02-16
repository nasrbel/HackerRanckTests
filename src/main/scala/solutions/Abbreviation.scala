package solutions

object Abbreviation {
  def main(args: Array[String]): Unit = {


  }

  def abbreviation(a: String, b: String): String = {
    val aLen = a.length
    val bLen = b.length
    // arr[i][j] = true iff a(0..i-1) can match b(0..j-1)
    val arr = Array.ofDim[Boolean](aLen + 1, bLen + 1)  // Array[Array[Boolean]]()
    arr(0)(0) = true
    for (i <- 1 to aLen) {
      arr(i)(0) = arr(i - 1)(0) && Character.isLowerCase(a.charAt(i - 1))
    }
    for (i <- 1 to aLen) {
      for (j <- 1 to bLen) {
        arr(i)(j) = (arr(i - 1)(j - 1) && Character.toUpperCase(a.charAt(i - 1)) == b.charAt(j - 1)) || (arr(i - 1)(j) && Character.isLowerCase(a.charAt(i - 1)))
      }
    }
    if (arr(aLen)(bLen)) "YES"
    else "NO"
  }


}

