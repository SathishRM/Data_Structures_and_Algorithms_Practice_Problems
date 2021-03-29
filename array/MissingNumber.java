/*
Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

Constraints:
n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
2 is the missing number in the range since it does not appear in nums.

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2].
2 is the missing number in the range since it does not appear in nums.
 */
package array;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0,1,3}));
    }
    public static int missingNumber(int[] nums) {
        int sum = 0, len= nums.length;
        for (int i=0;i<len;i++) sum += nums[i];

        return (len * (len + 1) / 2) - sum;
    }
}
