package solutions

object inverseOrderString extends  App {

  /**
   * //this solution is time consuming
   **
   *val n = scala.io.StdIn.readInt()
   **
   *(1 to n).foreach(j => {
   * val str = scala.io.StdIn.readLine().trim().zipWithIndex
   * val listEven: Seq[(Char, Int)] = str.filter(ele => (str.indexOf(ele) % 2== 0)).toList
   * val listOdd = str.filter(ele => str.indexOf(ele) % 2 == 1).toList
   * println(listOdd.zip(listEven).map(el =>
   *el._1._1.toString.concat(el._2._1.toString)).mkString)
   **
   *
   * })
   *
   */
  def swapPairs(str: String) = {
    str.grouped(2)
      .map(x => s"${x.tail}${x.head}")
      .mkString
  }

  val n = scala.io.StdIn.readInt()
  (1 to n).foreach(j => {
    val str = scala.io.StdIn.readLine().trim()
    println(swapPairs(str))

  })
}
