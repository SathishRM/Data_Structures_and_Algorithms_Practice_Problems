def reverse(x: int) -> int:
    sign_flag = int(x > 0)
    reverse_value = 0
    x = abs(x)
    while x > 0:
        reverse_value *= 10
        reverse_value += x % 10
        x//=10

    if sign_flag < 1:
        reverse_value *= -1
    if reverse_value >= -2**31 and reverse_value <= 2**31 - 1:
        return reverse_value
    return 0
