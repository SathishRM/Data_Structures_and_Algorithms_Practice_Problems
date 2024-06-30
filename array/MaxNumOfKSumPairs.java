/*
You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 */
package array;

import java.util.HashMap;
import java.util.Map;

public class MaxNumOfKSumPairs {
    public static void main(String[] args) {
        //[3,1,3,5,3,1]
        //[1,2,3,4,1,4,4,1]
        System.out.println(maxOperations(new int[]{2, 2, 2, 3, 1, 1, 4, 1}, 4));

    }

    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> pairs = new HashMap<>();
        int pairsCount = 0;
        int comp;
        for (int i = 0; i < nums.length; i++) {
            pairs.merge(nums[i], 1, Integer::sum);
            comp = k - nums[i];
            if (pairs.getOrDefault(comp, 0) > 0) {
                if (nums[i] != comp) {
                    pairsCount++;
                    pairs.merge(comp, -1, Integer::sum);
                    pairs.merge(nums[i], -1, Integer::sum);
                }
                else {
                    if (pairs.getOrDefault(comp, 0) > 1) {
                        pairsCount++;
                        pairs.merge(nums[i], -2, Integer::sum);
                    }
                }
            }
        }
        return pairsCount;
    }

    // 2 pointers with sorting
    public static int maxOperations2Pointers(int[] nums, int k) {
        if (nums.length < 2) return 0;

        java.util.Arrays.sort(nums);
        int l = 0, r = nums.length-1, result = 0, c = 0;
        while(l < r) {
            c = nums[l] + nums[r];
            if (c == k) {
                result++;
                l++;
                r--;
            }
            else if(c < k) l++;
            else r--;
        }
        return result;
    }
}
