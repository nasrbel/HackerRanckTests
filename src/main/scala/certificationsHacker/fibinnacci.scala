package certificationsHacker

object fibinnacci extends  App {

  def fib1( n : Int) : Int = n match {
    case 0 | 1 => n
    case _ => fib1( n-1 ) + fib1( n-2 )
  }
  println(fib1(10))

}
