/*
Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.
For a given query word, the spell checker handles two categories of spelling mistakes:

Capitalization: If the query matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the case in the wordlist.
    Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
    Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
    Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel individually, it matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the match in the wordlist.
    Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
    Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
    Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)

In addition, the spell checker operates under the following precedence rules:
    When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
    When the query matches a word up to capitlization, you should return the first such match in the wordlist.
    When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
    If the query has no matches in the wordlist, you should return the empty string.

Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].

Constraints:
1 <= wordlist.length, queries.length <= 5000
1 <= wordlist[i].length, queries[i].length <= 7
wordlist[i] and queries[i] consist only of only English letters.

Example 1:
Input: wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]

Example 2:
Input: wordlist = ["yellow"], queries = ["YellOw"]
Output: ["yellow"]
 */
package string;

import java.util.*;

public class VowelSpellchecker {
    public static void main(String[] args) {
        String[] result = spellchecker(new String[]{"KiTe","kite","hare","Hare"},
                new String[]{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"});
        System.out.println(Arrays.toString(result));
    }

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        String[] result = new String[queries.length];
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelSubs = new HashMap<>();

        for (String word: wordlist) {
            exactWords.add(word);
            if (!caseInsensitive.containsKey(word.toLowerCase())) {
                caseInsensitive.put(word.toLowerCase(), word);
            }
            String vowelReplaced = vowelSubStar(word);
            if (!vowelSubs.containsKey(vowelReplaced)) {
                vowelSubs.put(vowelReplaced, word);
            }
        }

        // System.out.println(exactWords.toString());
        // System.out.println(caseInsensitive.toString());
        // System.out.println(vowelSubs.toString());

        for (int i=0;i<queries.length;i++) {
            String vowelReplaced = vowelSubStar(queries[i]);
            if (exactWords.contains(queries[i])) {
                result[i] = queries[i];
            }
            else if (caseInsensitive.containsKey(queries[i].toLowerCase())) {
                result[i] = caseInsensitive.get(queries[i].toLowerCase());
            }
            else if (vowelSubs.containsKey(vowelReplaced)) {
                result[i] = vowelSubs.get(vowelReplaced);
            }
            else {
                result[i] ="";
            }
        }
        return result;
    }

    public static String vowelSubStar(String word) {
        StringBuilder result = new StringBuilder();

        for (char c: word.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                result.append('*');
            }
            else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
