/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create. You can return the output in any order.

Input: S = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

Input: S = "12345"
Output: ["12345"]
 */
package string;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        List<String> result = letterCasePermutation("a1b2");
        System.out.println(result.toString());

    }

    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        permutationHelper(S.toCharArray(), 0, result);
        return result;
    }

    public static void permutationHelper(char[] str, int pos, List<String> result) {

        if (pos == str.length) {
            result.add(String.valueOf(str));
            return;
        }

        if (str[pos] >= '0' && str[pos] <= '9') {
            permutationHelper(str, pos+1, result);
            return;
        }

        str[pos] = Character.toLowerCase(str[pos]);
        permutationHelper(str, pos+1, result);

        str[pos] = Character.toUpperCase(str[pos]);
        permutationHelper(str, pos+1, result);
    }
}
