package solutions

object scoreAliceBob {
  import java.io._

  import scala.io._



    // Complete the compareTriplets function below.
    def compareTriplets(a: Array[Int], b: Array[Int]): Array[Int] = {
      val aliceScore = a.zip(b).map(e => if(e._1 >e._2 ) 1 else 0).sum
      val bobScore  = b.zip(a).map(e => if(e._1 >e._2 ) 1 else 0).sum
      Array(aliceScore,bobScore)

    }

    def main(args: Array[String]) {
      val printWriter = new PrintWriter(sys.env("/home/nassereddine/Bureau/network/out/"))

      val a = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

      val b = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
      val result = compareTriplets(a, b)

      printWriter.println(result.mkString(" "))

      printWriter.close()
    }



}
