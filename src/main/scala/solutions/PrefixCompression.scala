package solutions

object PrefixCompression {
  def main(args: Array[String]): Unit = {
    //read input string 1 and 2


    //find longest common substring starting from 0
    //recursive function
    //test the first letter of string 1 exists  in string 2 string2.head  (string 1 == shortest string)
    // -----> if(firstLetter exists ) x' = x' + firstLetter ; y' = firstString.tail
    // -------> else break
    //take the string1 = string1.tail and repeat the process


    //abcdefpr
    //abcpqr
    def commonPrefix(s1: String, s2: String): (String, String) = {
      val firstString: String = List(s1, s2).minBy(e => e.length)
      val secondString: String = List(s1, s2).maxBy(e => e.length)
      if (firstString == secondString) {
        return (firstString, secondString)
      } else if (firstString == "") {
        return (firstString, secondString)
      } else {
        if (firstString.head != secondString.head) {
          return (firstString, secondString)
        } else {
          return commonPrefix(firstString.tail, secondString.tail)

        }
      }
      ("", "")

    }

    var s1 = "abcdefpr"
    var s2 = "abcpqr"

    s1 = scala.io.StdIn.readLine().split("\\s+")(0)

    s2 = scala.io.StdIn.readLine().split("\\s+")(0)


    val output = commonPrefix(s1, s2)
    val shortestString = List(s1, s2).minBy(_.length)
    val longestString = List(s1, s2).maxBy(_.length)
    var longestPrefix = ""
    if(shortestString==longestString){
      longestPrefix = shortestString
    }else {
      longestPrefix = shortestString.replace(output._1,"")
    }
    val (x, y) = if (shortestString == s1) (shortestString, longestString) else (longestString, shortestString)
    val x1 = x.replace(longestPrefix,"")
    val y1 = y.replace(longestPrefix,"")
    println(longestPrefix.length + " " + longestPrefix)
    println(x1.length + " " + x1)
    println(y1.length + " " + y1)

  }

}
