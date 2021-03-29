/*
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s
 */
package string;

public class MergeStringAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab","xyz"));
    }
    public static String mergeAlternately(String word1, String word2) {
        int i=0, minLen = Math.min(word1.length(), word2.length());
        StringBuilder result = new StringBuilder();
        while (i < minLen) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
            i++;
        }
        if (word1.length() > minLen) result.append(word1.substring(i));
        if (word2.length() > minLen) result.append(word2.substring(i));
        return result.toString();
    }
}
