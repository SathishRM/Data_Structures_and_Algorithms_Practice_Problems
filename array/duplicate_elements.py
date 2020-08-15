def find_duplicates(nums: list([int])) -> list([int]):
    '''Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
    Find all the elements that appear twice in this array.
    Could you do it without extra space and in O(n) runtime?
    '''
    result = set()
    for i in range(len(nums)):
        if nums[abs(nums[i])-1] >= 0:
            nums[abs(nums[i])-1] = -nums[abs(nums[i])-1]
        else:
            result.add(abs(nums[i]))

    return list(result)

nums = [4,3,2,7,8,2,3,1]
print(find_duplicates(nums))
