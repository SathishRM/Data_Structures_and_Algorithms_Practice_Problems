/*
You are given an integer array nums and an integer x.
In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x.
Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.

 */
package array;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{7,5,4,9,8}, 3));
//        int a = 7 / 2;
//        System.out.println(a);
    }

    public static int minOperations(int[] nums, int x) {
        int sum = 0, longestSubArray= 0, tmpSum = 0, numsLength = nums.length;
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i=0;i<numsLength;i++) {
            sum += nums[i];
            sumMap.put(sum, i);
        }

        sum -= x;
        for (int i=0;i<numsLength;i++) {
            tmpSum += nums[i];
            if (tmpSum-sum == 0) {
                longestSubArray = Math.max(longestSubArray, i+1);
            }
            else if (sumMap.containsKey(tmpSum-sum)) {
                longestSubArray = Math.max(longestSubArray, i - sumMap.get(tmpSum-sum));
            }
        }
        return longestSubArray==0 ? sum==0 ? numsLength: -1 : numsLength-longestSubArray;
    }
}
