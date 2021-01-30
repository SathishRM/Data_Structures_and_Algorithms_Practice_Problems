/*
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

Input: "Hello"
Output: "hello"

Input: "LOVELY"
Output: "lovely"
 */
package string;

public class UpperToLowerCase {
    public static void main(String[] args) {
        System.out.println(toLowerCase("HeLL$o"));

    }

    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for(int i=0; i< chars.length; i++ ) {
            int asciiValue =  chars[i];
            if (asciiValue <= 90 && asciiValue >= 65) {
                asciiValue += 32;
                chars[i] = (char) asciiValue;
            }
        }
        return String.valueOf(chars);
    }
}
