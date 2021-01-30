/*
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn].

Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 */
package array;

import java.util.Arrays;

public class ShuffleArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{1,3,5,2,4,6}, 3)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int j=0;
        for(int i=0;i<n;i++) {
            result[j] = nums[i];
            result[j+1] = nums[i+n];
            j+=2;
        }
        return result;
    }
}
