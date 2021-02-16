package solutions

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks

object ConvexHull {

  def main(args: Array[String]): Unit = {

    def convexHull(points: ArrayBuffer[(Int, Int)]): List[(Int, Int)] = {


      // 2D cross product of OA and OB vectors, i.e. z-component of their 3D cross product.
      // Returns a positive value, if OAB makes a counter-clockwise turn,
      // negative for clockwise turn, and zero if the points are collinear.
      def cross(p1: (Int,Int), p2: (Int,Int), p3: (Int,Int)): Int = {
        (p2._1 - p1._1) * (p3._2 - p1._2) - (p2._2 - p1._2) * (p3._1 - p1._1)
      }

      def distance(o: (Int, Int), a: (Int, Int)): Double = {
        if (o == a) return null.asInstanceOf[Double]
        math.sqrt(math.pow(o._2 - a._2, 2) + math.pow(o._1 - a._1, 2))

      }


      val distinctPoints = points.distinct

      // No sorting needed if there are less than 2 unique points.
      if (distinctPoints.length < 2) {
        return points.toList
      } else {

        val sortedPoints = distinctPoints.sorted
        val initialPoint = sortedPoints(0)
        val hull = ArrayBuffer[(Int, Int)]()
        hull.append(initialPoint)
        var prevVertex = initialPoint
        val whileLoop = new Breaks
        val forLoop = new Breaks
        whileLoop.breakable {
          while (true) {
            var candidate = null.asInstanceOf[(Int, Int)]
            for (p <- sortedPoints) {
              forLoop.breakable {

                if (p == prevVertex) forLoop.break()
                if (candidate == null) {
                  candidate = p
                  forLoop.break()
                }
                val ccw = cross(prevVertex, candidate, p)
                if (ccw == 0 && distance(prevVertex,candidate)< distance(prevVertex,p)){
                  candidate = p

                }else if(ccw <0){
                  candidate = p
                }

              }


            }
            if (candidate == initialPoint){
              whileLoop.break()
            }
            hull.append(candidate)
            prevVertex = candidate

          }
        }



        return hull.toList
      }
    }

    val n = scala.io.StdIn.readInt()
    var l = new ArrayBuffer[(Int, Int)]()
    (1 to n).foreach(k => {
      val line = scala.io.StdIn.readLine().trim.split(" ")
      l = l :+ (line(0).toInt, line(1).toInt)
    })
   // println(l.length)
    val outp: List[(Int, Int)] = convexHull(l).sortBy(_._1)
    var len = math.sqrt(math.pow(outp.last._2 - outp.head._2, 2) + math.pow(outp.last._1 - outp.head._1, 2))
    for (i <- 1 until outp.length) {

      len = len + math.sqrt(math.pow(outp(i)._2 - outp(i - 1)._2, 2) + math.pow(outp(i)._1 - outp(i - 1)._1, 2))
    }
    //outp.foreach(println)
    println(len)

  }
}






