/*
Given an integer array nums of length n and an integer target,
find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0

Constraints:
3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104
 */
package array;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1,2,5,10,11},12));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 3001;
        for(int i=0;i< nums.length-2;i++) {
            if (i==0 || (i>0 && nums[i] != nums[i-1])) {
                int l = i+1;
                int r = nums.length-1;
                int sum = 0;
                while (l < r) {
                    sum = nums[i] + nums[l] + nums[r];
                    if ( sum == target) return sum;
                    else if (sum < target) {
                        if (Math.abs(sum - target) < Math.abs(result - target) || result == 3001) result = sum;
                        l++;
                    }
                    else {
                        if (Math.abs(sum - target) < Math.abs(result - target) || result == 3001) result = sum;
                        r--;
                    }
                }
            }
        }
        return result;
    }
}
