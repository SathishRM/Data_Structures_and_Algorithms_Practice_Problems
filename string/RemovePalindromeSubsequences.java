/*
Given a string s consisting only of letters 'a' and 'b'.
In a single step you can remove one palindromic subsequence from s.

Return the minimum number of steps to make the given string empty.

A string is a subsequence of a given string,
if it is generated by deleting some characters of a given string without changing its order.

A string is called palindrome if is one that reads the same backward as well as forward.

Input: s = "ababa"
Output: 1
Explanation: String is already palindrome

Input: s = "abb"
Output: 2
Explanation: "abb" -> "bb" -> "".
Remove palindromic subsequence "a" then "bb".
 */
package string;

public class RemovePalindromeSubsequences {

    public static void main(String[] args) {
        System.out.println(removePalindromeSub("abababb"));
    }
    public static int removePalindromeSub(String s) {
        if (s.length() == 0) return 0;

        else if (isPalindrome(s)) return 1;
        return 2;
    }

    public static boolean isPalindrome(String s) {
        int l =0, r=s.length()-1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
