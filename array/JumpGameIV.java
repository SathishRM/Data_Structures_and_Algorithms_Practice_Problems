/*
1345. Jump Game IV

Given an array of integers arr, you are initially positioned at the first index of the array.
In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.
Notice that you can not jump outside of the array at any time.

Example 1:
Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

Example 2:
Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You do not need to jump.

Example 3:
Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.

Constraints:
1 <= arr.length <= 5 * 104
-108 <= arr[i] <= 108
 */
package array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIV {
    private static HashMap<Integer, LinkedList<Integer>> sameValueIdx = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(minJumps(new int[] {100,-23,-23,404,100,23,23,23,3,404}));
    }

    public static int minJumps(int[] arr) {
        int n = arr.length;
        int result = 0;
        if (n <2) return result;

        buildHashMap(arr);

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while (!q.isEmpty()) {
            result++;
            int size = q.size();
            for (int k=0;k<size;k++ ){
                int j = q.poll();

                if (j-1>=0 && sameValueIdx.containsKey(arr[j-1])) q.offer(j-1);
                if (j+1 < n && sameValueIdx.containsKey(arr[j+1])) {
                    if (j+1 == n-1) return result;
                    q.offer(j+1);
                }
                if (sameValueIdx.containsKey(arr[j])) {
                    for (int i: sameValueIdx.get(arr[j])) {
                        if (i != j) {
                            if (i == n-1) return result;
                            q.offer(i);
                        }
                    }
                }
                sameValueIdx.remove(arr[j]);
            }
        }
        return result;
    }


    public static void buildHashMap(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            // LinkedList<Integer> idx = sameValueIdx.getOrDefault(arr[i], new LinkedList<Integer>());
            // idx.add(i);
            // sameValueIdx.put(arr[i],idx);
            sameValueIdx.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        }
    }

}
