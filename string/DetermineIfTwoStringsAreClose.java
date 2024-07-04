/*
Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character,
and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

Example 1:
Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"

Example 2:
Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.

Example 3:
Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"

Constraints:
1 <= word1.length, word2.length <= 10^5
word1 and word2 contain only lowercase English letters.
 */
package string;

import java.util.*;

public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        System.out.println(closeStrings("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff"));
    }

    public static boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) return false;

        Map<Character,Integer> w1 = new HashMap<>();
        Map<Character,Integer> w2 = new HashMap<>();

        int v;

        for (char c: word1.toCharArray()) {
            v = w1.getOrDefault(c,0);
            w1.put(c,v+1);
        }

        for (char c: word2.toCharArray()) {
            v = w2.getOrDefault(c,0);
            w2.put(c,v+1);
        }
        if(w1.size() != w2.size()) return false;

        List<Integer> v1 = new ArrayList<>(w1.values());
        List<Integer> v2 = new ArrayList<>(w2.values());

        Collections.sort(v1);
        Collections.sort(v2);

        return w1.keySet().equals(w2.keySet()) && v1.equals(v2);

    }
}
