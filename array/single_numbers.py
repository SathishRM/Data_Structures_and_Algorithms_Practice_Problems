def singleNumber(nums: list([int])) -> list([int]):
    '''Given an array of numbers nums, in which exactly two elements appear only once
    and all the other elements appear exactly twice. Find the two elements that appear only once
    '''
    result = list()
    nums.sort()
    i = 1
    nums_len = len(nums)

    while i < nums_len:
        if nums[i-1] != nums[i]:
            result.append(nums[i-1])
            i += 1
        else:
            i += 2
    else:
        if nums[nums_len - 1] != nums[nums_len - 2]:
            result.append(nums[nums_len - 1])

    return result

nums = [1,2,1,3,2,5]
print(singleNumber(nums))
