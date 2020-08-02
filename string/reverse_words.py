def reverseWords(self, s: str) -> str:
    '''reverse the string word by word without leading or tailing spaces.
    Also the result should have only one space between words
    '''
    #approach-1
    # return ' '.join(' '.join(s.split(' ')[::-1]).split())
    #approach-2
    result = ''
    end_position = -1
    for i in range(len(s)-1,-1,-1):
        # print(i,s[i],end_position)
        if s[i] != ' ' and end_position == -1:
            end_position = i
        elif s[i] == ' ' and end_position != -1:
            result = result + ' ' + s[i+1:end_position+1]
            end_position = -1
    else:
        if end_position != -1:
            result = result + ' ' + s[i:end_position+1]
    #print(result)
    return result[1:]
