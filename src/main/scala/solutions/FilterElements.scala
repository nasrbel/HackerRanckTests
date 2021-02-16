package solutions

import scala.collection.mutable.ArrayBuffer

object FilterElements {
  def main(args: Array[String]): Unit = {

    val numberTestCase = scala.io.StdIn.readInt()
    (1 to numberTestCase).foreach(k=> {
      val line1 = scala.io.StdIn.readLine().split(" ")
      val listSize = line1(0).toInt
      val occurenceNumb = line1(1).toInt
      var IntegerList = scala.io.StdIn.readLine().split(" ").map(e => e.toInt).toList
      var outputList = getOccu(IntegerList, occurenceNumb, new ArrayBuffer[Int]())
      if(outputList.isEmpty){
        println("-1")
      }else{
        var str = ""
        outputList.foreach(e => str += e.toString+" ")
        println(str)
      }
    })



  }

  def getOccu(IntegerList: List[Int], OccNumber: Int, outputList: ArrayBuffer[Int]): List[Int] = {
    var IntegerList0 = IntegerList
    var outputList0 = outputList
    //take the head of the list and compute its occurence in the tail
    //compare the occurence to occNumber : if >= we save the number in list
    //else we go as:
    //filter the list tail based on the previous head
    //call the getOcc on the filtred list tail
    //4 ,5, 2 ,5 ,4 ,3 ,1 ,3 ,4
    if (IntegerList0.nonEmpty) {

      while (IntegerList0.count(_.equals(IntegerList0.head)) >= OccNumber) {
        outputList0 += IntegerList0.head
        IntegerList0 = IntegerList0.filterNot(_.equals(outputList0.last))


      }
    }
    if(IntegerList0.isEmpty){
        return outputList0.toList
      }else {
      return getOccu(IntegerList0.tail,OccNumber,outputList0)
    }
    println(outputList0)
    outputList0.toList

  }



}
