/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Input: m = 3, n = 7
Output: 28

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 */
package array;

import java.awt.*;
import java.util.HashMap;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }

    public static int uniquePaths(int m, int n) {
        return uniquePaths(m, n, new HashMap<Point, Integer>());

    }
    public static int uniquePaths(int m, int n, HashMap<Point, Integer> dp) {
        Point point = new Point(m,n);
        if (m == 1 && n == 1) return 1;
        else if ( m == 0 || n == 0) return 0;
        else if (dp.containsKey(point)) return dp.get(point);
        else {
            dp.put(point, uniquePaths(m-1, n, dp) + uniquePaths(m, n-1, dp));
            return dp.get(point);
        }
    }
}
