/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Input: s = "()[]{}"
Output: true

Input: s = "([)]"
Output: false
 */
package string;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("((["));
    }

    public static boolean isValid(String s) {
       Deque<Character> openParentheses = new ArrayDeque<>();

        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(' || s.charAt(i) =='[' || s.charAt(i) == '{') {
                openParentheses.push(s.charAt(i));
                continue;
            }

            if (!openParentheses.isEmpty()) {
                if (s.charAt(i) == ')' && openParentheses.pop() != '(')
                    return false;
                else if (s.charAt(i) == ']' && openParentheses.pop() != '[')
                    return false;
                else if (s.charAt(i) == '}' && openParentheses.pop() != '{')
                    return false;
            }
            else {
                return false;
            }
        }
        Object[] remaining = openParentheses.toArray();
        for (Object o : remaining) {
            System.out.println(o);

        }
        return openParentheses.isEmpty() ? true : false;

    }
}
