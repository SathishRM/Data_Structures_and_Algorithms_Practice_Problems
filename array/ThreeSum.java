/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []

Constraints:
0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1,-1,-5,-2,1,6,3}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for(int i=0;i< nums.length-2;i++) {
            if (i==0 || (i>0 && nums[i] != nums[i-1])) {
                int l = i+1;
                int r = nums.length-1;
                int sum = 0-nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while (l < r && nums[l] == nums[l+1]) l++;
                        while (l < r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }
                    else if (nums[l] + nums[r] < sum) l++;
                    else r--;
                }

            }
        }
        return result;
    }
}
