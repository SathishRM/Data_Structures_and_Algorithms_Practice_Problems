'''
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here.
Input: "abccccdd"

Output: 7
'''
import collections

def longest_palindrome(s: str) -> int:
    dict_count = collections.Counter(s)
    result = 0
    flag = False

    for key in dict_count.keys():
        if dict_count[key] % 2 == 1:
            dict_count[key] -= 1
            flag = True
        result += dict_count[key]

    return result+1 if flag else result

print(longest_palindrome('aabbbccc'))
