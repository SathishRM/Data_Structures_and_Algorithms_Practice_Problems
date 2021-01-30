/*
Convert a non-negative integer num to its English words representation.

Input: num = 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
package string;

import java.util.Arrays;

public class IntegerToEnglishWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(10000));
    }

    public static String numberToWords(int num) {
        int term=0;
        String numInWords = "";

        while(num > 0) {
            numInWords = (wordsHelper(num%1000, term) + numInWords).trim();
            term++;
            num = num / 1000;
        }

        return numInWords;
    }

    private static String wordsHelper(int num, int term) {
        String result="";
        String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"};
        if (num/100 > 0) result = units[num/100] + " Hundred ";
        if (num%100 < 20) result = result + units[num%100];
        else {
            result = result + tens[(num%100)/10] + " " + units[(num%100)%10];
        }
        if (num > 0) {
            switch (term) {
                case 1:
                    result = result.trim() + " Thousand ";
                    break;
                case 2:
                    result = result.trim() + " Million ";
                    break;
                case 3:
                    result = result.trim() + " Billion ";
                    break;
            }
        }
        return result;
    }
}
