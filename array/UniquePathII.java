/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and space is marked as 1 and 0 respectively in the grid.

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 */
package array;

import java.awt.*;
import java.util.HashMap;

public class UniquePathII {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0}, {0,1,0}, {0,0,0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length - 1;
        int col = obstacleGrid[0].length - 1;

        return uniquePathsWithObstacles(obstacleGrid, row, col, new HashMap<Point, Integer>());
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int col, HashMap<Point, Integer> dp) {
        Point point = new Point(row, col);
        if (row < 0 || col < 0 || obstacleGrid[row][col] == 1) return 0;
        else if ( row == 0 && col == 0) return 1;
        else if (dp.containsKey(point)) return dp.get(point);

        dp.put(point, uniquePathsWithObstacles(obstacleGrid, row-1, col, dp) + uniquePathsWithObstacles(obstacleGrid, row, col-1, dp));
        return dp.get(point);
    }
}
