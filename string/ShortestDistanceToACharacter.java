/*
Given a string s and a character c that occurs in s, return an array of integers answer
where answer.length == s.length and answer[i] is the shortest distance from s[i] to the character c in s.

Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]

Input: s = "aaab", c = "b"
Output: [3,2,1,0]
 */
package string;

import java.util.Arrays;

public class ShortestDistanceToACharacter {
    public static void main(String[] args) {
        int[] answer = shortestToChar("aaba", 'b');
        System.out.println(Arrays.toString(answer));

    }

    public static int[] shortestToChar(String s, char c) {
        int len = s.length();
        int preOccurence = -1 * len;//s.indexOf(c);
        int[] result = new int[len];
        //if (preOccurence == -1) return result;
        //result[0] = preOccurence;

        for (int i=0; i<len; i++) {
            // int nextOccurence = s.indexOf(c,i);
            //System.out.println(nextOccurence);

            // if(nextOccurence != -1 && i - preOccurence >= nextOccurence - i) {
            //     preOccurence = nextOccurence;
            // }
            if (s.charAt(i) == c) {
                preOccurence = i;
            }
            result[i] = i - preOccurence;
        }
        preOccurence = Integer.MAX_VALUE;
        for (int i=len-1; i>=0; i--) {
            if (s.charAt(i) == c) {
                preOccurence = i;
            }
            result[i] = Math.min(result[i], preOccurence - i);
        }
        return result;
    }
}
