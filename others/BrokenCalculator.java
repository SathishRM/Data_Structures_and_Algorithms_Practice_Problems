/*
On a broken calculator that has a number showing on its display, we can perform two operations:

Double: Multiply the number on the display by 2, or;
Decrement: Subtract 1 from the number on the display.
Initially, the calculator is displaying the number X.

Return the minimum number of operations needed to display the number Y.

Input: X = 2, Y = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.

Input: X = 3, Y = 10
Output: 3
Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.
 */
package others;

public class BrokenCalculator {
    public static void main(String[] args) {
        System.out.println(brokenCalc(3, 10));
    }

    public static int brokenCalc(int X, int Y) {
        int count = 0;
        while (X < Y) {
            count++;
            if(Y%2 == 0) Y /=2;
            else Y++;
        }
        return count + (X-Y);
    }
}
