/*
Given a string s, return the longest palindromic substring in s.

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
 */
package string;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));

    }

    public static String longestPalindrome(String s) {

        int start=0, end=0, evenLen, oddLen, maxLength;
        for (int i=1;i<s.length();i++) {
            evenLen = palindromeCheck(s, i-1, i);
            oddLen = palindromeCheck(s, i-1, i+1);
            maxLength = Math.max(evenLen, oddLen);
            if (maxLength > end - start){
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }
        return s.substring(start, end+1);
    }

    public static int palindromeCheck(String s, int low, int high) {

        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }
        return high - low - 1;
    }
}
