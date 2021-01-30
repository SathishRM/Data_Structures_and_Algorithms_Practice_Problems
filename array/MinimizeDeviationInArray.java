/*
You are given an array nums of n positive integers.
You can perform two types of operations on any element of the array any number of times:

If the element is even, divide it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the last element,
and the array will be [1,2,3,2].

If the element is odd, multiply it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the first element,
and the array will be [2,2,3,4].

The deviation of the array is the maximum difference between any two elements in the array.
Return the minimum deviation the array can have after performing some number of operations.

Input: nums = [4,1,5,20,3]
Output: 3
Explanation: You can transform the array after two operations to [4,2,5,5,3],
             then the deviation will be 5 - 2 = 3.
 */
package array;

import java.util.TreeSet;

public class MinimizeDeviationInArray {
    public static void main(String[] args) {
        System.out.println(minimumDeviation(new int[]{2,8,10}));

    }

    public static int minimumDeviation(int[] nums) {

        TreeSet<Integer> numSet = new TreeSet<>();
        for(int num: nums) {
            if (num % 2 == 0) numSet.add(num);
            else numSet.add(num*2);
        }

        int diff = Integer.MAX_VALUE;
        while (true) {
            int minNum = numSet.first();
            int maxNum = numSet.last();
            int curDiff = maxNum - minNum;
            diff = Math.min(diff, curDiff);
            if (maxNum % 2 == 0) {
                numSet.remove(maxNum);
                numSet.add(maxNum/2);
            }
            else {
                return diff;
            }
        }
    }
}
