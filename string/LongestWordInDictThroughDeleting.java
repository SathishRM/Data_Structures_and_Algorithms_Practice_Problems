/*
Given a string and a string dictionary, find the longest string in the dictionary
that can be formed by deleting some characters of the given string. If there are more than one possible results,
return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]
Output:
"apple"

Input:
s = "abpcplea", d = ["a","b","c"]
Output:
"a"
 */
package string;

import java.util.ArrayList;
import java.util.List;

public class LongestWordInDictThroughDeleting {
    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea", new ArrayList<String>(){
            {add("ale");
            add("apple");
            add("monkey");
            add("plea");}}));
    }

    public static String findLongestWord(String s, List<String> d) {
        StringBuilder result = new StringBuilder();
        for (String word: d) {
            if (result.length() <= word.length() && subSequence(s,word)) {
                if (result.length() < word.length() || (result.length() == word.length() && word.compareTo(result.toString()) < 0)) {
                    result.setLength(0);
                    result.append(word);
                }

            }
        }
        return result.toString();
    }

    public static boolean subSequence(String s, String word) {

        if (s.length() < word.length()) return false;
        int i=0, j=0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == word.length();

    }
}
