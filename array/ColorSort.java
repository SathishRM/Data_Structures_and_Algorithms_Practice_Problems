/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 */

package array;

public class ColorSort {
    public static void main(String[] args) {
        int[] nums = {2,1,0,1,2,0};
        sortColors(nums);
        System.out.println(java.util.Arrays.toString(nums));

    }

    public static void sortColors(int[] nums) {
        int r=0,w=0,b=0;

        for(int i=0;i<nums.length;i++) {
            if (nums[i] == 0) r++;
            else if(nums[i] == 1) w++;
            else b++;
        }

        for (int i=0;i<nums.length;i++) {
            if (i < r) nums[i] = 0;
            else if(i >=r && i < r +w ) nums[i]=1;
            else nums[i]=2;
        }
    }
}
