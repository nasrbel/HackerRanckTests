package certificationsHacker

object test_iam extends App {
  val l = (1 until 5).toList.permutations.toList
 println("%%%%%%%%%%%%first appr %%%%%%%%%%%%%%%%")
  l.foreach(println)


  def interleave(x:Int, l:List[Int]):List[List[Int]] = {
    l match {
      case Nil => List(List(x))
      case (head::tail) =>
        (x :: head :: tail) :: interleave(x, tail).map(head :: _)
    }
  }

  def permutations(l:List[Int]):List[List[Int]] = {
    l match {
      case Nil => List(List())
      case (head::tail) =>
        for(p0 <- permutations(tail); p1 <- interleave(head, p0)) yield p1
    }
  }

  println("%%%%%%%%%%%%%%%%%%%%%%%%%% second appr %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
  permutations((1 until 50).toList).foreach(println)

}
