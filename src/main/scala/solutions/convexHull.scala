package solutions




      case class Point(x: Int, y: Int) {
        def angleWith(p: Point): Double = Math.atan2(p.y - y, p.x - x)
        def distance(p: Point): Double = Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2))
      }

      object Point {
        def apply(a: Array[Int]): Point = Point(a(0), a(1))
      }

      object Solution {
        def ccw(p1: Point, p2: Point, p3: Point): Boolean = {
          (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x) >= 0
        }

        def convexHull(sortedPoints: List[Point]): List[Point] = {
          convexHull(sortedPoints.take(3).reverse, sortedPoints.drop(3) :+ sortedPoints.head)
        }

        def convexHull(hullPoints: List[Point], restPoints: List[Point]): List[Point] = {
          if (restPoints == Nil) hullPoints
          else if (ccw(hullPoints(1), hullPoints(0), restPoints(0))) {
            convexHull(restPoints.head :: hullPoints, restPoints.tail)
          } else {
            convexHull(hullPoints.tail, restPoints)
          }
        }

        def lowestPoint(pts: Array[Point]): Point = pts.minBy(p => p.y * 10001 + p.x)

        def sortedPoints(pts: Array[Point]): List[Point] = {
          ((lowest: Point) =>
            pts.sortWith { (p1, p2) =>
              lowest.angleWith(p1).compare(lowest.angleWith(p2)) match {
                case 0 => lowest.distance(p1).compare(lowest.distance(p2)) < 0
                case n => n < 0
              }
            }.toList)(lowestPoint(pts))
        }

        def readPoints: Array[Point] = Array.fill(scala.io.StdIn.readLine().trim.toInt)(Point(scala.io.StdIn.readLine().split(" ").map(_.toInt)))

        def main(args: Array[String]): Unit = {
          printf("%.1f\n", convexHull(sortedPoints(readPoints)).sliding(2).map { case List(p1, p2) => p1.distance(p2) }.sum)
        }
      }


