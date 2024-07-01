/*
1456. Maximum Number of Vowels in a Substring of Given Length
Given a string s and an integer k, return the maximum number of vowel letters
in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Example 2:
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

Example 3:
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.

Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters.
1 <= k <= s.length
 */
package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef",3));

    }

    public static int maxVowels(String s, int k) {
        int l = 0, r = k-1, i=0, result=Integer.MIN_VALUE, sum=0;
        Set<Character> vowels = new HashSet<>();
        for(char c: "aeiou".toCharArray()) {
            vowels.add(c);
        }
        while(i<k){
            if(vowels.contains(s.charAt(i))) sum++;
            i++;
        }
        result = Math.max(result,sum);
        while(r<s.length()-1) {
            if (result==k) return result;
            if(vowels.contains(s.charAt(l))) sum--;
            l++;
            r++;
            if(vowels.contains(s.charAt(r))) sum++;
            result = Math.max(result,sum);
        }
        return result;
    }
}
