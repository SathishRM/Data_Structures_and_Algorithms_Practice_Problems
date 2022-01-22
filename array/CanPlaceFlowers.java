/*
605. Can Place Flowers

You have a long flowerbed in which some of the plots are planted, and some are not.
However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false

Constraints:
1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length
 */
package array;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1},2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;

        if (len == 1 && n == 1) return flowerbed[0] == 0;

        int prevOccupied = -1;
        for (int i=0;i<len-1;i++){
            if (prevOccupied == -1) {
                if (flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    prevOccupied = i;
                    n--;
                }
            }
            if (flowerbed[i] == 0 && i - prevOccupied > 1 && flowerbed[i+1] == 0) {
                prevOccupied = i;
                n--;
            }

            if (flowerbed[i] == 1) prevOccupied = i;
        }
        if ( len - 1 - prevOccupied > 1 && flowerbed[len-1] == 0 && flowerbed[len-2] == 0) n--;
        return n <= 0;
    }
}
