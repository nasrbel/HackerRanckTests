package Streaming

import scala.collection.mutable.ArrayBuffer

object StreamsOfScreams {
  def main(args: Array[String]): Unit = {

    val n = scala.io.StdIn.readLine().split("\\s+")(0).toInt
    var outputScore = new ArrayBuffer[(String, Int)]()
    (1 to n).foreach(k => {
      val line = scala.io.StdIn.readLine().split("\\s+")(0)
      if (line.equals("ghost")) {
        outputScore.append(("Ah!", 1))
      } else if (line.equals("boo!")) {
        outputScore.append(("Ahhh!!!", 3))
      }
    })
    val score = outputScore.map(e => e._2).sum
    outputScore.foreach(e => println(e._1))
    println(score)

  }











}
