/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above
 

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]
 
Constraints:
1 <= numRows <= 30

*/
import scala.annotation.tailrec

object PascalTriangle {

  def main(args: Array[String]): Unit = {
    println(generate(5))
  }
  
  def generate(numRows: Int): List[List[Int]] = {
    @tailrec
    def genHelper(curIdx: Int, result: List[List[Int]]): List[List[Int]] = {
      if (curIdx < numRows) {
        val lastRow: List[Int] = result.last
        val curRow: List[Int] = if (curIdx >= 2) lastRow.head +: lastRow.sliding(2).map(_.sum).toList :+ lastRow.last  else lastRow.head +: lastRow
        genHelper(curIdx+1, result :+ curRow)
      }
      else {
        result
      }

    }
    genHelper(1,List(List(1)))
  }

}