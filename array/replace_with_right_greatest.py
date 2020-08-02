def replaceElements(arr: list([int])) -> list([int]):
    #Replace the element with the greatest element on its right and last value with -1
    max_val = -1
    for i in range(len(arr)-1,-1,-1):
        if max_val < arr[i]:
            arr[i], max_val = max_val, arr[i]
        else:
            arr[i] = max_val
    return arr

n = [17,18,5,4,6,1]
print(replaceElements(n))
