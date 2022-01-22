/*
Given a string containing digits from 2-9 inclusive,
return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]

Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9']
 */
package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("479").toString());
    }

    public static List<String> letterCombinations(String digits) {
        Map<String, String> numAlpaMapping = new HashMap<>();
        numAlpaMapping.put("2","abc");
        numAlpaMapping.put("3","def");
        numAlpaMapping.put("4","ghi");
        numAlpaMapping.put("5","jkl");
        numAlpaMapping.put("6","mno");
        numAlpaMapping.put("7","pqrs");
        numAlpaMapping.put("8","tuv");
        numAlpaMapping.put("9","wxyz");

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) return result;
        result.add("");
        for (String num: digits.split("")) {
            result = letterPermutation(result, numAlpaMapping.get(num));
        }
        return result;
    }

    public static List<String> letterPermutation(List<String> result, String val) {
        List<String> updatedResult = new ArrayList<>();
        for (String oldValue: result) {
            for (String s: val.split("")) {
                updatedResult.add(oldValue+s);
            }
        }
        return updatedResult;
    }
}
