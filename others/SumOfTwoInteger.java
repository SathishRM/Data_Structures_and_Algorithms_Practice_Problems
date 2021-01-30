/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
Input: a = -2, b = 3
Output: 1
 */
package bitwiseoperation;

public class SumOfTwoInteger {
    public static void main(String[] args) {
        System.out.println(getSum(2,-3));
    }

    public static int getSum(int a, int b) {
        while (b!=0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
