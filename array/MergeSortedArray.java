package array;

/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

 */

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,4,5,6,0};
        int[] num2 = new int[]{3};
        merge(num1, 5, num2, 1);
        for(int num: num1)
            System.out.println(num);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int insPosition;
        int i=0, j=0;
        while (j < n) {
            insPosition = m + j;
            if ( m > 0) {
                while ( insPosition > 0 && nums1[insPosition - 1] > nums2[j] ) {
                    nums1[insPosition] = nums1[insPosition-1];
                    insPosition -= 1;
                }
            }
            nums1[insPosition] = nums2[j];
            j += 1;

        }
    }
}
