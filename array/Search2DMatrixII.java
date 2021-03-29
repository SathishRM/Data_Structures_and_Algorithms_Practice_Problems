/*
Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
 */
package array;

public class Search2DMatrixII {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        }, 18));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        while (row < matrix.length && col >= 0){
            if (target > matrix[row][col]) {
                row++;
            }
            else if (target < matrix[row][col]) {
                col--;
            }
            else return true;
        }
        return false;
        //System.out.println(row + ", "+ col +" ,"+ matrix[row-1][col-1]);
//         if (matrix[0][0] > target || matrix[row-1][col-1] < target) return false;

//         int beginRow=0, beginCol=0;
//         for (int i=0,j=0;i<row&&j<col;i++,j++) {
//             if (matrix[i][j] >= target) {
//                 beginRow = i;
//                 beginCol = j;
//                 break;
//             }
//         }
//         System.out.println(beginRow + ", "+ beginCol);
//         for (int i=beginRow;i<row;i++) {
//             for (int j=0;j<col;j++) {
//                 if (matrix[i][j] == target) return true;
//             }
//         }

//         for (int j=beginCol;j<col;j++) {
//             for (int i=0;i<row;i++) {
//                 if (matrix[i][j] == target) return true;
//             }
//         }
//         return false;
    }
}
