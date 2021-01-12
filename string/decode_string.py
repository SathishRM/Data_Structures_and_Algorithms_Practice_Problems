'''
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Input: s = "3[a2[c]]"
Output: "accaccacc"

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
'''
from collections import deque


def decodeString(s: str) -> str:
    num_list = deque()
    alpha_list = deque()
    idx = 0
    result = ''
    while idx < len(s):
        if s[idx].isdigit():
            num = ''
            while s[idx].isdigit():
                num += s[idx]
                idx += 1
            num_list.append(int(num))
        elif s[idx].isalpha():
            result += s[idx]
            idx += 1
        elif s[idx] == '[':
            alpha_list.append(result)
            result = ''
            idx += 1
        else:
            temp = alpha_list.pop()
            temp  += result * num_list.pop()
            result = temp
            idx += 1
    return result

print(decodeString("3[a]2[b4[F]c]"))





