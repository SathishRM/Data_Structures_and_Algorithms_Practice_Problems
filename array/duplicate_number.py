def findDuplicate(nums: list([int])) -> int:
    '''One duplicate element which can repeat many times
    Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive)
    [2,2,2,2,2]
    [2,3,1,4,3]
    '''
    # if nums[0] in nums[1:]:
    #     return nums[0]
    # elif nums[-1] in nums[:-1]:
    #     return nums[-1]
    # else:
    #     for i in range(1,len(nums)-1):
    #         if nums[i] in nums[:i]+nums[i+1:]:
    #             return nums[i]
    #approach-1 time- O(n) space- O(n)
    # nums_count = {num: 0 for num in nums}
    # for num in nums:
    #     nums_count[num] += 1
    #
    # print(nums_count)
    #
    # for key, value in nums_count.items():
    #     if value > 1:
    #         return key

    #without extra space
    #approach-1 time- O(n) space- O(1)
    for i in range(len(nums)):
        if nums[abs(nums[i])] >= 0:
            nums[abs(nums[i])] = -nums[abs(nums[i])]
        else:
            return abs(nums[i])


a = [5,3,1,4,2,1]
print(findDuplicate(a))
