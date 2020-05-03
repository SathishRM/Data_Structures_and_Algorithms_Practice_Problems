def reverseString(s: list([int])) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        s_len = len(s)
        '''if s_len > 1:
            mid_index = s_len // 2
            for index in range(mid_index):
                s[index], s[s_len-1-index] = s[s_len-1-index], s[index]'''

        #approach-2
        left, right = 0, s_len-1
        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1

s=['h','e','l','l','o','1']
print(reverseString(s))
print(s)
