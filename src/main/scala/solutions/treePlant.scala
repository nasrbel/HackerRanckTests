//package solutions
//
//import scala.annotation.tailrec
//
//
////import solutions.treePlant.FunctionalHelpers
////import solutions.treePlant.FunctionalHelpers.get
////import solutions.treePlant.trees.{Board, Brunchs, Point, Points, aBasicBrunch, brunch, newBoard, paintPointsOnBoard, splitTree}
//
//object  treePlant {
//
//  def main(args: Array[String]): Unit = {
//    //   import FunctionalHelpers._
//    //
//    //
//    //
//    //
//    //    object trees {
//    //
//    //      case class brunch(p: Point, size: Int)
//    //
//    //      case class Point(x: Int, y: Int)
//    //
//    //      type Board = Array[Array[Char]]
//    //      type Brunchs = Seq[brunch]
//    //      type Points = Seq[Point]
//    //
//    //      def printTree(iterations: Int): Unit = {
//    //        (get(aBasicBrunch) andThen
//    //          splitTree(iterations) andThen
//    //          extractPointsFromTree andThen
//    //          paintPointsOnBoard(newBoard) andThen
//    //          printBoard) ()
//    //      }
//    //
//    //      private def aBasicBrunch: brunch = brunch(Point(x = 49, y = 63), size = 16)
//    //
//    //      private def newBoard: Board = Array.fill(63)(Array.fill(100)('_'))
//    //
//    //      private def splitTree(N: Int): brunch => Brunchs = { startingTree =>
//    //        repeat(splitAllTrees, N)(Seq(startingTree))
//    //      }
//    //
//    //      private def extractPointsFromTree: Brunchs => Points = _ flatMap getColoredPointsFromATree
//    //
//    //      private def paintPointsOnBoard(board: Board): Points => Board = { points: Points =>
//    //        points.foldLeft(board.clone()) { (mutatedBoard: Board, point: Point) =>
//    //          mutatedBoard(point.y).update(point.x, '1')
//    //          mutatedBoard
//    //        }
//    //      }
//    //
//    //      private def printBoard: Board => Unit = { board => for (row <- board) println(row.mkString) }
//    //
//    //      /**
//    //       *
//    //       * @param tree
//    //       * @return
//    //       */
//    //
//    //      private def getColoredPointsFromATree(tree: brunch): Points = {
//    //        for {
//    //          x <- 0 until tree.size
//    //          row <- tree.p.x -x to tree.p.x +x
//    //        } yield Point(x+row, tree.p.y)
//    //      }
//    //
//    //      private def splitTriangleToThreeSmallerTriangles: brunch => Brunchs = { t: brunch =>
//    //        Seq(
//    //          brunch(Point(t.p.x, t.p.y), t.size),
//    //          brunch(Point(t.p.x - t.size, t.p.y - 2*t.size), t.size / 2),
//    //          brunch(Point(t.p.x + t.size, t.p.y - 2*t.size), t.size / 2))
//    //      }
//    //
//    //      private def splitAllTrees: Brunchs => Brunchs = _ flatMap splitTriangleToThreeSmallerTriangles
//    //    }
//    //
//    //    object FunctionalHelpers {
//    //      def repeat[T](f: T => T, times: Int)(start: T): T = {
//    //        if (times == 0) start
//    //        else repeat(f, times - 1)(f(start))
//    //      }
//    //
//    //      def get[T](t: T): Unit => T = _ => t
//    //    }
//    //
//    //
//    //
//    //
//    //
//    //    import trees._
//    //
//    //    printTree(1)
//    //  }
//    //def drawTrees(n: Int): Unit = {
//    //  def recursiveTrees(n: Int, pHeight: Int, root: Int, base: Int, arr: Array[Array[Char]]): Array[Array[Char]] = {
//    //    if (n > 0) {
//    //      for (i <- Range(base, base-pHeight, -1)) {
//    //        println(i,root)
//    //        arr(i)(root) = '1'
//    //      }
//    //      @tailrec
//    //      def fill_branch(i: Int, j: Int, x:Int, counter: Int): Unit = {
//    //        if (counter != 0) {
//    //          arr(x)(i) = '1'
//    //          arr(x)(j) = '1'
//    //          fill_branch(i-1, j+1, x-1, counter-1)
//    //        }
//    //      }
//    ////      println("the pHeight is  ", pHeight)
//    ////      println("the root is ", root)
//    //      fill_branch(root-1, root+1, base-pHeight, pHeight)
//    //      recursiveTrees(n-1, pHeight/2, root-pHeight, base-(pHeight*2), arr)
//    //      recursiveTrees(n-1, pHeight/2, root+pHeight, base-(pHeight*2), arr)
//    //    }
//    //     arr
//    //  }
//    //  recursiveTrees(n, 16, 49, 62, Array.fill(63, 100)('_')).foreach(row => println(row.mkString))
//    //}
//    //
//    //  def main(args: Array[String]) {
//    //    drawTrees(StdIn.readInt())
//    //  }
//    object Tree {
//
//      import FunctionalHelpers._
//
//
//      /**
//       * Props of a tree
//       *
//       * @param p       : starting point
//       * @param bLength high of a brunch of a tree
//       */
//      case class brunch(p: Point, bLength: Int)
//
//      case class Point(x: Int, y: Int)
//
//
//
//      def printTree(iterations: Int): Unit = {
//        (get(aBasicBrunch) andThen
//          splitTree(iterations) andThen
//          extractPointsFromTree andThen
//          paintPointsOnBoard(newBoard) andThen
//          printBoard) ()
//      }
//
//      object FunctionalHelpers {
//        def repeat[T](f: T => T, times: Int)(start: T): T = {
//          if (times == 0) start
//          else repeat(f, times - 1)(f(start))
//        }
//
//        def get[T](t: T): Unit => T = _ => t
//      }
//
//      /**
//       * needed types
//       */
//      type Board = Array[Array[Char]]
//      type Brunchs = Seq[brunch]
//      type Points = Seq[Point]
//
//      private def aBasicBrunch: brunch = brunch(Point(x = 63, y = 49), bLength = 16)
//
//      private def newBoard: Board = Array.fill(63)(Array.fill(100)('_'))
//
//      private def splitTree(N: Int): brunch => Brunchs = { startingTree =>
//        repeat(splitAllTrees, N)(Seq(startingTree))
//      }
//
//      private def createTwoBrunchsFromPrincipalBrunch: brunch => Brunchs = { t: brunch =>
//        Seq(
//          brunch(Point(t.p.x, t.p.y), t.bLength),
//          brunch(Point(t.p.x + t.bLength, t.p.y -1), t.bLength / 2),
//          brunch(Point(t.p.x + t.bLength, t.p.y + 1), t.bLength / 2))
//      }
//
//      private def splitAllTrees: Brunchs => Brunchs = _ flatMap createTwoBrunchsFromPrincipalBrunch
//
//      private def extractPointsFromTree: Brunchs => Points = _ flatMap getColoredPointsFromATree
//
//      private def getColoredPointsFromATree(tree: brunch): Points = {
//        //recursiveTrees(n: Int, pHeight: Int, root: Int, base: Int, arr: Array[Array[Char]]):
//        //recursiveTrees(n-1, pHeight/2, root+pHeight, base-(pHeight*2), arr)
//        for (i <- Range(tree.p.x, tree.p.x-tree.bLength, -1)) yield Point(i,tree.p.y)
//        @tailrec
//        def fill_branch(i: Int, j: Int, x:Int, counter: Int): Unit = {
//          if (counter != 0) {
//            return Seq(Point(x,i),Point(x,j))
//            fill_branch(i-1, j+1, x-1, counter-1)
//
//          }
//        }
//        fill_branch(tree.p.x-1, tree.p.x+1, tree.p.y-tree.bLength, tree.bLength)
////        for {
////          row <- Range(tree.p.y,tree.p.y-(tree.bLength*2),-1)
////          x <- Range(tree.p.x, tree.p.x + tree.bLength, -1)
////        } yield Point(x +tree.bLength , tree.p.y+row)
//      }
//
//      private def paintPointsOnBoard(board: Board): Points => Board = { points: Points =>
//        points.foldLeft(board.clone()) { (mutatedBoard: Board, point: Point) =>{
//          //println(point.x,point.y)
//          mutatedBoard(point.y).update(point.x, '1')
//        }
//          mutatedBoard
//        }
//      }
//
//      private def printBoard: Board => Unit = { board => for (row <- board) println(row.mkString) }
//
//
//    }
//
//
//    import Tree._
//
//    printTree(1)
//  }
//}
