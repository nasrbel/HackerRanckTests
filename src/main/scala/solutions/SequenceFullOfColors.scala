package solutions

object SequenceFullOfColors {
  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readInt()
    (1 to n).foreach { k => {
      if (isItFullOfColors(scala.io.StdIn.readLine().split("\\s+")(0).toList, (0, 0, 0, 0))) {
        println("True")
      } else {
        println("False")
      }
    }


    }
  }







    def isItFullOfColors(inputString: List[Char], colorCount: (Int, Int, Int, Int)): Boolean = {

      //foreach element substring verifies the conditions until having length = 1

      var colorCount0 = colorCount

      if (inputString.isEmpty) {
        if ((colorCount0._1 == colorCount0._2) && (colorCount0._3 == colorCount0._4)) {
          return true
        }else{
          return false
        }
      } else {
        //R ---> G ----> Y ----> B
        if ((colorCount0._1 - colorCount0._2).abs > 1 || (colorCount0._3 - colorCount0._4).abs > 1) {
          return false
        } else {

          if (inputString.head == 'R') {
            return isItFullOfColors(inputString.tail, colorCount0.copy(_1 = colorCount0._1 + 1))
          } else if (inputString.head == 'G') {
            return isItFullOfColors(inputString.tail, colorCount0.copy(_2 = colorCount0._2 + 1))
          } else if (inputString.head == 'Y') {
            return isItFullOfColors(inputString.tail, colorCount0.copy(_3 = colorCount0._3 + 1))
          } else if (inputString.head == 'B') {
            return isItFullOfColors(inputString.tail, colorCount0.copy(_4 = colorCount0._4 + 1))

          }

          //There are as many red balls as green balls.
          //var cond1 = inputString.filter(_.equals('G')).length == inputString.filter(_.equals('R')).length
          //There are as many yellow balls as blue balls.


        }


      }
      true
    }

}
