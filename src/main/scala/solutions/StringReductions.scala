package solutions

import scala.io.StdIn._

object StringReductions {
  def main(args: Array[String]): Unit = {


    //for each letter k+1 check if the substring from 0 to k contains s(k+1)
    // if yes : replace s(k+1) by "" in the substring (K+1, s.length) then concat substring(0,K) substring(k+1,length)

    def reduceString(s:String): String  ={
      if(s.distinct.length == s.length){
        return s
      }else {

        if(s.tail.contains(s.head)){
          return reduceString(s.head.toString+s.tail.replace(s.head.toString,""))
        }else{
          return s.head + reduceString(s.tail)
        }

      }
      ""
    }

    val outPutString = reduceString(readLine().split("\\s+")(0))

    println(outPutString)


  }
}
