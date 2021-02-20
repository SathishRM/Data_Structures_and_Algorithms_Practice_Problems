/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 */
package string;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid(")ah(cb(gh)ik)t"));
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        int openBrackets = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openBrackets++;
                result.append(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (openBrackets > 0) {
                    openBrackets--;
                    result.append(s.charAt(i));
                }
            } else {
                result.append(s.charAt(i));
            }
        }
        int i = result.length() - 1;
        while (openBrackets > 0 && i >= 0) {
            if (result.charAt(i) == '(') {
                openBrackets--;
                result.deleteCharAt(i);
            }
            i--;
        }
        return result.toString();
    }
}
