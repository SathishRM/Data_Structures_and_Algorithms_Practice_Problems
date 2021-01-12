
from time import time


def spaceReplace(urlString, actualLen):
    '''Replace the spaces in the string with %20'''
    result = ''
    for c in urlString[:actualLen]:
        if c != ' ':
            result += c
        else:
            result += '%20'
    return result


def spaceReplaceByteArray(urlString, actualLen):
    '''Replace the spaces in the bytearray with %20 without using any additional variable'''
    totLen = len(urlString)
    print(actualLen, totLen)
    for i in range(actualLen, 0, -1):
        if chr(urlString[i-1]) == ' ':
            urlString[totLen-1] = ord('0')
            urlString[totLen-2] = ord('2')
            urlString[totLen-3] = ord('%')
            totLen -= 3
        else:
            urlString[totLen-1] = urlString[i-1]
            totLen -= 1

    return(urlString.decode())


replaceStr = '%20'
# print timeit.timeit(a, number=1000000)
t1 = time()
print(spaceReplaceByteArray(bytearray('Hello Hai How are you        ', 'utf-8'), 21))
t2 = time()
print(t1, t2, t2-t1)


t1 = time()
print(spaceReplace('Hello Hai How are you        ', 21))
t2 = time()
print(t1, t2, t2 - t1)
