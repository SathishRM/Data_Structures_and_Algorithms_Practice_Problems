def hammingDistance(x: int, y: int) -> int:
    diff_positions = x ^ y
    hamming_distance = 0
    while diff_positions > 0:
        hamming_distance += diff_positions & 1
        diff_positions >>= 1

    return hamming_distance

print(hammingDistance(2,7))
