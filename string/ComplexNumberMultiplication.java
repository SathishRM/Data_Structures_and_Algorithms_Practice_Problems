/*
A complex number can be represented as a string on the form "real+imaginaryi" where:

real is the real part and is an integer in the range [-100, 100].
imaginary is the imaginary part and is an integer in the range [-100, 100].
i2 == -1.
Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.



Example 1:

Input: num1 = "1+1i", num2 = "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:

Input: num1 = "1+-1i", num2 = "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.


Constraints:

num1 and num2 are valid complex numbers.
 */
package string;

public class ComplexNumberMultiplication {
    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
    }

    public static String complexNumberMultiply(String num1, String num2) {
        String[] num1Split = num1.split("\\+");
        String[] num2Split = num2.split("\\+");
        int num1RP = Integer.parseInt(num1Split[0]);
        int num1IP = Integer.parseInt(num1Split[1].substring(0,num1Split[1].length()-1));
        int num2RP = Integer.parseInt(num2Split[0]);
        int num2IP = Integer.parseInt(num2Split[1].substring(0,num2Split[1].length()-1));
        int rp = (num1RP * num2RP) + ((num1IP * num2IP) * -1);
        int ip = (num1RP * num2IP) + (num1IP * num2RP);

        return rp+ "+"+ip+"i";
    }
}
