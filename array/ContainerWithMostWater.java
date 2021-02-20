/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.
 */
package array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{4,3,1,2,4}));
    }
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, area = 0, curValue;
        while (left < right) {
            curValue = Math.min(height[left], height[right]) * (right - left);
            area = Math.max(area, curValue);

            if (height[left] < height[right]) left++;
            else right--;
        }
        return area;
    }
}
