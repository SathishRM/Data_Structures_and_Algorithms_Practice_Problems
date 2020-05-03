def selectionSort(arr):
    for i in range(len(arr)):
        minIndex = i
        for j in range(i+1,len(arr)):
            if arr[minIndex] > arr[j]:
                minIndex = j
        arr[i],arr[minIndex] = arr[minIndex],arr[i]

    return arr

#print(selectionSort([123,45,3,68,14,31]))
#print(selectionSort(['c','d','b','q','a','A']))

def bubbleSort(arr):
    arrLen = len(arr)
    swapFlag = False
    for i in range(arrLen):
        for j in range(arrLen-i-1):
            if arr[j] > arr[j+1]:
                arr[j],arr[j+1] = arr[j+1],arr[j]
                swapFlag = True
        if not swapFlag:
            break
    return arr

#print(bubbleSort([12,45,3,68,14,31]))
#print(bubbleSort(['c','z','E','q','a','g']))

def insertionSort(arr):
    for i in range(1,len(arr)):
        for j in range(i,0,-1):
            if arr[j] < arr[j-1]:
                arr[j],arr[j-1] = arr[j-1],arr[j]
    return arr

#print(insertionSort([12,4,34,8,104]))
# print(insertionSort(['c','Z','y','q','c','h']))


def merge(leftArr,rightArr):
    sortedArr=[]
    i,j=0,0
    while i < len(leftArr) and j < len(rightArr):
        if leftArr[i] < rightArr[j]:
            sortedArr.append(leftArr[i])
            i += 1
        else:
            sortedArr.append(rightArr[j])
            j += 1

    sortedArr += leftArr[i:]
    sortedArr += rightArr[j:]

    return sortedArr

def mergeSort(arr):
    arrLen = len(arr)
    if arrLen > 1:
        midIndex = arrLen//2
        leftArr = mergeSort(arr[:midIndex])
        rightArr = mergeSort(arr[midIndex:])
        return merge(leftArr,rightArr)
    else:
        return arr

# print(mergeSort([x for x in range(1000,0,-1)]))
# print(mergeSort(['c','Z','y','q','c','h']))

def partition(arr, low, high):
    pivot = arr[high]
    minIndex = low - 1
    for i in range(low, high):
        if arr[i] <= pivot:
            minIndex += 1
            arr[minIndex],arr[i] = arr[i], arr[minIndex]

    arr[minIndex+1],arr[high] = arr[high],arr[minIndex+1]
    return minIndex+1

def quickSort(arr, low, high):
    if low < high:
        pi = partition(arr, low, high)

        quickSort(arr,low,pi-1)
        quickSort(arr,pi+1,high)
    return arr

print(quickSort([10,48,32,9,94,25,7],0,6))
