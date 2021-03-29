/*
Given two arrays A and B of equal size, the advantage of A with respect to B is the number
of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.

Note:
1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9

Example 1:
Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]

Example 2:
Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]
 */
package array;

import java.util.*;

public class AdvantageShuffle {
    public static void main(String[] args) {
        int[] result = advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11});
        System.out.println(Arrays.toString(result));
    }
    public static int[] advantageCount(int[] A, int[] B) {
        int len = A.length;
        Map<Integer, Queue<Integer>> originalIdx = new HashMap<>();

        for (int i=0;i<len;i++) {
            originalIdx.putIfAbsent(B[i], new LinkedList<>());
            originalIdx.get(B[i]).add(i);
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int[] result = new int[len];
        Queue<Integer> unusedValues = new LinkedList<>();

        int i=0,j=0;
        Arrays.fill(result,-1);
        while (i < len && j < len) {
            if (A[i] <= B[j]) {
                unusedValues.add(A[i]);
            }
            else {
                result[originalIdx.get(B[j]).poll()] = A[i];
                j++;
            }
            i++;
        }

        for (int idx=0;idx<len;idx++) {
            if (result[idx] == -1) result[idx] = unusedValues.poll();
        }
        return result;
    }
}
