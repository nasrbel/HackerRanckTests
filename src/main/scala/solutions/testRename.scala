package solutions

import scala.io._



object testRename{

  /*
   * Complete the 'renameFile' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. STRING newName
   *  2. STRING oldName
   */

  def sub(string: String, substring: String): Boolean= { // Keep track of our position in the string.
    var index = 0
    // Iterate through all of the characters in the substring.
    for (character <- substring.toCharArray) { // Find the current character starting from the last character we stopped on.
      index = string.indexOf(character, index)
      // If the method returned -1, the character was not found, so the result is false.
      if (index == -1){
        return false
      }
    }
    // If we reach this point, that means all characters were found, so the result is true.
    true
  }

  def renameFile(newName: String, oldName: String): Int = {
      if(oldName.isEmpty){
        return 0
      }else if(sub(oldName, newName)) {
        return 1 + renameFile(newName, oldName)

      }
    0


  }



  def main(args: Array[String]) {


    val newName = StdIn.readLine

    val oldName = StdIn.readLine

    val result = renameFile(oldName, newName)

    println(result)


  }
}

