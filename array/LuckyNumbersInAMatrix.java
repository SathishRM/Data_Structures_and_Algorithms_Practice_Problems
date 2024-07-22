/*
1380. Lucky Numbers in a Matrix
Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and
maximum in its column.

Example 1:
Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 2:
Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 3:
Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.

Constraints:
m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.
All elements in the matrix are distinct.
 */
package array;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix {
    public static void main(String[] args) {
        System.out.println(luckyNumbers(new int[][]{
                {3,7,8},
                {9,11,13},
                {15,16,17}
        }));
    }

    public static List<Integer> luckyNumbers (int[][] matrix) {
        int minIndex, minElement, maxElement;
        List<Integer> result = new ArrayList<>();
        List<Integer> minCol = new ArrayList<>();
        List<Integer> maxRow = new ArrayList<>();
        for(int i=0;i<matrix.length;i++) {
            minElement=Integer.MAX_VALUE;
            for(int j=0;j<matrix[i].length;j++) {
                if(matrix[i][j] < minElement) minElement = matrix[i][j];
            }
            minCol.add(minElement);
        }

        for(int i=0;i<matrix[0].length;i++) {
            maxElement=Integer.MIN_VALUE;
            for(int j=0;j<matrix.length;j++) {
                if(matrix[j][i] > maxElement) maxElement = matrix[j][i];
            }
            maxRow.add(maxElement);
        }

        for(Integer e: minCol) {
            if(maxRow.contains(e)) result.add(e);
        }
        return result;
    }
}
