def sortArrayByParity(A: list([int])) -> list([int]):
    odd_idx = 0
    for i in range(len(A)):
        if A[i] % 2 == 0:
            if A[odd_idx] % 2 == 1 and odd_idx != i:
                A[odd_idx], A[i] = A[i], A[odd_idx]
            odd_idx += 1
    return A

A = [1,3,8,6,4,9,13,2]
print(sortArrayByParity(A))
