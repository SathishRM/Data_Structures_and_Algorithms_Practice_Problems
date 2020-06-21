def pattern_search(s,p,d):
    '''Rabin karp algorithm'''
    pattern_len = len(p)
    str_len = len(s)
    pat_hash = 0
    str_hash = 0
    hash_val = d**(pattern_len-1)

    for i in range(pattern_len):

        pat_hash += (d**(pattern_len - i -1)) * ord(p[i])
        str_hash += (d**(pattern_len - i -1)) * ord(s[i])
        # print(i,d**i,pat_hash,str_hash)
    # print(pat_hash,str_hash,hash_val)

    for i in range(str_len - pattern_len + 1):
        if pat_hash == str_hash:
            j = 0
            while j < pattern_len:
                if p[j] != s[i+j]:
                    break
                j += 1
            if j == pattern_len:
                print (f"pattern found at index {i}")

        if i < str_len - pattern_len:
            str_hash = (str_hash - (hash_val * ord(s[i])) ) * d + ord(s[i+pattern_len])
            # r_hash = (str_hash -  remove_hash)   * d
            # str_hash = r_hash + ord(s[i+pattern_len])
            # print(f"new hash code - {i} {str_hash} {remove_hash} {r_hash}")


pattern_search('anana', 'ban', 26)
