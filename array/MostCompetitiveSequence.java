/*
Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.
An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.

We define that a subsequence a is more competitive than a subsequence b (of the same length)
if in the first position where a and b differ, subsequence a has a number less than the corresponding number in b.
For example, [1,3,4] is more competitive than [1,3,5] because the first position they differ is at the final number, and 4 is less than 5.

Input: nums = [3,5,2,6], k = 2
Output: [2,6]
Explanation: Among the set of every possible subsequence: {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]}, [2,6] is the most competitive.
 */
package array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MostCompetitiveSequence {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mostCompetitive(new int[]{3,5,2,6}, 2)));
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        int len = nums.length, removed = len - k;
        Deque<Integer> result = new ArrayDeque<>();
        result.push(nums[0]);
        for (int i=1; i<len;i++) {
            while (!result.isEmpty() && removed > 0 && result.peek() > nums[i]) {
                result.pop();
                removed--;
            }
            result.push(nums[i]);
        }
        while (removed > 0) {
            result.pop();
            removed--;
        }

        int[] intResult = new int[k];
        while(k>0) {
            intResult[k-1] = result.pop();
            k--;
        }
        return intResult;
    }
}
