/*
Alice has n candies, where the ith candy is of type candyType[i].
Alice noticed that she started to gain weight, so she visited a doctor.

The doctor advised Alice to only eat n / 2 of the candies she has (n is always even).
Alice likes her candies very much, and she wants to eat the maximum number of different types of candies
while still following the doctor's advice.

Given the integer array candyType of length n, return the maximum number of different types of candies
she can eat if she only eats n / 2 of them.

Constraints:
n == candyType.length
2 <= n <= 104
n is even.
-105 <= candyType[i] <= 105

Input: candyType = [1,1,2,2,3,3]
Output: 3
Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.

Input: candyType = [6,6,6,6]
Output: 1
Explanation: Alice can only eat 4 / 2 = 2 candies. Even though she can eat 2 candies, she only has 1 type.
 */
package array;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1,2,2,3,3}));
    }
    public static int distributeCandies(int[] candyType) {
        Set<Integer> uniqueTypes = new HashSet<Integer>();

        for (int i=0; i<candyType.length;i++) {
//          if(!uniqueTypes.contains(candyType[i]))
            uniqueTypes.add(candyType[i]);

            if (uniqueTypes.size() >= candyType.length/2) return candyType.length/2;
        }
        return uniqueTypes.size();
    }
}
