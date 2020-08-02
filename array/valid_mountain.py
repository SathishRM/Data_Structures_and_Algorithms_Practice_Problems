def validMountainArray(A: list([int])) -> bool:
    if len(A) > 2:
        up_hill = True
        down_hill = False
        peak = A[1]
        for i in range(1,len(A)):
            if A[i] >= peak:
                peak = A[i]
            else:
                up_hill = False
                down_hill = True

            if up_hill and A[i] <= A[i-1]:
                return False
            elif down_hill and A[i] >= A[i-1]:
                return False

        if down_hill and not up_hill:
            return True
    return False

m = [0,3,4,7,6,2,1]
print(validMountainArray(m))
