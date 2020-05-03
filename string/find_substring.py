def strStr(haystack: str, needle: str) -> int:
        if needle:
            #approach -1 using find method
            #return haystack.find(needle)

            #approach -2
            for i in range(len(haystack)-len(needle)+1):
                for j in range(len(needle)):
                    if haystack[i+j] != needle[j]:
                        break
                else:
                    return i
            return -1
        return 0

print(strStr("helello","ll"))
