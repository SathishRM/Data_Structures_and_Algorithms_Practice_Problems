/*
There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.

When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.



Example 1:

Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
Example 2:

Input: customers = [1], grumpy = [0], minutes = 1
Output: 1


Constraints:

n == customers.length == grumpy.length
1 <= minutes <= n <= 2 * 104
0 <= customers[i] <= 1000
grumpy[i] is either 0 or 1.
 */

package sliding_window;

public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[] {445,639,976,531,238,223,223,276,454,996,491,622,767,106,
                554,205,694,57,992,425,225,214,502,407,449,698,784,242,16,542,5,815,473,885,985,391,322,565,
                807,444,142,288,816,158,323,230,276,907,864,941,73,580,801,818,436,484,892,350,989,316,818,6,
                312,196,276,993,737,161,399,994,56,481,812,483,280,662,303,523,958,69,611,53,573,744,208,2,872,
                718,702,495,907,522,959,277,985,466,298,291,225,574,126,261,837,384,781,298,867,381,588,550,413,
                177,281,812,622,987,347,177,2,585,962,633,863,439,798,825,586,8,545,646,813,159,449,126,950,671,
                723,610,883,77,61,220,721,451,506,765,642,699,432,870,109,410,956,578,380,724,598,42,856,239,808,
                881,657,799,467,992,174,826,41,727,823,835,715,838,859,265,10,414,213,335,75,54,842,773,38,759,
                446,962,96,877,335,655,236,434,213,437,931,630,227,358,572,739,745,398,439,664,782,908,36,228,679,
                464,100,497,555,797,943,154,818,993,102,149,779,672,787,791,731,560,315,436,70,971,999,807,971,699,
                402,426,209,796,48,895,467,482,703,561,215,532,966,24,4,10,40,321,993,192,495,998,839,124,966,579,
                52,984,893,953,288,545,750,825,247,184,950,786,160,262,65,594,509,280,255,962,85,500,486,144,217,831,
                4,944,720,74,689,704,111,396,239,901,203,21,940,358,428,321,586,192,770,288,306,484,122,584,402,422,
                159,381,138,477,276,95,331,542,1000,402,789,358,745,538,307,77,40,826,323,129,817,567,473,482,42,344,
                823,1,701,496,905,693,62,66,293,296,472,906,948,949,853,596,360,724,188,329,591,481,569,320,54,985,
                134,12,72,653,263,189,637,931,683,632,33,98,134,460,729,283,897,407,82,365,522,164,641,528,500,620,
                863,12,12,611,89,628,687,203,861,126,341,514,541,114,279,439,501,551,62,458,858,39,107,821,716,22,174,
                165,335,480,722,979,307,127,179,142,627,500,438,292,259,913,993,295,394,959,711,877,958,113,566,417,
                19,573,995,13,592,379,640,115,324,746,420,15,712,314,901,618,287,560,306,258,663,812,528,647,89,534,
                943,523,622,100,261,581,695,163,807,456,525,363,698,293,436,724,359,305,231,75,847,897,845,150,10,842,
                355,883,614,670,354,702,901,778,322,370,568,682,605,170,284,99,1,719,446,926,336,280,1,967,168,436,763,
                853,805,275,24,929,852,636,531,410,628,300,517,453,143,715,275,451,592,879,153,805,470,78,703,793,725,
                993,694,407,615,658,559,169,853,122,590,305,301,43,821,822,18,757,637,572,825,131,261,799,231,665,186,
                611,758,116,16,509,478,481,840,954,923,553,472,455,655,273,527,345,462,540,77,472,475,758,631,585,205,
                128,308,64,355,220,710,338,441,561,469,107,197,330,609,193,925,410,572,670,947,311,317,60,791,941,540,
                627,924,671,26,564,235,460,953,137,733,237,738,771,607,411,480,36,119,406,813,609,770,252,114,817,785,
                874,116,725,703,769,68,156,34,61,273,768,260,77,77,245,27,192,755,202,559,486,50,921,509,304,417,794,
                655,881,86,638,576,653,461,472,861,939,980,821,530,584,306,186,737,660,538,616,221,255,653,115,755,389,
                64,847,54,385,209,721,251,771,622,839,846,68,388,966,589,529,578,278,678,728,888,804,386,723,431,847,
                202,708,106,214,580,143,925,41,595,521,601,209,261,14,216,760,995,812,538,389,365,930,931,850,628,408,
                590,372,193,176,28,717,552,759,500,250,957,342,803,831,878,726,850,825,282,637,1000,236,227,646,118,71,
                624,195,779,702,821,695,70,320,750,231,639,222,567,763,693,19,560,800,864,645,826,984,719,752,993,548,
                348,935,770,133,16,670,406,494,135,431,779,234,721,105,557,767,934,153,788,868,275,295,683,420,766,393,
                319,952,448,731,849,47,729,3,633,598,499,777,906,933,910,663,27,14,575,916,881,517,478,763,630,26,198,4,
                436,815,735,290,942,760,395,299,721,674,916,287,121,793,59,980,932,202,945,618,598,413,468,58,605,653,
                298,858,528,971,685,378,970,343,270,777,74,74,230,123,567,752,558,935,243,312,216,174,413,577,541,126,
                703,276,288,374,339,67,469,296,622,118,669,314,874,386,306,199,168,259,589,983,729,340,82,321,266,239,
                316,943,849,403,369,406,88,990,189,123,966,410,832,669,836,701,274,263,484,595,515,468,703,328,740,672,84,311,378,631,716,31,410,127,511,65,909,332,852,434,847,356,100,454,176,712,711,992,760,284,239,508,122,23,674,800,374,251}, new int[] {0,1,0,1,1,0,0,0,1,1,0,1,1,0,0,1,0,0,1,1,1,1,1,0,1,1,1,0,1,1,0,0,1,1,1,0,0,0,1,1,0,1,1,1,1,0,0,1,1,0,1,0,0,1,0,1,0,0,1,1,0,1,1,1,1,0,0,1,1,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,1,1,0,1,0,0,1,1,0,1,1,1,1,0,0,0,1,0,0,1,1,1,0,1,0,0,1,1,0,0,1,0,0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,1,0,0,0,1,1,0,1,0,1,0,1,1,1,0,0,1,0,0,1,1,0,1,1,1,1,1,0,0,0,0,1,0,1,1,1,1,1,0,1,0,0,1,1,0,1,0,1,1,0,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,0,1,0,1,1,1,0,0,0,1,1,0,1,0,1,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,1,0,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,1,0,0,1,0,0,1,0,1,1,1,0,0,0,1,0,1,0,1,0,1,0,1,1,1,0,0,1,1,0,0,0,0,0,1,1,0,0,1,0,0,1,0,1,0,1,1,0,0,1,1,0,0,0,1,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0,1,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,0,1,0,1,1,0,0,0,0,0,1,1,0,0,0,1,0,1,0,1,1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,0,0,0,1,1,1,0,1,1,0,0,0,1,0,0,1,0,1,1,0,1,0,1,0,0,1,0,1,0,0,1,0,0,1,0,1,0,0,0,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,0,0,0,0,0,0,1,1,0,1,0,1,1,0,1,0,0,0,0,0,1,0,0,0,1,1,0,1,0,0,1,1,0,0,1,0,0,1,0,1,1,1,0,0,1,0,1,1,0,0,1,1,1,0,1,0,1,1,1,1,0,0,0,1,0,1,1,1,1,0,0,1,1,1,1,0,1,1,0,0,0,1,0,1,1,1,0,1,0,0,1,0,0,1,0,0,1,1,0,1,0,0,0,1,1,0,1,1,1,1,1,0,0,1,0,0,1,0,1,0,1,1,1,1,0,1,1,1,0,1,0,0,0,0,0,0,1,0,0,1,0,1,1,0,1,0,0,0,1,1,1,1,1,0,0,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,1,1,0,0,1,1,1,1,0,1,0,1,1,0,1,0,1,0,1,1,0,1,0,1,1,1,0,1,1,0,1,1,0,1,0,0,1,0,0,1,0,1,1,1,1,0,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0,1,0,0,1,0,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,1,1,1,0,1,1,1,1,1,1,0,0,1,1,0,0,1,1,1,1,0,0,0,0,1,1,1,0,0,0,1,0,0,1,0,1,0,1,1,0,1,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,0,1,0,1,0,0,0,1,1,1,1,0,1,1,0,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,0,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,0,1,1,1,0,0,1,1,0,1,0,0,0,0,1,0,1,1,1,0,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,0,0,1,1,1,0,0,0,1,1,1,0,1,0,1,0,1,0,1,1,0,0,1,1,0,1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,1,0,0,0,1,0,0,1,1,0,0,1,0,1,0,0,1,0,0,1,1,0,0,1,0,0,1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,0,1,1,0,0,1,0,1,1,1,1,1,0,0,1,0,0,1}, 907));
    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int i = 0, gm = 0, rm = minutes, result = Integer.MIN_VALUE, cr = 0;
        for (int k = 0; k < grumpy.length; k++) {
            if (grumpy[k] == 0) gm += customers[k];
        }
        result = Math.max(result, gm);

        while (i < grumpy.length) {

            if (grumpy[i] == 1) {
                int j = i;

                while (rm > 0 && j < grumpy.length) {
//                    System.out.println(j);
                    if (grumpy[j] == 1) cr += customers[j];
                    j++;
                    rm--;
//                    System.out.println("Inside: " + cr);
                }

                result = Math.max(result, cr + gm);
                cr = 0;
                rm = minutes;
            }
            i++;
        }
        return result;
    }
}