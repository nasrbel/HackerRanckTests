package solutions


object magicMatrix {

  /**
   * In the case of 3x3 matrix the magic sum is 15
   * Please to take a look to this link: https://en.wikipedia.org/wiki/Magic_square
   * We need to define wether an Int is having a good place in the matrix or not
   * Having a good place means that the sum ( row or column) is 15
   * than from te list(1,9) get what is missing
   * replace
   *
   * @param
   * @return
   */



  def isItMagic(matrix: Array[Array[Int]]) : Boolean ={
    val n = matrix.length
    var col = 0
    var row =  0
    while(row < n && col < n ){
      if(matrix(row).sum != 15){
        return false
      }else{
        var s  = 0
        for(e <- matrix)  s += e(col)
        if(s != 15){
          return false
        }else{
          col += 1
        }
        row += 1
      }
      col += 1
    }
    true

  }
  def getMissingNumbers(matrix: Array[Array[Int]]): List[Int] = {

    //This function returns the list of missing integers
    // Note that the case is not complicated because the matrix is 3x3
    // complexity = 3 For loops + (9 - Number of distinct element in the matrix)

    var listOfInt = List[Int]()
   for (row <- matrix.indices){
     for(col <- matrix.indices){
       listOfInt = matrix(row)(col)::listOfInt
     }
   }
    listOfInt = listOfInt.distinct.sorted
    //we start with a stream of objects Stream<int[]>
     //we I'll map each int[] to IntStream



    (1 to 9).toList.filterNot(p => listOfInt.contains(p)).sorted
  }

  /**
   * In any magic square, the first number i.e. 1 is stored at position (n/2, n-1).
   * Let this position be (i,j). The next number is stored at position (i-1, j+1)
   * where we can consider each row & column as circular array i.e. they wrap around.
   * for 1 : (3/2,3-1) = (1,2) or (1,0) or (1,1)
   * for 2 :              (1-1,2+1) or(1-1,0+1) or (1-1,1+1) = (0,0) or (0,1) or (0,2)
   * @param matrix0
   * @param i
   * @param j
   * @return
   */


  def replaceInt(matrix0: Array[Array[Int]], i: Int, j: Int): Array[Array[Int]] = {
    val matrix = matrix0





    println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
    matrix.foreach(e => println(e.toList))
    val n = matrix.length
    if(isItMagic(matrix)){
      println("It is magic")
      return matrix
    }else {
      //i=0
      //j=0
      val rowSum = matrix(i).sum
      var colSum = 0
      for (k <- 0 until n) colSum += matrix(k)(j)
      if (rowSum != 15 && colSum != 15) {
        val missingIntrow = 15 - matrix(i).filterNot(_.equals(matrix(i)(j))).sum
        var missingIntCol = 0
        for (k <- 0 until n) if (k != i) missingIntCol += matrix(k)(j)
        missingIntCol = 15 - missingIntCol
        var missingIntDiag = 0
        if(i ==0 && j == 0) missingIntDiag = matrix(0)(0) + matrix(1)(1) + matrix(2)(2)
        if(i ==0 && j == 2)  missingIntDiag = matrix(2)(0) + matrix(1)(1) + matrix(0)(2)

        if(i==2 && j == 0) missingIntDiag = matrix(2)(0) + matrix(1)(1) + matrix(0)(2)
        if(i==2 && j == 2) missingIntDiag = matrix(0)(0) + matrix(1)(1) + matrix(2)(2)

        if(List((0,0),(0,2),(2,0),(2,2)).contains((i,j))){
          if(missingIntCol==missingIntrow && missingIntrow == missingIntDiag) {
            matrix(i)(j) = missingIntrow
        } else if (missingIntCol != missingIntrow) {

          } else {
            matrix(i)(j) = missingIntrow
          }
       }else {

          return replaceInt(matrix, i+1, j+1)
       }

      }
    }

        matrix0


  }



  def main(args: Array[String]) {
    val stdin = scala.io.StdIn


    val s = Array.ofDim[Int](3, 3)

    for (i <- 0 until 3) {
      s(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    //val result = formingMagicSquare(s)
    val result = replaceInt(s,0,0)

    println(result)

  }


}
