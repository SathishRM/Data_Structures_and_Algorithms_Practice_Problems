def compress(chars):
    strLen = len(chars)
    count = 0
    result = []
    for i in range(strLen-1):
        count += 1
        if chars[i] != chars[i+1]:
            result.append(chars[i])
            if count > 1:
                result.append(str(count))
            if i + 1 == strLen - 1:
                result.append(chars[i+1])
            count = 0
        elif i + 1 == strLen - 1 and chars[i] == chars[i+1]:
            count += 1
            result.append(chars[i])
            if count > 1:
                result.append(str(count))
        # elif i + 1 == strLen - 1:
        #     result += chars[i]
        #     if count > 1:
        #         result += str(count)
        #     result += chars[i+1]

    return result


#chars = ['a', 'a', 'a', 'b', 'b', 'b', 'a']
chars = 'aaabbca'
print(compress(chars))
