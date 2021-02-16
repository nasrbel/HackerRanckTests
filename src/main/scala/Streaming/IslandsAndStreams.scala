package Streaming

import scala.collection.mutable.ArrayBuffer

object IslandsAndStreams {


  def main(args: Array[String]): Unit = {






    //read the number of (x,y) and the nb of queries : n,m
    val line  = scala.io.StdIn.readLine().split("\\s+")
    val n = line(0).toInt
    val m = line(1).toInt
    var inputXYarray = new ArrayBuffer[(Int,Int)](n)

    //read the (x,y) ans store them in a an array buffer (to keep the order )
    //initial stream details : initial island positions
    (1 to n).foreach(k => {
      val XYline = scala.io.StdIn.readLine().trim.split(" ")
      inputXYarray.append((XYline(0).toInt,XYline(1).toInt))

    })
      //read the query and print the cost
      var queryArray = List[Int]()
      (1 to m ).foreach(k=>{
      val queryLine = scala.io.StdIn.readLine().trim.split(" ")
        queryArray = queryLine.map(e => e.toInt).toList
        //compute the cost of the trip based in the given query
        //if queryArray(0) = 1 :
       val output =  cost(queryLine.map(e => e.toInt).toList,inputXYarray)
        if(queryArray.head==1){
          println(output)
        }

      } )

    }

  def cost(l : List[Int], islandPositions0 : ArrayBuffer[(Int,Int)]) :  Int  = {
    var i = 0  // gary is in i th island
    var j = 0   // ChHavi is j th island
    var islandPositions = islandPositions0
    val n = islandPositions.length
     if (l.head==1){
       i = l(1)
       j = l(2)
     }else{

       //get the index of the island
     var index = l(1) - 1
       islandPositions.update(index-1,(l(1)-l(2),  islandPositions(index-1)._2))
       islandPositions.update(index,(islandPositions(index)._1,l(1)+l(3)))



     }

    var k = i
    var GaryCost = 0
    var chaHaviCost = 0

    while(k < islandPositions.length &&  i+islandPositions(k)._2 <= n){
      //gary is not arrived to arcada

      GaryCost += 1
      k = k+1
    }

    var p = j
    while(p < islandPositions.length &&  j+islandPositions(p)._2 <= n){
      p +=1
      chaHaviCost += 1
    }

     GaryCost +chaHaviCost +2


  }


}
