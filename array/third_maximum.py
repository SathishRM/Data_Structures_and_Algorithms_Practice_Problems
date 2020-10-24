'''
Given a non-empty array of integers, return the third maximum number in this array.
If it does not exist, return the maximum number. The time complexity must be in O(n).

Input: [2, 2, 3, 1]
Output: 1
Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
'''
def third_max(nums: list([int])) -> int:
    max1 = max2 = max3 = float('-inf')

    for i in range(len(nums)):
        if nums[i] > max1:
            max3 = max2
            max2 = max1
            max1 = nums[i]
        elif nums[i] > max2 and nums[i] != max1:
            max3 = max2
            max2 = nums[i]
        elif nums[i] > max3 and nums[i] != max2 and nums[i] != max1:
            max3 = nums[i]

    return max3 if max3 != float('-inf') else max1

print(third_max([1,2,-657689,30]))
