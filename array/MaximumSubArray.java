/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
[1,1,4,2,3], x = 5
 */

package array;

public class MaximumSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1,1,-4,2,3}));
    }

    public static int maxSubArray(int[] nums) {
        int maximum=Integer.MIN_VALUE, maxSoFar=0;
        for(int i=0;i< nums.length;i++) {
            maxSoFar += nums[i];
            if (maximum < maxSoFar) maximum = maxSoFar;
            if (maxSoFar < 0) maxSoFar = 0;
        }
        return maximum;
    }
}
