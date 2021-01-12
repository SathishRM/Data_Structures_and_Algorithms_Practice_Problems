package array;

import java.util.Arrays;

public class StringArrayCompare {
    public static void main(String[] args) {
        System.out.println(arrayStringAreEqual(new String[]{"a","bc"}, new String[]{"ab","c"}));

    }

    public static boolean arrayStringAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }

}
