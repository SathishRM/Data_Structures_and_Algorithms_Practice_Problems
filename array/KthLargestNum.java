/*
Find the kth largest element in an unsorted array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Input: [3,2,1,5,6,4] and k = 2
Output: 5
 */
package array;

import java.util.Arrays;

public class KthLargestNum {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 3));

    }

    public static int findKthLargest(int[] nums, int k) {
//        int[] result = new int[k];
//        result = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).limit(k).mapToInt(Integer::intValue).toArray();
//        return result[k-1];
        Arrays.sort(nums);
        return nums[nums.length-k];

        //Quick Select method

    }
}
