'''
Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in ascending order,
find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].
Follow up: Could you write an algorithm with O(log n) runtime complexity?

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
'''

def searchRange(nums: list([int]), target: int) -> list([int]):
    result = [-1,-1]
    l = len(nums)
    right = l - 1
    left = 0
    i=0
    if l == 1 and nums[0] == target:
        return [0,0]

    while left <= right:
        i = (right + left) // 2
        if nums[i] > target:
            right = i -1
        elif nums[i] < target:
            left = i + 1
        else:
            result[0] = i
            result[1] = i
            break

    j = i;

    if result[0] != -1:
        while  nums[i] == target:
            result[0] = i
            if i == 0:
                # result[1] = i
                break
            i -= 1
        else:
            i += 1
            result[1] = i

        while nums[j] == target:
            result[1] = j
            if j == l-1:
                break
            j += 1

    return result

print(searchRange([2,3,3,4,5,7,7,9],7))