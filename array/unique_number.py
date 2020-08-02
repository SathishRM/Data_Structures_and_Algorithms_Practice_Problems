def singleNumber(nums: list([int])) -> int:
    ''' Solution here is without using any extra space'''
    '''approach - 1 Time - O(n*n) and Space - O(0)
    if nums[0] not in nums[1:]:
        return nums[0]
    elif nums[-1] not in nums[:-1]:
        return nums[-1]
    else:
        for i in range(1,len(nums)-1):
            if nums[i] not in nums[:i]+nums[i+1:]:
                return nums[i]'''
    #approach-2 with XOR Time - O(n) and Space -O(1)
    unique_no = 0
    for n in nums:
        unique_no ^= n
    return unique_no

a = [0,2,0,1,2,1,9]
print(singleNumber(a))
