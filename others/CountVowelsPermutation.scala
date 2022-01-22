/*
Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

Example 1:
Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".

Example 2:
Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".

Example 3:
Input: n = 5
Output: 68

Constraints:
1 <= n <= 2 * 10^4
 */
package others

object CountVowelsPermutation extends App {

  println(countVowelPermutation(1000))

  def countVowelPermutation(n: Int): Int = {
    val dp = Array.ofDim[Long](n,5)
	val mod = 1000000007

    def countVowelPermutationHelper(i: Int): Int = {
      if (i >= n) {
        (dp(i-1).sum % mod).toInt
//        (dp(i-1)(0) % 1000000007 + dp(i-1)(1)  % 1000000007 + dp(i-1)(2) % 1000000007
//        + dp(i-1)(3) % 1000000007 + dp(i-1)(4) % 1000000007) % 1000000007
      }
      else if (i == 0) {
        dp(i)(0) = 1
        dp(i)(1) = 1
        dp(i)(2) = 1
        dp(i)(3) = 1
        dp(i)(4) = 1
        countVowelPermutationHelper(i+1)
      }
      else {
        dp(i)(0) = dp(i-1)(1)
        dp(i)(1) = (dp(i-1)(0) + dp(i-1)(2)) % mod
        dp(i)(2) = (dp(i-1)(0) + dp(i-1)(1) + dp(i-1)(3) + dp(i-1)(4)) % mod
        dp(i)(3) = (dp(i-1)(2) + dp(i-1)(4)) % mod
        dp(i)(4) = dp(i-1)(0)
        countVowelPermutationHelper(i+1)
      }
    }
    countVowelPermutationHelper(0)
  }

}
