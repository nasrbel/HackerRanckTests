package solutions

object mergeTwoStrings extends App  {
//
//  val p = scala.io.StdIn.readLine()
//  val q = scala.io.StdIn.readLine()
//
//  if(p.length == q.length){
//    var mergedStr  = ""
//    val p0 = p.toCharArray
//    val q0 = q.toCharArray
//    p0.zip(q0).foreach(el => {
//el._1.toString.concat(el._2.toString)
//
//    })
//    mergedStr =  mergedStr.replace("  "," ")
//    println(mergedStr)
//  }

  println(scala.io.StdIn.readLine().trim.zip(scala.io.StdIn.readLine().trim).map(item => item._1.toString + item._2.toString).mkString(""))

}
