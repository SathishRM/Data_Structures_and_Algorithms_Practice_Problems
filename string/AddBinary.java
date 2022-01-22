/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"

Constraints:
1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
 */
package string;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("100","110010"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int len = Math.min(a.length(),b.length());

        int carryOver = 0;
        for (int i=1;i<=len;i++) {
            if(a.charAt(a.length()-i) == '1'  && b.charAt(b.length()-i) == '1') {
                if (carryOver == 1) {
                    result.append('1');
                    carryOver = 1;
                }
                else {
                    result.append('0');
                    carryOver=1;
                }
            }
            else if ( (a.charAt(a.length()-i) == '0'  && b.charAt(b.length()-i) == '1') ||
                    (a.charAt(a.length()-i) == '1'  && b.charAt(b.length()-i) == '0')) {
                if (carryOver == 1) {
                    result.append('0');
                    carryOver = 1;
                }
                else {
                    result.append('1');
                    carryOver=0;
                }
            }
            else if (a.charAt(a.length()-i) == '0'  && b.charAt(b.length()-i) == '0') {
                if (carryOver == 1) {
                    result.append('1');
                    carryOver = 0;
                }
                else {
                    result.append('0');
                    carryOver=0;
                }
            }
        }
        if (a.length() != b.length()) {
            int maxLen = Math.max(a.length(), b.length());
            String remainStr = a.length() > b.length() ? a : b ;
            System.out.println(remainStr);

            System.out.println(len);
            System.out.println(maxLen);
            for (int i=len+1; i<=maxLen;i++ ){
                System.out.println(remainStr.charAt(maxLen-i));
                if (remainStr.charAt(maxLen-i) =='1') {
                    if (carryOver == 1) {
                        result.append('0');
                        carryOver=1;
                    }
                    else {
                        result.append('1');
                        carryOver=0;
                    }
                }
                else {
                    if (carryOver == 1) {
                        result.append('1');
                        carryOver = '0';
                    } else {
                        result.append('0');
                        carryOver = 0;
                    }
                }
            }
        }
        if (carryOver ==1) result.append('1');

        return result.reverse().toString();
    }
}
