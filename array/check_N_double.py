def checkIfExist(arr: list([int])) -> bool:
    pre_visited = dict()
    for i in range(len(arr)):
        if (arr[i] * 2 in pre_visited) or (arr[i]/2 in pre_visited):
            return True
        pre_visited[arr[i]] = i
    return False

n = [7,1,13,11]
print(checkIfExist(n))
