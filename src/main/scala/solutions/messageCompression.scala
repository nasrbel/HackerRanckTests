package solutions

object messageCompression {



    def main(args: Array[String]) {


      def consecutiveOccu(a : String): String = {
        var occ = a

        var str = ""
        var i = 0
        while (i < occ.length){
          var j = i
          var occurence = 1
          while(j+1 < occ.length && occ(j+1)== occ(i)){
            occurence += 1
            j += 1
          }
          if(occurence <=1){
            str += occ(i).toString
          }else {
            str += occ(i).toString + occurence.toString
          }

          i += occurence
        }
       str
      }

      println(consecutiveOccu(scala.io.StdIn.readLine().trim))
    }
  }


