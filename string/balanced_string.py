'''
Balanced strings are those who have equal quantity of 'L' and 'R' characters.
Given a balanced string s split it in the maximum amount of balanced strings.
Return the maximum amount of splitted balanced strings.

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
'''

def balanced_string(s: str) -> int:
    lr_count = result = 0
    for c in s:
        if c == 'L':
            lr_count -= 1
        elif c == 'R':
            lr_count += 1

        if lr_count == 0:
            result += 1

    return result

print(balanced_string('RLLLLRRRLR'))
