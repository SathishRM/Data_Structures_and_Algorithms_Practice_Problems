/*
You are given an integer n. We reorder the digits in any order (including the original order)
such that the leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.

Constraints:
1 <= n <= 10^9

Example 1:
Input: n = 1
Output: true

Example 2:
Input: n = 10
Output: false

Example 3:
Input: n = 16
Output: true

Example 4:
Input: n = 24
Output: false

Example 5:
Input: n = 46
Output: true
 */
package others;

import java.util.Arrays;

public class ReorderedPowerOf2 {

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(46));
    }

    public static boolean reorderedPowerOf2(int N) {
        int[] countN = countDigits(N);

        int num=1;
        for (int i=0;i<31;i++) {
            // System.out.println((int)Math.pow(2,i));
            if (Arrays.equals(countDigits(num), countN)) {
                return true;
            }
            num <<= 1;
        }
        return false;
    }

    public static int[] countDigits(int n) {
        int result[] = new int[10];
        while (n > 0) {
            result[n%10]++;
            n /= 10;
        }
        return result;
    }
}
