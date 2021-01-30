/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

Input: nums = [4,1,2,1,2]
Output: 4
 */
package array;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,3,3,1,1}));
    }

    public static int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        int i = 0, len = nums.length;
//        while (i < len) {
//            if (i == len - 1) break;
//            else if (nums[i] == nums[i+1]) i+=2;
//            else break;
//        }
//        return nums[i];
        int nonDuplicate = 0;
        for(int i=0;i<nums.length;i++) {
            nonDuplicate = nonDuplicate ^ nums[i];
        }
        return nonDuplicate;
    }
}
