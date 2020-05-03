def merge(nums1: list([int]), m: int, nums2: list([int]), n: int) -> None:
    """
    Do not return anything, modify nums1 in-place instead.
    """
    '''i = 0
    j = 0
    while j < len(nums2):
        if nums2[j] < nums1[i] or len(nums2) - j == len(nums1) - i:
            k = i
            ins_value = nums2[j]
            while k < len(nums1):
                tmp = nums1[k]
                nums1[k] = ins_value
                ins_value = tmp
                k += 1
            else:
                j += 1
        i += 1'''
    i = len(nums1) - 1
    j = len(nums2) - 1
    while j > -1:
        #print(nums1,i,j)
        if i == j:
            nums1[i] = nums2[j]
            j -= 1
            i -= 1
        elif nums1[i-j-1] < nums2[j]:
            nums1[i] = nums2[j]
            j -= 1
            i -= 1
        else:
            nums1[i-j-1],nums1[i] = nums1[i],nums1[i-j-1]
            i -= 1
        #print(nums1,i,j)

a=[1,2,3,0,0,0]
m=3
b=[2,5,6]
n=3
merge(a,m,b,n)
print(a)
