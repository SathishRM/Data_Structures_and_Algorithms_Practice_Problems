def bit_insertion(n,m,j,i):
    ''' m and n are binary numbers (base 2)
    i and j are decimal numbers (base 10)'''
    if len(bin(m)) - 2 <= j - i + 1:
        m <<= 2

        left = int(bin(~0),2) << j + 1
        right = (1 << i) - 1

        mask = left | right

        masked_n = n & mask
        return bin(masked_n | m)

    return None

n=0b1100111001
m=0b1101
print(bit_insertion(n,m,5,2))
print(bit_insertion(n,m,4,2))
