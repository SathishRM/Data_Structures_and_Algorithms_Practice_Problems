nums = [-1, 2, 3, 4, 2, 3, 7, 5, 4, 8, 1, 6, 9]

def firstMissingPositive(nums: list()) -> int:
    if nums:
        try:
            minumum_value = min([num for num in nums if num > 0])
            if minumum_value != 1:
                return 1
            else:
                minumum_value += 1
                nums_length = len(nums)
                for _ in range(nums_length):
                    if minumum_value not in nums:
                        return minumum_value
                    minumum_value += 1
                return nums_length
        except ValueError:
            return 1
    return 1

print(firstMissingPositive(nums))
