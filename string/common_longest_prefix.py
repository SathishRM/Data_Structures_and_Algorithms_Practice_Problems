def longest_common_prefix(strs: list([str])) -> str:
    '''matched_prefix=""
    if strs:
        min_len = len(strs[0])
        min_word = strs[0]
        for word in strs:
            if min_len > len(word):
                min_len = len(word)
                min_word = word

        for i in range(min_len):
            for word in strs:
                if min_word[i] != word[i]:
                    return matched_prefix
            matched_prefix += min_word[i]

    return matched_prefix'''


    if strs:
        for i in range(len(strs[0])):
            for word in strs[1:]:
                if i == len(word) or word[i] != strs[0][i]:
                    return strs[0][:i]
        return strs[0]
    return ""


str_list = ["flower","flow","flight","car"]
print(longest_common_prefix(str_list))
# print(str_list[0][:0])
