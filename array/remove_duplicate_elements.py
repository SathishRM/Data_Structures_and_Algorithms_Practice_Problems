def removeDuplicates(nums: list()) -> int:
    '''Input is a sorted list'''
    i=0
    new_len = len(nums)
    #approach -1 using list pop
    '''while new_len > 1 and i != new_len - 1:
       # print(nums,i)
        if nums[i] == nums[i+1]:
            nums.pop(i)
            new_len = len(nums)
        else:
            i += 1
        #print(nums)

    return len(nums)'''

    #approach-2 replace the duplicate element with next unique value
    for j in range(1,new_len):
        if nums[i] != nums[j]:
            i += 1
            nums[i] = nums[j]

    return i+1

num_list = [1,1,2,3,4,4,4,5,8,8,12]
unique_idx = removeDuplicates(num_list)
print(num_list[:unique_idx])
