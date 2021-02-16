package solutions

import scala.io.StdIn

object   MigratoryBirds {

  def migratoryBirds(arr: Array[Int]) = {
    val a = arr.map(e => (e,1)).groupBy(_._1).mapValues(_.map(_._2).sum)
 a.toList.sortBy(_._1).maxBy(_._2)._1


  }

  def main(args: Array[String]) {

    val arrCount = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    val result = migratoryBirds(arr)

    println(result)


  }

}