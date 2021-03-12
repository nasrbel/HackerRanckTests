package certificationsHacker

import scala.collection.mutable.ArrayBuffer

object test_iam extends App {
//  val l = (1 until 5).toList.permutations.toList
// println("%%%%%%%%%%%%first appr %%%%%%%%%%%%%%%%")
//  l.foreach(println)
//
//
//  def interleave(x:Int, l:List[Int]):List[List[Int]] = {
//    l match {
//      case Nil => List(List(x))
//      case (head::tail) =>
//        (x :: head :: tail) :: interleave(x, tail).map(head :: _)
//    }
//  }
//
//  def permutations(l:List[Int]):List[List[Int]] = {
//    l match {
//      case Nil => List(List())
//      case (head::tail) =>
//        for(p0 <- permutations(tail); p1 <- interleave(head, p0)) yield p1
//    }
//  }




  def maxCost(cost: Array[Int], labels: Array[String], dailyCount: Int): Int = {

    val l = cost.zip(labels)
    var k = 0
    var cost_list = ArrayBuffer[Int]()
    var np = 0
    var coun = 0

    while(k < cost.length) {
      while (coun < labels.length && np < dailyCount) {
      if (labels(coun) == "legal") {
        np += 1
      }
      coun += 1
    }

    val c: Array[(Int, String)] = l.slice(k, k + coun-1)
    val cost_c = c.map(_._1).sum
    cost_list += cost_c
    k = coun+1

  }

    cost_list.max

  }
  val cost = Array(2,5,3,11,1)
  val labels = Array("legal","illegal","legal","illegal","legal")
 println(maxCost(cost,labels,2))

}
