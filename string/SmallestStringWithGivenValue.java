/*
The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet,
so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.

The numeric value of a string consisting of lowercase characters is defined as the sum of its characters'
numeric values. For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.

You are given two integers n and k. Return the lexicographically smallest string with length equal to n and
numeric value equal to k.

Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order,
that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i]
comes before y[i] in alphabetic order.

Input: n = 3, k = 27
Output: "aay"
Explanation: The numeric value of the string is 1 + 1 + 25 = 27, and
it is the smallest string with such a value and length equal to 3.
 */
package string;

public class SmallestStringWithGivenValue {
    public static void main(String[] args) {
        System.out.println(getSmallestString(5,73));
    }

    //String builder - less space with cost of performance
    //char[] - good performance with the cost of space
    public static String getSmallestString(int n, int k) {
        int i = n;
        int accSum =0;
        //StringBuilder result = new StringBuilder();
        char[] result = new char[n];
        while (i > 0) {
            int balValue = k - accSum -i + 1;
            if (balValue > 26) {
                // result.append('z');
                result[i-1] ='z';
                accSum += 26;
            }
            else {
                // result.append((char) (balValue+96));
                result[i-1] = (char) (balValue+96);
                accSum += balValue;
            }
            i--;
        }
        //return result.reverse().toString();
        return String.valueOf(result);
    }
}
