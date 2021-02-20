/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Input: s = "anagram", t = "nagaram"
Output: true

You may assume the string contains only lowercase alphabets.
 */
package string;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        // time - O(n) and space - O(1) constant space regardless of the length of strings
        int[] counter = new int[26];
        for (int i=0; i<s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for(int count: counter) {
            if (count != 0) return false;
        }
        return true;

        //time - O(n) and space - O(n)

//         Map<Character, Integer> map1 = new HashMap<>();
//         Map<Character, Integer> map2 = new HashMap<>();

//         for (int i=0; i<s.length(); i++) {
//             char c = s.charAt(i);
//             map1.put(c,map1.getOrDefault(c,0)+1);
//         }

//         for (int i=0; i<t.length(); i++) {
//             char c = t.charAt(i);
//             map2.put(c,map2.getOrDefault(c,0)+1);
//         }


//         for(char c: map1.keySet()) {
//             // System.out.println(map1.get(c) + " - " + map2.getOrDefault(c,0));
//             if (map1.get(c).intValue() != map2.getOrDefault(c,0).intValue()) {
//                 return false;
//             }
//         }
//         return true;
    }
}
