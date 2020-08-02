def numSub(s: str) -> int:
    '''Given a binary string s (a string consisting only of '0' and '1's).
        Return the number of substrings with all characters 1's.
        Since the answer may be too large, return it modulo 10^9 + 7.
    '''
    sub_len = list()
    result, count = 0, 0
    for bit in s:
        if bit == '1':
            count += 1
        else:
            sub_len.append(count)
            count = 0
    else:
        sub_len.append(count)

    for l in sub_len:
        if l > 1:
            while l > 0:
                result += l
                l -= 1
        else:
            result += l

    return result % ((10**9)+7)

s = "0110111"
print(numSub(s))
