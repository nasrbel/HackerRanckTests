//package solutions
//
//object TheTreeOfLife {
//
//
//  sealed trait Tree[+A]
//
//
//  case class Leaf[A](var value: A) extends Tree[A] {
//    this.value = value
//    def set(newValue: A): Unit = this.value =newValue
//    def get(): A = this.value
//  }
//
//  case class Branch[A](var root: A, var left: Tree[A], var right: Tree[A]) extends Tree[A]{
//    this.left = left
//    this.right = right
//    this.root = root
//    def setRoot(newValue: A): Unit = this.root =newValue
//    def setLeft(newValue: Tree[A]): Unit = this.left =newValue
//    def setRight(newValue: Tree[A]): Unit = this.right =newValue
//    def getRoot: A = this.root
//    def getLeft:Branch[A] = this.left.asInstanceOf[Branch[A]]
//    def getRight: Tree[A] = this.right.asInstanceOf[Branch[A]]
//  }
//
//  val expression = "((.X(...)).(X.(.XX)))".replace('X','1').replace('.','0')
//
//  def evaluate(expression: List[String]) : Tree[String] = expression match {
//    case  "("::left::")"::r::"("::right =>  Branch(r,evaluate(left.toList.map(_.toString)),evaluate(right.dropRight(1).map(_.toString)))
//    case "(" ::r ::")":: Nil => Leaf(r)
//
//  }
//
//
//  def fillTree(inputString: List[String]): Branch[Int] = {
//
//
//    val leftBranch = Branch(inputString(3).toInt,Leaf(inputString(2).toInt),Branch(inputString(6).toInt,Leaf(inputString(5).toInt),Leaf(inputString(7).toInt)))
//    val rightBranch = Branch(inputString(13).toInt,Leaf(inputString(12).toInt),Branch(inputString(16).toInt,Leaf(inputString(15).toInt),Leaf(inputString(17).toInt)))
//    Branch(inputString(10).toInt,leftBranch,rightBranch)
//  }
//
//
//  class Node(var data: Int) {
//
//    var left: Node = null
//    var right: Node = null
//  }
//
//  def insert(root: Node, data: Int): Node = if (root == null) new Node(data)
//  else {
//    var cur = null
//    if (data <= root.data) {
//      cur = insert(root.left, data)
//      root.left = cur
//    }
//    else {
//      cur = insert(root.right, data)
//      root.right = cur
//    }
//    root
//  }
//
//
//
//
//
//
//  def main(args: Array[String]): Unit = {
//
//    val str = "((.X(...)).(X.(.XX)))".replace('X','1').replace('.','0').map(_.toString).toList
//    // . (X . (. X X))
//   println(fillTree(str).getLeft.getLeft.getRight )
//
//
//
//
//
//
//
//  }
//
//}
