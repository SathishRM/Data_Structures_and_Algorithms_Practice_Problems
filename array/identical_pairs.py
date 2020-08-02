def numIdenticalPairs(nums: list([int])) -> int:
    distinct_nums = set(nums)
    result = 0
    for num in distinct_nums:
        num_count = nums.count(num)
        if num_count > 1:
            num_count -= 1
            while num_count > 0:
                result += num_count
                num_count -= 1

    return result
