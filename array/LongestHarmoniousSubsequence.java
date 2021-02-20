/*
We define a harmonious array as an array where the difference between its maximum value and
its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence among
all its possible subsequences.

A subsequence of array is a sequence that can be derived from the array by deleting some or
no elements without changing the order of the remaining elements.

Input: nums = [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].

Input: nums = [1,1,1,1]
Output: 0
 */
package array;

import java.util.Arrays;
import java.util.HashMap;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }

    public static int findLHS(int[] nums) {
        int maxLen =0, startIdx=0, prevIdx=0;

        //Using sorting - time complexity - O(n log n) and space - O(log n)
//        Arrays.sort(nums);
//        int i =0;
//        while (i < nums.length) {
//            if (i+1 < nums.length && nums[i] != nums[i+1]) {
//                if (i != 0 && nums[i] - nums[prevIdx] == 1)
//                    maxLen =  Math.max(maxLen, i - prevIdx + 1);
//                prevIdx = startIdx;
//                startIdx = i+1;
//            }
//            i++;
//        }
//        if (nums[i-1] - nums[prevIdx] == 1)
//            maxLen = Math.max(maxLen, i - prevIdx);

        //Using map time - O(n) space - O(n)
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int num: nums) {
            numsMap.put(num, numsMap.getOrDefault(num, 0)+1);
        }
        for (int num: numsMap.keySet()) {
            if (numsMap.containsKey(num+1)) {
                maxLen =  Math.max(maxLen, numsMap.get(num) + numsMap.get(num+1));
            }
        }

        return maxLen;
    }
}
