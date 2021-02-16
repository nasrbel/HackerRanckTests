package solutions



object perimeterPolygon {

  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution

*/
    val n = scala.io.StdIn.readInt()
    val arr = (1 to n).map(k => {
      val line = scala.io.StdIn.readLine().split("\\s+")
      (line(0),line(1))
    }).toList
    arr.foreach(println)

    var dist = 0.0
    (0 until n-1).foreach(k => {
      dist = dist + math.sqrt(math.pow(arr(k+1)._2.toDouble - arr(k)._2.toDouble,2) + math.pow((arr(k+1)._1.toDouble - arr(k)._1.toDouble),2))



    })
    dist = dist + math.sqrt(math.pow(arr(n-1)._2.toDouble - arr(0)._2.toDouble,2) + math.pow((arr(n-1)._1.toDouble - arr(0)._1.toDouble),2))

   println(dist)
  }
}
