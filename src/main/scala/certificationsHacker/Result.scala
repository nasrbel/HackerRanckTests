import scala.collection.mutable.ArrayBuffer
import scala.io._


object Result {

  /*
   * Complete the 'findSubstring' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. INTEGER k
   */

  def findSubstring(s: String, k: Int): String = {
    val vowels = List('a', 'e', 'i', 'o', 'u')
    if (s.length == k) {
      return s
    } else {
      //get the
      val vowelsNumberArray = new ArrayBuffer[(Int, Int)]()
      var j = 0
      while (j + k <= s.length) {
        println("%%%%%%%%%%%%%%%%%%%%%%%%%%%")
        s.substring(j, k + j).toCharArray.zipWithIndex.filter((e => vowels.contains(e._1))).foreach(println)
        vowelsNumberArray.append((s.substring(j, k + j).toCharArray.zipWithIndex.count(e => vowels.contains(e._1)), j+1))
        println(s.substring(j, k + j).toCharArray.zipWithIndex.count(e => vowels.contains(e._1)))
        j += 1
      }

      //println(vowelsNumberArray.maxBy(_._2)._1)
      val filtredArra = vowelsNumberArray.filter(e => e._1 == vowelsNumberArray.maxBy(_._1)._1)
      //println(filtredArra)

      if (vowelsNumberArray.maxBy(_._1)._1 != 0) {
        if (filtredArra.length == 1) {
          return s.substring(filtredArra(0)._2, k+filtredArra(0)._2 )
        } else if (filtredArra.length > 1) {
          return s.substring(filtredArra.minBy(_._2)._2, k+filtredArra.minBy(_._2)._2)
        }
      } else {
        return "Not Found!"
      }

    }
    s

  }

}

object Solution {

  def main(args: Array[String]) {
    // val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s = StdIn.readLine

    val k = StdIn.readLine.trim.toInt

    val result = Result.findSubstring(s, k)

    println(result)

    // printWriter.close()
  }
}
