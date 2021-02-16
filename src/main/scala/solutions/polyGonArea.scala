package solutions

object polyGonArea {

  def main(args: Array[String]): Unit = {

    /**
     * get the number of inputs coordinates
     */
    val n = scala.io.StdIn.readInt()
    /**
     * save the coordinates
     */
    val arr = (1 to n ).map(k =>
    {
      val line = scala.io.StdIn.readLine().split("\\s+")
      (line(0).toDouble,line(1).toDouble)
    }).toList


    /**
     * get the x axis points
     */
    var vector1 : List[Double] = arr.map(_._1)
    vector1 = vector1 :+ arr.head._1
    /**
     * get the y axis points
     */
    var vector2 : List[Double] = arr.map(_._2)
    vector2 = vector2 :+ arr.head._2
    /**
     * multiply up to down
     */
    val p = vector2.size
    val multVect1 = (0 to p-2 ).map( k=> {
      vector1(k)*vector2(k+1)
    }).toList
    /**
     * multiply down to up
     */

    val multVect2 = (p-1 to  1 by -1 ).map( k=> {
      vector1(k)*vector2(k-1)
    }).toList
    /**
     * compute the area
     */
    val area = math.abs((0 until p-1).map(k => {
      multVect1(k)-multVect2(k)
    }).toList.sum)/2



println(area)
  }

}
