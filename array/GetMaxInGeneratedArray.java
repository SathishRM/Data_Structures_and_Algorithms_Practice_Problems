/*
You are given an integer n. An array nums of length n + 1 is generated in the following way:
nums[0] = 0
nums[1] = 1
nums[2 * i] = nums[i] when 2 <= 2 * i <= n
nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
Return the maximum integer in the array nums.

Input: n = 7
Output: 3
Explanation: According to the given rules:
  nums[0] = 0
  nums[1] = 1
  nums[(1 * 2) = 2] = nums[1] = 1
  nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
  nums[(2 * 2) = 4] = nums[2] = 1
  nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
  nums[(3 * 2) = 6] = nums[3] = 2
  nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
Hence, nums = [0,1,1,2,1,3,2,3], and the maximum is 3.

 */
package array;

import java.util.Arrays;

public class GetMaxInGeneratedArray {
    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(2));

    }

    public static int getMaximumGenerated(int n) {
        int[] result = new int[n+2];
        result[0] =0;
        if (n> 0) {
            result[1] = 1;
            int iterCount = n / 2;
            for (int i = 1; i <= iterCount; i++) {
                result[2 * i] = result[i];
                if (n >= 2 * i + 1) result[2 * i + 1] = result[i] + result[i + 1];
            }
        }
        return Arrays.stream(result).max().getAsInt();
    }
}
