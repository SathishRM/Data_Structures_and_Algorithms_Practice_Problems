def findMaxConsecutiveOnes(nums: list([int])) -> int:
    count = max_count = 0
    nums_len = len(nums)
    if nums:
        for i,v in enumerate(nums):
            if v == 1:
                count += 1
            else:
                if max_count < count:
                    max_count = count
                    if max_count > nums_len - i:
                        break
                count =0

        if max_count < count:
                max_count = count
    return max_count

nums = [1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
print(findMaxConsecutiveOnes(nums))
