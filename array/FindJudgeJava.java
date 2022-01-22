/*
Find the Town Judge
In a town, there are n people labeled from 1 to n.
There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:
The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing
that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

Example 1:
Input: n = 2, trust = [[1,2]]
Output: 2

Example 2:
Input: n = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:
Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1

Constraints:
1 <= n <= 1000
0 <= trust.length <= 104
trust[i].length == 2
All the pairs of trust are unique.
ai != bi
1 <= ai, bi <= n
 */

package array;

import java.util.HashSet;
import java.util.Set;

public class FindJudgeJava {
    public static void main(String[] args) {
        System.out.println(findJudge(4, new int[][] { {3,2},{4,1},{3,1},{2,1},{2,3},{4,3},{4,2},{3,4} }));
    }

    public static int findJudge(int n, int[][] trust) {
        Set<Integer> commonPeople = new HashSet<>();
        int result = -1;

        if (trust.length == 0) {
            if (n > 1) return -1;
            else return 1;
        }

        for (int i=0;i<trust.length;i++) {
            commonPeople.add(trust[i][0]);
        }
        // System.out.println(commonPeople.size());
        if (commonPeople.size() != n-1) return -1;
        else {
            for (int i=1;i<=n;i++)
                if (! commonPeople.contains(i)) result = i;
        }

        if (result == -1) return result;

        for (int i=0;i<trust.length;i++) {
            if (trust[i][1] == result && commonPeople.contains(trust[i][0])) {
                commonPeople.remove(trust[i][0]);
            }
        }
        return (commonPeople.size()==0) ? result: -1;
    }
}
