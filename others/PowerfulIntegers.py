'''
Given three integers x, y, and bound, return a list of all the powerful integers that
have a value less than or equal to bound.

An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.
You may return the answer in any order. In your answer, each value should occur at most once.

Constraints:
1 <= x, y <= 100
0 <= bound <= 106

Example 1:
Input: x = 2, y = 3, bound = 10
Output: [2,3,4,5,7,9,10]
Explanation:
2 = 20 + 30
3 = 21 + 30
4 = 20 + 31
5 = 21 + 31
7 = 22 + 31
9 = 23 + 30
10 = 20 + 32

Example 2:
Input: x = 3, y = 5, bound = 15
Output: [2,4,6,8,10,14]
'''
from math import log


def powerfulIntegers(x: int, y: int, bound: int) -> list([int]):
    result = set()
    if bound <=1:
        return list(result)
    i = int(log(bound,x)) if x>1 else 0
    j = int(log(bound,y)) if y>1 else 0
    for fi in range(i+1):
        for si in range(j+1):
            value = x**fi + y**si
            if value <= bound:
                result.add(value)
            else:
                break

    return list(result)

print(powerfulIntegers(2,3,10))