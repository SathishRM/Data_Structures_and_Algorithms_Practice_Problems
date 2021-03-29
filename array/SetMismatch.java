/*
You have a set of integers s, which originally contains all the numbers from 1 to n.
Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

Constraints:
2 <= nums.length <= 104
1 <= nums[i] <= 104

Input: nums = [1,2,2,4]
Output: [2,3]

Input: nums = [1,1]
Output: [1,2]
 */
package array;

import java.util.Arrays;
import java.util.HashMap;

public class SetMismatch {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{2,2,1})));
    }
    public static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        for (int n: nums) {
            if (nums[Math.abs(n)-1] < 0) result[0] = Math.abs(n);
            else nums[Math.abs(n)-1] *= -1;
        }
        for (int i=0;i< nums.length;i++) {
            if (nums[i] > 0) result[1] = i+1;
        }

        //Time - O(n) and space - O(n)
//        HashMap<Integer, Integer> numsCount = new HashMap<>();
//        for (int i=0;i<nums.length;i++) {
//            numsCount.put(nums[i], numsCount.getOrDefault(nums[i],0)+1);
//
//            if (numsCount.getOrDefault(i+1,0) == 2) result[0] = i+1;
//            else if (numsCount.getOrDefault(i+1,0) == 0) result[1] = i+1;
//        }
        return result;
    }
}
