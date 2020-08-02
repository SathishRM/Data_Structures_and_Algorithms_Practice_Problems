def findDuplicate(nums: list([int])) -> int:
    if nums[0] in nums[1:]:
        return nums[0]
    elif nums[-1] in nums[:-1]:
        return nums[-1]
    else:
        for i in range(1,len(nums)-1):
            if nums[i] in nums[:i]+nums[i+1:]:
                return nums[i]

a = [5,6,9,3,1,7,3,8,4,2]
print(findDuplicate(a))
