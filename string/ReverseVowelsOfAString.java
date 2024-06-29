/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:
Input: s = "hello"
Output: "holle"

Example 2:
Input: s = "leetcode"
Output: "leotcede"


Constraints:
1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */
package string;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));

    }

    public static String reverseVowels(String s) {
        int l = 0, r = s.length()-1;
        char[] result = s.toCharArray();
        Set<Character> vowels = new HashSet<>();
        for (Character c: "aeiou".toCharArray())
            vowels.add(c);

        while (l < r) {
            if(vowels.contains(Character.toLowerCase(s.charAt(l)))
                    && vowels.contains(Character.toLowerCase(s.charAt(r))) ) {
                char t = result[l];
                result[l] =  result[r];
                result[r] = t;
                l++;
                r--;
            }
            else if(!vowels.contains(Character.toLowerCase(s.charAt(l)))) l++;
            else if(!vowels.contains(Character.toLowerCase(s.charAt(r)))) r--;
        }
        return String.valueOf(result);

    }
}
