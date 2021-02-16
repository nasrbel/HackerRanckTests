package solutions
import scala.io.StdIn._

object wordPuzzle {
  type MyMap = Array[Array[Char]]

  def main(args: Array[String]) {
    val xdt = (1 to 10).map(l => readLine.trim.toCharArray.map(c => if (c == '-') true else false)).toArray
    //xdt.foreach(e => e.foreach(println))
    val words = readLine.trim.split(";").toList
    //      println(words)
    val ydt =
      (for (x <- 0 to 9)
        yield (for (y <- 0 to 9)
          yield xdt(y)(x)).toArray).toArray

    def findFragment(l: List[Boolean]): List[Tuple2[Int, Int]] = {
      def find(l: List[Tuple2[Boolean, Int]]): List[Tuple2[Int, Int]] = {
        val s = l.dropWhile(_._1 == false)
        if (s.isEmpty)
          Nil
        else {
          val e = s.dropWhile(_._1 == true)
          (s.head._2, e.head._2 - s.head._2) +: find(e)

        }
      }
      val l2 = (l :+ false).zipWithIndex
      find(l2).filter(t => t._2 > 1)
    }
    val zx = xdt.zipWithIndex
    val zy = ydt.zipWithIndex
//    println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
//    println(xdt.toList.map(_.toList))
//    println(ydt.toList.map(_.toList))


    val xe = zx.map(t => findFragment(t._1.toList).map(v => (v._1, t._2, v._2, (1, 0)))).filter(!_.isEmpty)
    val ye = zy.map(t => findFragment(t._1.toList).map(v => (t._2, v._1, v._2, (0, 1)))).filter(!_.isEmpty)
    val aa = (xe ++ ye).flatten

    //      println(aa.mkString)
    val DEFAULTCHAR = '+'
    val map = Array.ofDim[Char](10, 10)
    for (y <- 0 to 9; x <- 0 to 9) { map(x)(y) = DEFAULTCHAR }

    def dupArray(src: MyMap): MyMap = {
      val dst = Array.ofDim[Char](10, 10)
      for (y <- 0 to 9; x <- 0 to 9) { dst(x)(y) = src(x)(y) }
      dst
    }

    def fill(map: MyMap, word: String, x: Int, y: Int, ox: Int, oy: Int): Option[MyMap] = {
      if (word.isEmpty) {
        Option(map)
      } else {
        if (map(x)(y) != DEFAULTCHAR && map(x)(y) != word.head) {
          None
        } else {
          map(x)(y) = word.head
          fill(map, word.tail, x + ox, y + oy, ox, oy)
        }
      }
    }

    words.permutations.foreach { p =>
      val zipped = p.zip(aa)
             //println(zipped.filter(e => e._1.length == e._2._3).size,words)
      if (zipped.filter(e => e._1.length == e._2._3).size == words.size) {
                       //  println(zipped)
        val newMap = dupArray(map)
        val stat = zipped.map(z => {
          val z2 = z._2
          //(String, (Int, Int, Int, (Int, Int)))]
          fill(newMap, z._1, z2._1, z2._2, z2._4._1, z2._4._2)
        })
        if (stat.collect { case Some(x) => x }.size == zipped.size) {
          dump(newMap)
        }
      }
    }

    def dump(map: MyMap) = {
      for (y <- 0 to 9) {
        for (x <- 0 to 9) {
          print(map(x)(y))
        }
        println
      }
    }
  }
  val grid0 = Array("+-++++++++", "+-++++++++", "+-++++++++", "+-----++++", "+-+++-++++", "+-+++-++++", "+++++-++++", "++------++", "+++++-++++", "+++++-++++")
  val words0 = List("LONDON", "DELHI", "ICELAND", "ANKARA")
  val grid1 = Array("+-++++++++", "+-++++++++", "+-------++", "+-++++++++", "+-++++++++", "+------+++", "+-+++-++++", "+++++-++++", "+++++-++++", "++++++++++")
  val words1 = List("AGRA", "NORWAY", "ENGLAND", "GWALIOR")

  val grid2 = Array("+-++++++++", "+-++-+++++", "+-------++", "+-++-++-++", "+-++-++-++", "+-++-++-++", "++++-++-++", "+--------+", "++++++++++", "----------")
  val words2 = "CALIFORNIA;LASVEGAS;NIGERIA;CANADA;TELAVIV;ALASKA".split(";").toList

}



