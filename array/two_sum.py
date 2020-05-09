def two_sum(nums, target):
    num_pair={}

    if nums:
        for i in range(len(nums)):
            num_diff = target - nums[i]
            if num_diff in num_pair:
                return [num_pair[num_diff],i]
                break
            else:
                num_pair[nums[i]] = i
    return None


#Time complexity -O(n) and Space complexity - O(n)
nums = [2,8,5,7,11,3]
print(two_sum(nums,11))
