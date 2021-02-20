/*
Given a non-negative integer num, return the number of steps to reduce it to zero.
If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.

Input: num = 14
Output: 6
Explanation:
Step 1) 14 is even; divide by 2 and obtain 7.
Step 2) 7 is odd; subtract 1 and obtain 6.
Step 3) 6 is even; divide by 2 and obtain 3.
Step 4) 3 is odd; subtract 1 and obtain 2.
Step 5) 2 is even; divide by 2 and obtain 1.
Step 6) 1 is odd; subtract 1 and obtain 0.
 */
package bitwiseoperation;

public class NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(50));

    }

    public static int numberOfSteps (int num) {
        int result=0;
        while (num > 0) {
            result++;
            if (num % 2 == 0) num >>= 1; // num /= 2;
            else num &= ~(1<<0); // num -= 1;
        }
        return result;
    }
}
