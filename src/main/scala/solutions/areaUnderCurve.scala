package solutions
object areaUnderCurve extends  App {
//
//  def f(num:Int,arr:List[Int]):List[Int] = {
//    var res = new ListBuffer[Int]()
//    arr.foreach(ele =>{
//      for(_ <- 1 to num){
//        res += ele
//      }
//    })
//     res.toList
//  }
//
//  val arr = new ListBuffer[Int]()
//  var a  = 0
//  var compt = 1
//  val input = scala.io.StdIn.readLine()
//  a = input.toInt
//  breakable {
//    while (true) {
//
//      // Reads the line from the Console
//      arr += scala.io.StdIn.readLine().toInt
//      compt += 1
//      if (compt > 10) {
//        break
//      }
//
//    }
//  }
//
//  f(a, arr.toList).foreach(println)
//
//
//
//
//
//
//
//  val n = scala.io.StdIn.readInt()
//  var arr = Array.fill(20)((scala.util.Random.nextInt(256)))
//  def f0(delim:Int,arr:List[Int]):List[Int] = {
//    var l = ListBuffer[Int]()
//    arr.zipWithIndex.filter(ele => ele._2 % 2 ==0).map(el => l += el._1 )
//    l.toList
//
//  }
//  val n = scala.io.StdIn.readInt()



//  def f(n:Int):Array[Int] ={
//    Array.fill(n)(scala.util.Random.nextInt)
//  }
//  val n = scala.io.StdIn.readInt()
//  var str = "["
//  f(n).foreach( ele => str +=  ele.toString()+ ", ")
//  str = str.dropRight(2)
//  str += "]"
//  println(str)

  // This function will be used while invoking "Summation" to compute
  // The area under the curve.
  def f(coefficients:List[Int],powers:List[Int], x:Double):Double =
    coefficients.zip(powers)
      .foldLeft(0.0){case (acc,(c,p))=> acc + c * math.pow(x,p)}

  def area(coefficients:List[Int],powers:List[Int],x:Double):Double =
    math.Pi * math.pow(f(coefficients,powers,x),2)

  def summation(func:(List[Int],List[Int],Double)=>Double,
                upperLimit:Int,
                lowerLimit:Int,
                coefficients:List[Int],
                powers:List[Int]):Double =
  {
    val step = 0.001
    var i = 0
    val nb = ((upperLimit-lowerLimit)/step).toInt
    val subIntervals= List.tabulate(nb)(_ => {
      i += 1
      lowerLimit +i*step
    })
      //lowerLimit.toDouble to upperLimit by step
     subIntervals.foldLeft(0.0){case (acc,x)=> acc + func(coefficients,powers,x)*step}

  }
  def readLine() = {
    scala.io.StdIn.readLine
  }


  // The Input-Output functions will be handled by us. You only need to concentrate your effort on the function bodies above.
val coefficients = List(1, 2, 3, 4, 5)
  val powers = List(6, 7 ,8 ,9 ,10)
  val upperLimit = 4
  val lowerLimit =  1

println(summation(f,upperLimit,lowerLimit,coefficients,powers))

}
