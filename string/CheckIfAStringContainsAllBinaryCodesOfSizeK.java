/*
Given a binary string s and an integer k.

Return true if every binary code of length k is a substring of s. Otherwise, return false.

Constraints:
1 <= s.length <= 5 * 105
s[i] is either '0' or '1'.
1 <= k <= 20

Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11".
They can be all found as substrings at indicies 0, 1, 3 and 2 respectively.

Input: s = "0110", k = 1
Output: true
Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.

Input: s = "0110", k = 2
Output: false
Explanation: The binary code "00" is of length 2 and doesn't exist in the array.
 */

package string;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public static void main(String[] args) {
        System.out.println(hasAllCodes("00110110",2));
    }

    public static boolean hasAllCodes(String s, int k) {
        int[] result = new int[(int)Math.pow(2,k)];

        for (int i=0;i<=s.length()-k;i++) {
            result[Integer.parseInt(s.substring(i,i+k),2)] += 1;
        }
        for (int i=0;i<result.length;i++) {
            if (result[i] == 0) return false;
        }
        return true;
    }
}
