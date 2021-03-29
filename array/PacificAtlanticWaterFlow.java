/*
You are given an m x n integer matrix heights representing the height of each unit cell in a continent.
The Pacific ocean touches the continent's left and top edges, and the Atlantic ocean touches
the continent's right and bottom edges.

Water can only flow in four directions: up, down, left, and right.
Water flows from a cell to an adjacent one with an equal or lower height.

Return a list of grid coordinates where water can flow to both the Pacific and Atlantic oceans.

Constraints:
m == heights.length
n == heights[i].length
1 <= m, n <= 200
1 <= heights[i][j] <= 10^5

Example 1:
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

Example 2:
Input: heights = [[2,1],[1,2]]
Output: [[0,0],[0,1],[1,0],[1,1]]
 */
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        List<List<Integer>> result = pacificAtlantic(new int[][] {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        });
        for (List<Integer> list: result) {
            System.out.println(list.toString());
        }

    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> result = new ArrayList<>();

        if (matrix==null || matrix.length==0 || matrix[0].length==0) return result;

        int row = matrix.length, col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        for (int i=0;i<col;i++) {
            dfs(matrix,0,i,Integer.MIN_VALUE,pacific);
            dfs(matrix,row-1,i,Integer.MIN_VALUE,atlantic);
        }

        for (int i=0;i<row;i++) {
            dfs(matrix,i,0,Integer.MIN_VALUE,pacific);
            dfs(matrix,i,col-1,Integer.MIN_VALUE,atlantic);
        }

        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    public static void dfs(int[][] matrix, int r, int c, int prev, boolean[][] ocean) {
        if (r < 0 || r >= ocean.length || c < 0 || c >= ocean[0].length) return;
        if (matrix[r][c] < prev || ocean[r][c]) return;

        ocean[r][c] = true;
        dfs(matrix, r+1, c, matrix[r][c], ocean);
        dfs(matrix, r-1, c, matrix[r][c], ocean);
        dfs(matrix, r, c+1, matrix[r][c], ocean);
        dfs(matrix, r, c-1, matrix[r][c], ocean);
    }
}
