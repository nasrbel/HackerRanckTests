package Streaming

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

object loveStream {
  def main(args: Array[String]): Unit = {

    val T = scala.io.StdIn.readLine().split("\\s+")(0).toInt
    (1 to T).foreach(k => {

      val n = scala.io.StdIn.readLine().split("\\s+")(0).toInt
      var inputArray = ArrayBuffer[Byte]()
      var index = 0
      breakable{
      for (ln <- io.Source.stdin.getLines) {
        if (ln.contains('e')) {
          break
        } else {
          inputArray += ln.toByte
          index += 1
        if (isItDivisibleByN(inputArray.toArray, n)) {
          println(index + " She loves me")
        }else{
          println(index+" She loves me not")
        }
      }
      }
    }
      println("                 ")


    })




  }
def convertByteToint(inputArr:Array[Byte])={
  var convertedInt = 0
  for(i <-inputArr.indices){
    convertedInt += inputArr(i)*math.pow(2,i).toInt
  }
  convertedInt
}
def isItDivisibleByN(inputArr: Array[Byte],n :Int ): Boolean ={

  if(convertByteToint(inputArr) % n == 0){
    return true
  }
  false

}






}
