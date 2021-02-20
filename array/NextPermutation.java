/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible,
it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
The replacement must be in place and use only constant extra memory.
Input: nums = [1,2,3]
Output: [1,3,2]
 */
package array;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,3,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void nextPermutation(int[] nums) {
        boolean swapFlag = false;
        int len = nums.length, i = len - 1, j= len -1;
        while(i > 0) {
            if (nums[i] > nums[i-1]) {
                i--;
                swapFlag = true;
                break;
            }
            i--;
        }

        while ( swapFlag && j > i) {
            if (nums[i] < nums[j]) {
                swap(nums, i, j);
                break;
            }
            j--;
        }
        i = swapFlag ? i+1: 0;
        j = len -1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
        //Arrays.sort(nums, i, len);
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
