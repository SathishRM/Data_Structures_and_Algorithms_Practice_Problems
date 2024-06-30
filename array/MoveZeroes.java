/*
283. Move Zeroes
Given an integer array nums, move all 0's to the end of it while maintaining the
relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1

Follow up: Could you minimize the total number of operations done?
 */
package array;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] result = new int[]{1,0,3,0,15};
        moveZeroes(result);
        System.out.println(java.util.Arrays.toString(result));
    }

    public static void moveZeroes(int[] nums) {
        int t, l = 0, r = 1;
        if (nums.length > 1) {
            for (int i=0;i<nums.length;i++) {
                if (nums[l] == 0) {
                    while (r < nums.length && nums[r] == 0) r++;
                    if (r<nums.length) {
                        nums[l] = nums[r];
                        nums[r] = 0;

                    }
                }
                r++;
                l++;
            }
        }
    }
    // Approach -2
//    public static void moveZeroes(int[] nums) {
//        int l =0, r=1;
//        while(r < nums.length && l < nums.length) {
//            if (nums[l] == 0 && nums[r] !=0) {
//                nums[l] = nums[r];
//                nums[r] = 0;
//                l++;
//                r++;
//            }
//            else if(nums[l] ==0 && nums[r] == 0){
//                r++;
//            }
//            else if(nums[l] != 0 && nums[r] !=0){
//                l++;
//                r++;
//            }
//            else if(nums[l] != 0 && nums[r] == 0 ) {
//                l++;
//                r++;
//            }
//        }
//    }
    //Approach - 1
//    public static void moveZeroes(int[] nums) {
//        if (nums.length == 1) return;
//        int i = 0, z = -1;
//        while(i<nums.length) {
//            if (nums[i] == 0) {
//                if (z == -1) z=i;
//            }
//            else {
//                if (z != -1) {
//                    nums[z] = nums[i];
//                    nums[i] = 0;
//                    while(nums[z+1]==0) {
//                        z++;
//                        break;
//                    }
//                }
//            }
//            i++;
//        }
//    }
}
