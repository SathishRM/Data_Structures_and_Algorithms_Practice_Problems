/*
Given an integer array nums, return an array answer such that answer[i] is equal to
the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity?
(The output array does not count as extra space for space complexity analysis.)
 */
package array;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(productExceptSelf(new int[]{-1,1,1,-3,3})));

    }

    public static int[] productExceptSelf(int[] nums) {
        int zero = 0;
        int product = 1;
        for(int n: nums) {
            if (n ==0) {
                zero++;
                continue;
            }
            product = product * n;
        }

        int[] result = new int[nums.length];
        for (int i=0; i<nums.length;i++) {
            if(zero > 0 && nums[i] != 0) result[i]=0;
            else if(zero>0 && nums[i] == 0) {
                if (zero == 1) result[i] = product;
                else result[i] = 0;
            }
            else if(zero ==0 && nums[i] != 0) {
                result[i] = product/nums[i];
            }
        }
        return result;

    }
}
