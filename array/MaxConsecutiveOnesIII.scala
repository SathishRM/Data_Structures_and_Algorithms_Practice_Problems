/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
 */
 
package array

object MaxConsecutiveOnesIII extends App {

  println(longestOnes(Array(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1),3))
  def longestOnes(nums: Array[Int], k: Int): Int = {

    def longestOneHelper(i: Int, startIdx: Int, noZeroes: Int, result: Int, maxResult: Int): Int = {
//      println(i,nums.length)
      if (i == nums.length) result.max(maxResult)
      else {
        if (nums(i) == 1) longestOneHelper(i + 1, startIdx, noZeroes, result + 1, maxResult)
        else {
          if (noZeroes < k) longestOneHelper(i + 1, startIdx, noZeroes + 1, result + 1, maxResult)
          else {
            if (nums(startIdx) == 0) longestOneHelper(i + 1, startIdx + 1, noZeroes, result, result.max(maxResult))
            else {
              val newStartIdx = findZeroIndex(startIdx)
              longestOneHelper(i + 1, newStartIdx, noZeroes, i - newStartIdx + 1,  result.max(maxResult))
            }
          }
        }
      }
    }

    def findZeroIndex(index: Int): Int = {
      if (nums(index) == 0) index+1
      else findZeroIndex(index+1)
    }

    longestOneHelper(0,0,0,0, 0)
  }

}
