/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */
package array;


import java.util.Arrays;

public class RunningSum1DArray {
    public static void main(String[] args) {
        int[] result = runningSum(new int[]{1,4,5,10});
        for (int num : result) {
            System.out.println(num);
        }

    }

    public static int[] runningSum(int[] nums) {
        // Arrays.parallelPrefix(nums, Integer::sum); - bit slower compare to imperative approach
        for (int i=1;i<nums.length;i++) {
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;

    }
}
