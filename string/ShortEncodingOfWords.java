/*
A valid encoding of an array of words is any reference string s and array of indices indices such that:

words.length == indices.length
The reference string s ends with the '#' character.
For each index indices[i], the substring of s starting from indices[i] and
up to (but not including) the next '#' character is equal to words[i].
Given an array of words, return the length of the shortest reference string s
possible of any valid encoding of words.

Constraints:
1 <= words.length <= 2000
1 <= words[i].length <= 7
words[i] consists of only lowercase letters.

Input: words = ["time", "me", "bell"]
Output: 10
Explanation: A valid encoding would be s = "time#bell#" and indices = [0, 2, 5].
words[0] = "time", the substring of s starting from indices[0] = 0 to the next '#' is underlined in "time#bell#"
words[1] = "me", the substring of s starting from indices[1] = 2 to the next '#' is underlined in "time#bell#"
words[2] = "bell", the substring of s starting from indices[2] = 5 to the next '#' is underlined in "time#bell#"
 */
package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortEncodingOfWords {
    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"time","ll","bell","me"}));
    }

    public static int minimumLengthEncoding(String[] words) {
        Set<String> res = new HashSet<>(Arrays.asList(words));

        for (String word: words) {
            for (int i=1;i<word.length();i++) {
                res.remove(word.substring(i));
            }
        }
        int len=0;
        for (String word: res)
            len += word.length()+1;

        return len;
    }
}
