def plusOne(digits: list([int])) -> list([int]):
    result=0
    digit_len = len(digits)
    for i in range(digit_len-1,-1,-1):
        result += digits[i] * (10 ** (digit_len-i-1))

    result += 1
    return [int(i) for i in str(result)]

arr = [ 1,9,9]
print(plusOne(arr))
