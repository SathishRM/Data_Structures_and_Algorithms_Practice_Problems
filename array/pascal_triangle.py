'''Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
Note that the row index starts from 0.
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1
Input: 3
Output: [1,3,3,1]
'''
def get_row(rowIndex: int) -> list([int]):
    result = [1 for _ in range(rowIndex+1)]
    if rowIndex > 1:
        for i in range(2,rowIndex+1):
            tmp = tmp1 = result[0]
            for j in range(1,i):
                tmp1 = result[j]
                result[j] += tmp
                tmp = tmp1
    return result

print(get_row(6))
