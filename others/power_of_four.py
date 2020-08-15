from math import log, floor

def is_power_of_four(num: int) -> bool:
    if num <= 0:
        return False
    four_pow = log(abs(num), 4)
    return True if four_pow == floor(four_pow) else False

print(is_power_of_four(24))
