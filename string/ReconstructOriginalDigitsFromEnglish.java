/*
Given a non-empty string containing an out-of-order English representation of digits 0-9,
output the digits in ascending order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits.
That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.

Example 1:
Input: "owoztneoer"
Output: "012"

Example 2:
Input: "fviefuro"
Output: "45"
 */
package string;

public class ReconstructOriginalDigitsFromEnglish {
    public static void main(String[] args) {
        System.out.println(originalDigits("owoztneoer"));
    }

    public static String originalDigits(String s) {
        int[] flags = new int[26];
        int[] count = new int[10];
        StringBuilder result = new StringBuilder();

        for (char c: s.toCharArray()) {
            flags[c-'a']++;
        }
        //System.out.println(Arrays.toString(flags));

        count[0] = flags['z'-'a'];
        count[2] = flags['w'-'a'];
        count[4] = flags['u'-'a'];
        count[6] = flags['x'-'a'];
        count[8] = flags['g'-'a'];

        count[1] = flags['o'-'a'] - count[0] - count[2] - count[4];
        count[3] = flags['h'-'a'] - count[8];
        count[5] = flags['f'-'a'] - count[4];
        count[7] = flags['s'-'a'] - count[6];
        count[9] = flags['i'-'a'] - count[5] - count[6] - count[8];

        for (int i=0;i<10;i++) {
            while (count[i] > 0) {
                result.append(i);
                count[i]--;
            }
        }
        return result.toString();
    }
}
