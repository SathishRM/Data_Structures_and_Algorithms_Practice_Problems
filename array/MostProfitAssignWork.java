/*
You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:

difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
Every worker can be assigned at most one job, but one job can be completed multiple times.

For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker cannot complete any job, their profit is $0.
Return the maximum profit we can achieve after assigning the workers to the jobs.



Example 1:

Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
Output: 100
Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get a profit of [20,20,30,30] separately.
Example 2:

Input: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
Output: 0


Constraints:

n == difficulty.length
n == profit.length
m == worker.length
1 <= n, m <= 104
1 <= difficulty[i], profit[i], worker[i] <= 105
 */

package array;

import java.util.HashMap;
import java.util.Map;

public class MostProfitAssignWork {
    static Map<Integer, Integer> profitMap = new HashMap<>();
    static Map<Integer, Integer> seen = new HashMap<>();
    static int idx = 0;
    static int tmp = 0;

    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(new int[]{66,1,28,73,53,35,45,60,100,44,59,94,27,88,7,18,83,18,72,63}, new int[]{66,20,84,81,56,40,37,82,53,45,43,96,67,27,12,54,98,19,47,77},new int[]{61,33,68,38,63,45,1,10,53,23,66,70,14,51,94,18,28,78,100,16}));

    }
//    {1=20, 7=12,  18=19, 18=19, 27=67, 28=84, 35=40, 44=45, 45=37, 53=56, 59=43, 60=82, 63=77, 66=66, 72=47, 73=81, 83=98, 88=27, 94=96, 100=53}
//    [1, 7, 18, 18, 27, 28, 35, 44, 45, 53, 59, 60, 63, 66, 72, 73, 83, 88, 94, 100]
//    [1, 10, 14, 16, 18, 23, 28, 33, 38, 45, 51, 53, 61, 63, 66, 68, 70, 78, 94, 100]

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        for (int i=0;i<difficulty.length;i++) profitMap.put(difficulty[i],profit[i]);
        System.out.println(profitMap.toString());
        java.util.Arrays.sort(difficulty);
        java.util.Arrays.sort(worker);
        System.out.println(java.util.Arrays.toString(worker));
        System.out.println(java.util.Arrays.toString(difficulty));
        int result = 0;

        for (int work: worker) {
                System.out.println("result" + result);
                result += findMaxProfit(difficulty, work);
                System.out.println("work" + work);

        }
        return result;
    }

    private static int findMaxProfit(int[] difficulty, int work) {

        while (idx<difficulty.length) {

            if (work >= difficulty[idx]) {
                tmp = Math.max(tmp, profitMap.get(difficulty[idx]));
            }
            else break;
            idx++;
        }
        System.out.println("return "+tmp);
        return tmp;
    }

    public static int binarySearch(int[] difficulty, int work) {
        int l =0, r= difficulty.length-1;
        int m, tmp = 0;
        while (l <= r) {
            m = (l + r) / 2;
//            System.out.println("Inside loop left:" + l + " right:"+ r);
            if (work < difficulty[m]) r = m-1;
            else if (work > difficulty[m]) {
                l = m+1;
                tmp = Math.max(tmp,profitMap.get(difficulty[m]));
            }
            else {
                r = m-1;
                tmp = Math.max(tmp, profitMap.get(difficulty[m]));
            }
        }
        System.out.println("left:" + l + " right:"+ r);
        if (l > r && r >= 0) {
            if (work > difficulty[r]) tmp = Math.max(tmp, profitMap.get(difficulty[r]));
        }
        return tmp;

    }
}
