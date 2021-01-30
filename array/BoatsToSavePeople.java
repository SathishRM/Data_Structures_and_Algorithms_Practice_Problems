/*
The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.
Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
 */
package array;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3,2,3,2,2}, 6));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int noOfBoats = 0, low = 0, high = people.length-1;
        Arrays.sort(people);
        while (low < high) {
            noOfBoats++;
            if (people[low] + people[high] <= limit) {
                low++;
            }
            high--;

        }
        return low == high ? noOfBoats+1: noOfBoats;
    }
}
