/*
On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square,
that walk over every non-obstacle square exactly once.

Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 */

package array;

public class UniquePathIII {
    public static void main(String[] args) {
        System.out.println(uniquePathsIII(new int[][]{{1,0,0,0}, {0,0,0,0}, {0,0,0,2}}));
    }

    public static int uniquePathsIII(int[][] grid) {
        int row=0, col=0, zero=0;

        for (int i = grid.length - 1; i>=0; i--) {
            for (int j=grid[0].length - 1; j >=0; j--) {
                if (grid[i][j] == 0) zero++;
                else if (grid[i][j] == 2) {
                    row = i;
                    col =j;
                }
            }
        }
        return uniquePathsIII(grid, row, col, zero);
    }

    public static int uniquePathsIII(int[][] grid, int row, int col, int zero) {

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1) return 0;
        else if (grid[row][col] == 1) return zero == -1 ? 1 : 0;

        grid[row][col] = -1;
        zero--;
        int result = uniquePathsIII(grid, row-1, col, zero) +
                uniquePathsIII(grid, row, col-1, zero) +
                uniquePathsIII(grid, row+1, col, zero) +
                uniquePathsIII(grid, row, col+1, zero);

        grid[row][col] = 0;
        zero++;
        return result;
    }
}
