/*
For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.



Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""


Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.
 */
package string;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABC","ABCABCABC"));

    }

    public static String gcdOfStrings(String str1, String str2) {
        int len = Math.min(str1.length(),str2.length());
        int i = 0;
        StringBuilder ss= new StringBuilder();
        String result ="";
        while(i<len) {
            if(str1.charAt(i) == str2.charAt(i)) {
                ss.append(str1.charAt(i));
                if(str1.split(ss.toString()).length == 0 &&
                        str2.split(ss.toString()).length == 0) {
                    result = ss.toString();
                }
            }
            else break;
            i++;
        }
        return result;
    }
}
