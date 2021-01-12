package array;

/*
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
Find the kth positive integer that is missing from this array.

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 */

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2,3,4,5},4));

    }

    public static int findKthPositive(int[] arr, int k) {
        int missingCount = arr[0] - 1;

        if (missingCount >= k) {
            return k;
        }

        for(int i=1; i<arr.length; i++) {
            if (arr[i] - arr[i-1] > 1) {
                missingCount += arr[i] - arr[i-1] - 1;
            }

            if (missingCount >= k) {
                return arr[i-1] + k - (missingCount - (arr[i] - arr[i-1] - 1));
            }
        }
        return arr[arr.length - 1] + k - missingCount;

    }
}
