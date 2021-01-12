package others;

/*
Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.

He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before.
On every subsequent Monday, he will put in $1 more than the previous Monday.
Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.

Input: n = 10
Output: 37
Explanation: After the 10th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37. Notice that on the 2nd Monday, Hercy only puts in $2.
 */

import java.util.stream.IntStream;

public class CalculateMoney {
    public static void main(String[] args) {

        System.out.println(totalMoney(20));
    }

    public static int totalMoney(int n) {
        return IntStream.rangeClosed(1,n)
                .map(m -> {
                    int remainder = m % 7;
                    if (remainder == 0) return (m / 7) + 6;
                    return (m / 7) + remainder;})
                .sum();
    }
}
