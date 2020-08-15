'''
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:
    A -> 1
    Z -> 26
    AA -> 27
    AB -> 28
Input: "ZY"
Output: 701
'''
def title_to_number(s: str) -> int:
    result = 0
    for i in range(len(s),0,-1):
        result += (ord(s[i-1]) - ord('A') + 1) * 26 ** (len(s) - i)

    return result

print(title_to_number('ABC'))
