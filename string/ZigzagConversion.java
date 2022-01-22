/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:
Input: s = "A", numRows = 1
Output: "A"

Constraints:
1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */
package string;

public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",4));
    }

    public static String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        int zigzagLimit = numRows>2 ? numRows-2 : 0;
        for (int i=0;i<numRows;i++) {
            int index =i;
            while(index < s.length()) {
                result.append(s.charAt(index));
                index = index + numRows + zigzagLimit;
                if (zigzagLimit > 0 && i > 0 && i+1 != numRows && index - (i * 2) < s.length())
                    result.append(s.charAt(index - (i *2)));
            }
        }
        return result.toString();
    }
}
