/*
You are given an integer array coins representing coins of different denominations and
an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Input: coins = [2], amount = 3
Output: -1

Input: coins = [1], amount = 0
Output: 0
 */
package array;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    static Map<Integer, Integer> calValues = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2}, 0));

    }

    public static int coinChange(int[] coins, int amount) {
        if (calValues.containsKey(amount)) return calValues.get(amount);
        if (amount == 0) return 0;
        else if (amount < 0) return -1;

        int result = -1;
        for (int coin: coins) {
            int bal = amount - coin;
            int newCount = coinChange(coins, bal);
            if (newCount != -1) {
                newCount++;
                if (result == -1 || newCount < result) result = newCount;
            }
        }

        calValues.put(amount, result);
        return result;

    }
}
