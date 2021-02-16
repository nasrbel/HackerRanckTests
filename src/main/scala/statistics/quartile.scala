package statistics

object quartile {


  def median(arra: List[Int]): Int = {
    val sortedArr = arra.sorted
    val n = sortedArr.length
    if (n % 2 == 1) {
      return sortedArr(n / 2)
    } else {
      return ((sortedArr(n / 2) + sortedArr(n / 2 - 1)) / 2).toInt
    }
    1


  }



  def QoneQtwo(arr: List[Int]): (Int, Int) = {
    val arr0 = arr.sorted
    val n = arr0.length
    val a1 = if (n % 2 == 1) arr0.filter(e => e < median(arr0)).sorted else arr0.filter(e => e < median(arr0)).sorted
    val q1 = median(a1)
    val a2 = if (n % 2 == 1) arr0.filter(e => e > median(arr0)).sorted else arr0.filter(e => e > median(arr0)).sorted
    val q2 = median(a2)
    (q1, q2)
  }

  def getThreeQ(arr: List[Int]): (List[Int], List[Int], List[Int]) = {
    val arr0 = arr.sorted
    (arr.filter(e => e < QoneQtwo(arr0)._1), arr.filter(e => e > QoneQtwo(arr0)._1 && e < QoneQtwo(arr0)._2), arr.filter(e => e > QoneQtwo(arr0)._2))
  }

  def main(args: Array[String]) {


    val n = scala.io.StdIn.readInt()
    val arr = scala.io.StdIn.readLine().split(" ").map(_.trim().toInt).toList.sorted
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your


    class should be named Solution
*/

    val q = QoneQtwo(arr)

    println(q._1)
    println(median(arr))
    println(q._2)
  }

}
