def majority_element(nums: list([int])) -> int:
    nums_count={}
    for num in nums:
        if num in nums_count:
            nums_count[num] += 1
        else:
            nums_count[num] = 1
    # print(nums_count)
    # print(str(next(iter(nums_count))))
    max_value = next(iter(sorted(nums_count.items(),key=lambda val: val[1], reverse=True)))
    if max_value[1] >= (len(nums)//2) + 1:
        return max_value[0]
    return None


nums = [2,4,5,2,2,2,6,7,2]
print(majority_element(nums))
