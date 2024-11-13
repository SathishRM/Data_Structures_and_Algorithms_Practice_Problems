"""
2563. Count the Number of Fair Pairs
Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.

A pair (i, j) is fair if:
0 <= i < j < n, and
lower <= nums[i] + nums[j] <= upper

Example 1:
Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
Output: 6
Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).

Example 2:
Input: nums = [1,7,9,2,5], lower = 11, upper = 11
Output: 1
Explanation: There is a single fair pair: (2,3).

Constraints:
1 <= nums.length <= 10^5
nums.length == n
-10^9 <= nums[i] <= 10^9
-10^9 <= lower <= upper <= 10^9
"""


class CountNumberOfFairPairs:
    # def __init__(self, nums, lower, upper):
    #     self.nums = nums
    #     self.lower = lower
    #     self.upper = upper

    def countFairPairs(self, nums: list[[int]], lower: int, upper: int) -> int:

        nums.sort()
        countUpper = self.countPairsWithinBoundary(nums, upper)
        countLower = self.countPairsWithinBoundary(nums, lower-1)

        return countUpper - countLower

    def countPairsWithinBoundary(self, nums: list[[int]], limit: int) -> int:
        l = 0
        r = len(nums) - 1
        count = 0

        while l < r:
            if nums[l] + nums[r] <= limit:
                count += r - l
                l +=1
            else:
                r -= 1
        return count


if __name__ == '__main__':
    countNumberOfFairPairs = CountNumberOfFairPairs()
    print(countNumberOfFairPairs.countFairPairs([0,1,7,5,4,4], 3, 6))