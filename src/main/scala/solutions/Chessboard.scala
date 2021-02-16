package solutions


object Chessboard {
  type Queen = (Int, Int)
  type Solutions = List[List[Queen]]

  def main(args: Array[String]) {
   val size = scala.io.StdIn.readInt()

    def solveNSuperQueens(n: Int): Solutions = n match {
      case 0 => List(Nil)
      case _ => for {
        queens <- solveNSuperQueens(n - 1)
        y <- 1 to size
        queen = (n, y)
        if (isSafe(queen, queens))
      } yield queen :: queens
    }

    val solutions = solveNSuperQueens(size)
    println(solutions.size )
    // print the board of the first solution
//    for (queen <- solutions.head; x <- 1 to size) {
//      if (queen._2 == x) print("Q ") else print(". ")
//      if (x == size) println()
//    }
  }

  def isSafe(queen: Queen, others: List[Queen]): Boolean =
    others forall (!isAttacked(queen, _))

  def isAttacked(q1: Queen, q2: Queen): Boolean =
    q1._1 == q2._1 || q1._2 == q2._2 ||  (q2._2 - q2._1) == (q1._2 - q1._1) || ((q2._1 + q2._2) == (q1._1 + q1._2)) || ((q1._1-q2._1).abs <= 2 && (q1._2 - q2._2).abs<=1) || ((q1._1 -q2._1).abs<=1 && (q1._2 - q2._2).abs <=2)

}

