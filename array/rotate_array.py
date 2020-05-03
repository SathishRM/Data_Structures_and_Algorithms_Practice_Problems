from math import gcd
num_list = [1,2,3,4,5,6]

def right_rotate(nums, k):
    nums_len = len(nums)
    if k and nums_len > 1:
        k %= nums_len
        set_count = gcd(nums_len,k)
        set_len = nums_len // set_count
        for i in range(set_count):
            index = 0 + i
            temp = nums[index]
            for _ in range(set_len):
                new_index = (index + k) % nums_len
                temp1 = nums[new_index]
                nums[new_index] = temp
                index = new_index
                temp = temp1

def left_rotate(nums, k):
    nums_len = len(nums)
    if k and nums_len > 1:
        k %= nums_len
        set_count = gcd(nums_len,k)
        set_len = nums_len // set_count
        # print(set_count,set_len)
        for i in range(set_count):
            index = nums_len - 1 - i
            temp = nums[index]
            for _ in range(set_len):
                new_index = (index - k)
                if new_index < nums_len * -1:
                    new_index += nums_len
                #print(new_index,index)
                temp1 = nums[new_index]
                nums[new_index] = temp
                index = new_index
                temp = temp1

print(num_list)
left_rotate(num_list,3)
print(num_list)
