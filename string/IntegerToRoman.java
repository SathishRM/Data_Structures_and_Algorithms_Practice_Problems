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
For example, 2 is written as II in Roman numeral, just two one's added together.
12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right.
However, the numeral for four is not IIII. Instead, the number four is written as IV.
Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX.
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
package string;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(943));
    }

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] intValues = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanValues = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        // int count=0;

        for (int i=0;i<intValues.length;i++) {
            while (num >= intValues[i]) {
                num -= intValues[i];
                result.append(romanValues[i]);
            }
        }
        return result.toString();
//         while (num > 0) {
//             if (num >= 1000) {
//                 count = num / 1000;
//                 num = num % 1000;
//                 result.append(String.valueOf(intRomanMapping.get(1000)).repeat(count));
//             }
//             else if (num >= 900) {
//                 num = num % 900;
//                 result.append(intRomanMapping.get(100));
//                 result.append(intRomanMapping.get(1000));
//             }
//             else if (num >= 500) {
//                 num = num % 500;
//                 result.append(intRomanMapping.get(500));
//             }
//             else if (num >= 400) {
//                 num = num % 400;
//                 result.append(intRomanMapping.get(100));
//                 result.append(intRomanMapping.get(500));
//             }
//             else if (num >= 100) {
//                 count = num / 100;
//                 num = num % 100;
//                 result.append(String.valueOf(intRomanMapping.get(100)).repeat(count));
//             }
//             else if (num >= 90) {
//                 num %= 90;
//                 result.append(intRomanMapping.get(10));
//                 result.append(intRomanMapping.get(100));
//             }
//             else if (num >= 50) {
//                 num %= 50;
//                 result.append(intRomanMapping.get(50));
//             }
//             else if (num >= 40) {
//                 num %= 40;
//                 result.append(intRomanMapping.get(10));
//                 result.append(intRomanMapping.get(50));
//             }
//             else if (num >= 10) {
//                 count = num / 10;
//                 num %= 10;
//                 result.append(String.valueOf(intRomanMapping.get(10)).repeat(count));
//             }
//             else if (num == 9) {
//                 num = 0;
//                 result.append(intRomanMapping.get(1));
//                 result.append(intRomanMapping.get(10));
//             }
//             else if (num >= 5) {
//                 num %= 5;
//                 result.append(intRomanMapping.get(5));
//             }
//             else if (num == 4) {
//                 num = 0;
//                 result.append(intRomanMapping.get(1));
//                 result.append(intRomanMapping.get(5));
//             }
//             else if ( num >= 1) {
//                 result.append(String.valueOf(intRomanMapping.get(1)).repeat(num));
//                 num = 0;
//             }

//         }
    }
}
