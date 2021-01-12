package array;

import java.util.Arrays;

public class SmallestRangeII {
    public static void main(String[] args) {

        System.out.println(smallestRangeII(new int[]{2, 7, 2}, 1));
    }

    public static int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int lenA = A.length;
        int min = A[0];
        int max = A[lenA - 1];
        int result = max - min;
        for (int i=0; i < lenA - 1; i++) {
            int newMin = Math.min(min + K, A[i+1] - K);
            int newMAX = Math.max(max - K, A[i] + K);
            result = Math.min(newMAX - newMin, result);
        }
        return result;
    }
}
