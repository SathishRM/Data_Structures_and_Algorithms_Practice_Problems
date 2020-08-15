def is_palindrome(s: str) -> bool:
    '''Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    '''
    # approach-1 space - O(n) and time - O(n)
    # new_s = ''.join(c.lower() for c in s if c.isalnum())
    # if new_s == new_s[::-1]:
    #     return True
    # return False

    # approach-2 binary search space - O(2) and time - O(n)
    i = 0
    j = len(s) - 1
    while i < j:
        if s[i].isalnum() and s[j].isalnum():
            if s[i].lower() != s[j].lower():
                return False
            else:
                i += 1
                j -= 1
        elif not s[i].isalnum():
            i += 1
        elif not s[j].isalnum():
            j -= 1
    return True

s = "A man, a plan, a canal: Panama"
print(is_palindrome(s))
