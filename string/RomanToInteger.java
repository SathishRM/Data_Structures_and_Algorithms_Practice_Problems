/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII,
hwhich is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right.
However, the numeral for four is not IIII. Instead, the number four is written as IV.
Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX.
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:
Input: s = "III"
Output: 3

Example 2:
Input: s = "IV"
Output: 4
 */
package string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("XC"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanInt = new HashMap<>();
        romanInt.put('I', 1);
        romanInt.put('V', 5);
        romanInt.put('X', 10);
        romanInt.put('L', 50);
        romanInt.put('C', 100);
        romanInt.put('D', 500);
        romanInt.put('M', 1000);
        int idx = s.length()-1, result = 0;
        while (idx >= 0) {
            result += romanInt.get(s.charAt(idx));
            if (idx > 0 && romanInt.get(s.charAt(idx)) > romanInt.get(s.charAt(idx-1))) {
                idx--;
                result -= romanInt.get(s.charAt(idx));
            }

            // if (idx > 0 && s.charAt(idx) == 'V' && s.charAt(idx-1) == 'I') {
            //     result-=1;
            //     idx--;
            // }
            // else if (idx > 0 && s.charAt(idx) == 'X' && s.charAt(idx-1) == 'I') {
            //     result -= 1;
            //     idx--;
            // }
            // else if (idx > 0 && s.charAt(idx) == 'L' && s.charAt(idx-1) == 'X') {
            //     result -= 10;
            //     idx--;
            // }
            // else if (idx > 0 && s.charAt(idx) == 'C' && s.charAt(idx-1) == 'X') {
            //     result -= 10;
            //     idx--;
            // }
            // else if (idx > 0 && s.charAt(idx) == 'D' && s.charAt(idx-1) == 'C') {
            //     result -= 100;
            //     idx--;
            // }
            // else if (idx > 0 && s.charAt(idx) == 'M' && s.charAt(idx-1) == 'C') {
            //     result -= 100;
            //     idx--;
            // }
            idx--;
        }
        return result;
    }
}
