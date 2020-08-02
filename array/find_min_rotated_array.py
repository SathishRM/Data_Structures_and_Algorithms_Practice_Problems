'''
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Find the minimum element.
The array may contain duplicates.
'''

def find_min(nums: list([int])) -> int:
    index = 0
    if len(nums) > 1:
        if nums[0] >= nums[-1]:
            index = -1
            inc = 1
            max_index = len(nums) * -1
        else:
            index = 0
            inc = -1
            max_index = len(nums) - 1

        while nums[index] >= nums[index + (-1 * inc)]:
            index += (-1 * inc)
            if index == max_index:
                break

    return nums[index]

nums = [2,2,2,0,1]
print(find_min(nums))
