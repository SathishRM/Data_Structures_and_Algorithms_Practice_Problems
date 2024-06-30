/*
643. Maximum Average Subarray I
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value
and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:
Input: nums = [5], k = 1
Output: 5.00000

Constraints:
n == nums.length
1 <= k <= n <= 10^5
-10^4 <= nums[i] <= 10^4
 */
package sliding_window;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        if(nums.length == 1) return nums[0];

        int l=0, r=k-1, sum=0,i=0;
        double avg = -Double.MAX_VALUE, c;

        while (i<k) {
            sum += nums[i];
            i++;
        }
        c = calAverage(sum, k);
        avg = Math.max(avg,c);
        while(r<nums.length-1) {
            sum -= nums[l];
            l++;
            r++;
            sum += nums[r];
            c = calAverage(sum, k);
            avg = Math.max(avg,c);

        }
        return avg;

    }

    public static double calAverage(int sum, int k) {
        return sum/Double.valueOf(k);
    }
}
