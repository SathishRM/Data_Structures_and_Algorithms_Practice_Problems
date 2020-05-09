def is_perfect_square(num: int) -> bool:
    if (num ** 0.5) % 1 == 0:
        return True
    return False

print(is_perfect_square(900))
