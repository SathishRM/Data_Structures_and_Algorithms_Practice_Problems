/*
Write a function that takes an unsigned integer and returns the number of '1' bits
it has (also known as the Hamming weight).

Note:
Note that in some languages such as Java, there is no unsigned integer type.
In this case, the input will be given as a signed integer type.
It should not affect your implementation, as the integer's internal binary representation is the same,
whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation.
Therefore, in Example 3 above, the input represents the signed integer. -3.
Follow up: If this function is called many times, how would you optimize it?

Input: n = 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 */
package bitwiseoperation;

public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }

    public static int hammingWeight(int n) {
        int result = 0;

        while (n != 0) {
            result++;
            n &= (n - 1);
        }
        return result;
    }
}
