def detect_capital_use(word: str) -> bool:
    '''
    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital, like "Google".
    '''
    #Approach-1 using string methods
    '''
    if word.isupper() or word.islower() or word.istitle():
        return True
    else:
        return False
    '''
    #Approach-2 scan char by char
    up_low = ord(word[0])
    for i in range(1,len(word)):
        if up_low > 96:
            if ord(word[i]) <= 96:
                return False
        else:
            if i > 1:
                if ord(word[i]) > 96 and ord(word[i-1]) <= 96:
                    return False
                elif ord(word[i]) <= 96 and ord(word[i-1]) > 96:
                    return False

    return True
print(detect_capital_use('heLlo'))
