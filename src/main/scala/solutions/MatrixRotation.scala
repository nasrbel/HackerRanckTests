package solutions

object MatrixRotation {

  /**
   * You are given a 2D matrix, a, of dimension MxN and a positive integer R.
   * You have to rotate the matrix R times and print the resultant matrix.
   * Rotation should be in anti-clockwise direction.
   *
   * Rotation of a 4x5 matrix is represented by the
   * following figure. Note that in one rotation, you have
   * to shift elements by one step only (refer sample tests for more clarity).
   *
   *
   */
  /**
   * How I will solve the problem, myb idea is :
   *
   *
   * divide the matrix into 4 objects :
   * Object 1 : H1: the direction is horizontal and the sense is from right to left (i,j) <- (i,j-1)
   * Object 2 : H2: the direction is horizontal and the sense is from left  to right  (i,j) (i,j+1)
   * Object 3 : V1: the direction is vertical and the sense is from down   to up    (i,j) <- (i-1,j)
   * Object 4 : V2: the direction is vertical and the sense is from up   to down  (i,j) <- (i+1,j)
   * H1: all lines with index i [0 to N/2]
   * H2: all lines with index i [N/2 + 1 to N]
   * V1: all cols with index j [M/2 + 1 to M]
   * V2: all cols with index j [0 to M/2]
   * I will take into considerations two points: 1) if N  or M is odd or even
   *                                             2) separate some index (i,j) that can be in both directions H and V
   */


  def getHOne(arr: List[(List[(Int, Int)], Int)],n : Int, m: Int) ={

    val pm: Int =  if(n >= m) n-m +1  else 0
    val p = (n-pm)/2

    val filtredarr = arr.filter(e => e._2 <= p)
     val reorderedArr =  filtredarr.map(e => if(e != filtredarr.head ) (e._1.slice(1,e._1.length-1),e._2) else e).map(e => e._1.map(el => (el._1,(e._2,el._2))))
    //println(reorderedArr)
    reorderedArr.map( ele => ele.map( v => if(v==ele.head) (v._1,(v._2._1+1,v._2._2)) else (v._1,(v._2._1,v._2._2-1))    ) )
  }

  def getHTwo(arr: List[(List[(Int, Int)], Int)],n : Int, m: Int) ={
   //if (n % 2 == 0) n/2 -1 else
   val pm: Int =  if(n >= m) n-m +1  else 0
    val p = (n-pm)/2
   // println(n,p)
    val filtredarr = arr.filter(e => e._2 >= n-1 -p)
   // println(filtredarr)
    val reorderedArr =  filtredarr.map(e => if(e != filtredarr.last ) (e._1.slice(1,e._1.length-1),e._2) else e).map(e => e._1.map(el => (el._1,(e._2,el._2))))
   // println(reorderedArr)
    reorderedArr.map( ele => ele.map( v => if(v==ele.last) (v._1,(v._2._1-1,v._2._2)) else (v._1,(v._2._1,v._2._2+1))    ) )
  }

  def getVOne(arr: List[(List[(Int, Int)], Int)],n : Int, m: Int) ={

    val p: Int =  if(m >= n) n-m +1  else 0
    val pm = (m-p)/2
    val filtredarr = arr.map(e => (e._1.filter(e => e._2 > m-1-pm),e._2)).map(e => e._1.map(el => (el._1,(e._2,el._2)))).dropRight(1)
    //map( e => if(e == filtredarr.head || e == filtredarr.tail.head || e == filtredarr.last) e.tail else  e)
    val doubleFiltredArr = filtredarr.tail
//    val reorderedArr =  filtredarr.map(e => if(e != filtredarr.head ) (e._1.slice(1,e._1.length-1),e._2) else e).map(e => e._1.map(el => (el._1,(e._2,el._2))))
   println(filtredarr)
 //   println(doubleFiltredArr)
   // filtredarr
    doubleFiltredArr.map( ele => ele.map( v => (v._1,(v._2._1-1,v._2._2))     ) )
  }

  def getVTwo(arr: List[(List[(Int, Int)], Int)],n : Int, m: Int) ={

    val p: Int =  if(m >= n) n-m +1  else 0
    val pm = (m-p)/2
    val filtredarr = arr.map(e => (e._1.filter(e => e._2 <= pm),e._2)).map(e => e._1.map(el => (el._1,(e._2,el._2)))).tail.dropRight(1)
    val doubleFiltredArr = filtredarr.map( e => if(e == filtredarr.head  || e == filtredarr.last ) e.dropRight(1) else  e)
    //    val reorderedArr =  filtredarr.map(e => if(e != filtredarr.head ) (e._1.slice(1,e._1.length-1),e._2) else e).map(e => e._1.map(el => (el._1,(e._2,el._2))))
   // println(filtredarr)

    doubleFiltredArr.map( ele => ele.map( v => (v._1,(v._2._1+1,v._2._2))     ) )
  }


  def rotateArray(inputArr : List[List[Int]], n : Int, m :Int,  r : Int): List[List[Int]] ={
   val inputArray = inputArr.zipWithIndex.map(e => (e._1.zipWithIndex,e._2))
    if(r==0){

      return inputArr
    }else{
      val h1 = getHOne(inputArray,n,m)
     // println(h1)
      val h2 =  getHTwo(inputArray,n,m)
     //println(h2)
      val v1 = getVOne(inputArray,n,m)
      println(v1)
      val v2 = getVTwo(inputArray,n,m)
     // println(v2)
      val outputArray = Array.ofDim[Int](n,m)
      h1.foreach(e => for (elem <- e) {
        outputArray(elem._2._1)(elem._2._2) = elem._1
      })
      h2.foreach(e => for (elem <- e) {
        outputArray(elem._2._1)(elem._2._2) = elem._1
      })
      v1.foreach(e => for (elem <- e) {
        outputArray(elem._2._1)(elem._2._2) = elem._1
      })
      v2.foreach(e => for (elem <- e) {
        outputArray(elem._2._1)(elem._2._2) = elem._1
      })
      return rotateArray(outputArray.map(_.toList).toList,n,m,r-1)
    }
    List(List(1))
  }

  def main(args: Array[String]): Unit = {



    val triplet: Array[Int] = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt)
    val n: Int = triplet(0)
    val m: Int = triplet(1)
    val r: Int = triplet(2)
    val arr: Array[Array[Int]] = Array.ofDim[Int](n, m)
    (0 until n).foreach(k => arr(k) = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt))
    val inputArr = arr.map(_.toList).toList
    //val inputArray: List[(List[(Int, Int)], Int)] = inputArr.zipWithIndex.map(e => (e._1.zipWithIndex,e._2))
    val outputArray = rotateArray(inputArr,n,m,r)

    val concatResults: (String, String) => String = (left, right) => {
      left + " " + right
    }
    outputArray.foreach(e => {
      var str = ""
      str = str + e.map(_.toString).reduce((x,y) => concatResults(x,y))
       println(str)

    })

  }




}
