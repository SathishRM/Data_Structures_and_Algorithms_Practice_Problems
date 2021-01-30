/*
You are given a string allowed consisting of distinct characters and an array of strings words.
A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.

Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
 */
package string;

public class CountNoOfConsistentStrings {
    public static void main(String[] args) {
        System.out.println(countConsistentStrings("abc", new String[]{"a","b","c","ab","ac","bc","abc"}));

    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        boolean flag;
        for (String word : words) {
            flag = true;
            for (Character c : word.toCharArray()) {
                if (allowed.indexOf(c) == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        return count;
    }
}
