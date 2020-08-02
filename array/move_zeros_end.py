def moveZeroes(nums: list([int])) -> None:
    """
    Move the zeros to end with changing the sorting arrangment
    Do not return anything, modify nums in-place instead.
    """
    zero_idx = 0
    for i in range(len(nums)):
        if nums[zero_idx] != 0:
            zero_idx += 1
        if nums[i] != 0 and i != zero_idx:
            if zero_idx < i:
                nums[zero_idx], nums[i] = nums[i], nums[zero_idx]
                zero_idx += 1

a = [1,2,0,0,3,5,0,8,0]
moveZeroes(a)
print(a)
