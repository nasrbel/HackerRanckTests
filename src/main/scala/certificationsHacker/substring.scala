package certificationsHacker

import scala.collection.mutable.ArrayBuffer

object substring {

  import java.io._

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
      val vowels = List('a', 'e','i','o','i')
      if(s.length == k){
        return s
      }else{
        //get the
        val vowelsNumberArray = new ArrayBuffer[(Int,Int)]()
        val sub1 = s.toCharArray.zipWithIndex
        for(j <- 0 until s.length){
          vowelsNumberArray.append((s.substring(j,k).toCharArray.filter(e => vowels.contains(e)).length ,k))

        }
        val filtredArra = vowelsNumberArray.filter(e=> e._1 == vowelsNumberArray.maxBy(_._2)._1)
        if(filtredArra.length==1){
          return s.substring(filtredArra(0)._2,k)
        }else{
          s.substring(filtredArra.minBy(_._2)._2,k)
        }

      }
      s

    }

  }

  object Solution {
    def main(args: Array[String]) {
      val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

      val s = StdIn.readLine

      val k = StdIn.readLine.trim.toInt

      val result = Result.findSubstring(s, k)

      printWriter.println(result)

      printWriter.close()
    }
  }



}
