'''
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
Digital root
'''
def add_digits(num: int) -> int:
    return (num - 1) % 9 + 1 if num else 0

num = 127
print(add_digits(num))
