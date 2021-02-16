package solutions

object SierpinskiTriangles {
  def main(args: Array[String]): Unit = {
    import FunctionalHelpers._




    object SiepinskyTriangles {

      case class Triangle(p: Point, size: Int)

      case class Point(x: Int, y: Int)

      type Board = Array[Array[Char]]
      type Triangles = Seq[Triangle]
      type Points = Seq[Point]

      def printSierpinskiTriangles(iterations: Int): Unit = {
        (get(aBasicTriangle) andThen
          splitTriangle(iterations) andThen
          extractPointsFromTriangles andThen
          paintPointsOnBoard(newBoard) andThen
          printBoard) ()
      }

      private def aBasicTriangle: Triangle = Triangle(Point(x = 31, y = 0), size = 32)

      private def newBoard: Board = Array.fill(32)(Array.fill(63)('_'))

      private def splitTriangle(N: Int): Triangle => Triangles = { startingTriangle =>
        repeat(splitAllTriangles, N)(Seq(startingTriangle))
      }

      private def extractPointsFromTriangles: Triangles => Points = _ flatMap getColoredPointsFromATriangle

      private def paintPointsOnBoard(board: Board): Points => Board = { points: Points =>
        points.foldLeft(board.clone()) { (mutatedBoard: Board, point: Point) =>
          mutatedBoard(point.y).update(point.x, '1')
          mutatedBoard
        }
      }

      private def printBoard: Board => Unit = { board => for (row <- board) println(row.mkString) }

      private def getColoredPointsFromATriangle(triangle: Triangle): Points = {
        for {
          row <- 0 until triangle.size
          x <- (triangle.p.x - row) to (triangle.p.x + row)
        } yield Point(x, triangle.p.y + row)
      }

      private def splitTriangleToThreeSmallerTriangles: Triangle => Triangles = { t: Triangle =>
        Seq(
          Triangle(Point(t.p.x, t.p.y), t.size / 2),
          Triangle(Point(t.p.x - t.size / 2, t.p.y + t.size / 2), t.size / 2),
          Triangle(Point(t.p.x + t.size / 2, t.p.y + t.size / 2), t.size / 2))
      }

      private def splitAllTriangles: Triangles => Triangles = _ flatMap splitTriangleToThreeSmallerTriangles
    }

    object FunctionalHelpers {
      def repeat[T](f: T => T, times: Int)(start: T): T = {
        if (times == 0) start
        else repeat(f, times - 1)(f(start))
      }

      def get[T](t: T): Unit => T = _ => t
    }





      import SiepinskyTriangles._

      printSierpinskiTriangles(0)
    }




}
