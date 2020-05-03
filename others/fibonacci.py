import sys


def fib(n):
    #print(f"Called for the value {n}")
    global count
    count += 1
    if n < 0:
        return "Not possible for a negative number"
    # elif n == 0:
    #     calValues[n] = 0
    #     return calValues[n]
    # elif n == 1:
    #     calValues[n] = 1
    #     return calValues[n]
    else:
        if n in calValues:
            return calValues.get(n)
        else:
            result = fib(n-1) + fib(n-2)
            calValues[n] = result
            return result


count = 0
calValues = {}
calValues[1] = 0
calValues[2] = 1
result = fib(100)
print(f"{result}   {count}")
print(sys.getrecursionlimit())
print(f"{calValues}")
# 5 count-9
