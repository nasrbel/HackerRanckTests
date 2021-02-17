package solutions


class magicMatrix {

  /**
   * In the case of 3x3 matrix the magic sum is 15
   * Please to take a look to this link: https://en.wikipedia.org/wiki/Magic_square
   * We need to define wether an Int is having a good place in the matrix or not
   * Having a good place means that the sum ( row or column) is 15
   * than from te list(1,9) get what is missing
   * replace
   * @param
   * @return
   */

    def getMissingNumbers(matrix:Array[Array[Int]]): List[Int]={
      var list : List[Int] = List()
      matrix.map(_.distinct).map(e => e.toList+:list )
      (1 to 9 ).toList.filterNot(p => list.contains(p))
    }


//
//  def formingMagicSquare(s: Array[Array[Int]]): Int = {
//
//
//  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn


    val s = Array.ofDim[Int](3, 3)

    for (i <- 0 until 3) {
      s(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    //val result = formingMagicSquare(s)
    val result = getMissingNumbers(s)

    println(result)

  }


}
