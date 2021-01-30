/*
Given an array nums of 0s and 1s and an integer k,
return True if all 1's are at least k places away from each other, otherwise return False.

Input: nums = [1,0,0,0,1,0,0,1], k = 2
Output: true
Explanation: Each of the 1s are at least 2 places away from each other.
 */
package array;

import java.util.Arrays;

public class CheckIfAll1sLeastLenAway {
    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1,0,0,0,1,0,0,1}, 2));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int previousIndex=-1;
        for(int i=0;i<nums.length;i++) {
            if (nums[i] == 1) {
                if (previousIndex != -1 && i - previousIndex - 1 < k) return false;
                previousIndex=i;
            }
        }
        return true;

    }
}
