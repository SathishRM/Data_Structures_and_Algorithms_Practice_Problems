/*
We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.
For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a.

Return a list of all universal words in A.  You can return the words in any order.


Note:
1 <= A.length, B.length <= 10000
1 <= A[i].length, B[i].length <= 10
A[i] and B[i] consist only of lowercase letters.
All words in A[i] are unique: there isn't i != j with A[i] == A[j].

Example 1:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]

Example 2:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]

Example 3:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
Output: ["facebook","google"]

Example 4:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
Output: ["google","leetcode"]

Example 5:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
Output: ["facebook","leetcode"]
 */
package string;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public static void main(String[] args) {
        List<String> result = wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},
                new String[]{"lo","eo"});
        System.out.println(result.toString());
    }

    public static List<String> wordSubsets(String[] A, String[] B) {
        int[] countB = new int[26];
        List<String> result = new ArrayList<>();

        for (String word: B) {
            int[] temp = new int[26];
            for (char c: word.toCharArray()) {
                temp[c-'a']++;
            }
            for (int i=0;i<countB.length;i++) {
                if (temp[i] > countB[i]) countB[i] = temp[i];
            }
        }

        for (int i=0;i<A.length;i++) {
            int[] countA = new int[26];
            for (char c: A[i].toCharArray()) {
                countA[c-'a']++;
            }

            boolean flag=true;
            for (int j=0;j<countB.length;j++) {
                if (countA[j] < countB[j]) {
                    flag=false;
                    break;
                }
            }
            if (flag) result.add(A[i]);
        }

        return result;
    }
}
