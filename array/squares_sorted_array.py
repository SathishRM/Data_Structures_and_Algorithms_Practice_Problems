def sorted_squares(A: list([int])) -> list([int]):
    '''Given an array of integers A sorted in non-decreasing order,
    return an array of the squares of each number, also in sorted non-decreasing order.
    Input: [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    '''
    n = len(A)
    result = []
    pi = 0

    while pi < n and A[pi] < 0:
        pi += 1
    ni = pi -1

    while ni >= 0 and pi < n:
        if A[ni] ** 2 < A[pi] ** 2:
            result.append(A[ni] ** 2)
            ni -= 1
        else:
            result.append(A[pi] ** 2)
            pi += 1
    while ni >= 0:
        result.append(A[ni] ** 2)
        ni -= 1
    while pi < n:
        result.append(A[pi] ** 2)
        pi += 1

    return result

A = [-3,-2,0,1,5,7]
print(sorted_squares(A))
