/*
435. Non-overlapping Intervals

Given an array of intervals (intervals) where intervals[i] = [starti, endi],
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

Constraints:
1 <= intervals.length <= 105
intervals[i].length == 2
-5 * 104 <= starti < endi <= 5 * 104
 */
package array;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][] { {1,2},{1,2},{1,2} }));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        int result = 0;
        int p = 0;

        for (int i=1;i<intervals.length;i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            int currentEnd = intervals[p][1];

            if (currentEnd > nextStart) {
                result++;
                if (nextEnd < currentEnd) p = i;
            }
            else p = i;
        }
        return result;
    }
}
