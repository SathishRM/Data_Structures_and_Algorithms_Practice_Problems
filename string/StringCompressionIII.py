'''
3163. String Compression III
Given a string word, compress it using the following algorithm:

Begin with an empty string comp. While word is not empty, use the following operation:
Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
Append the length of the prefix followed by c to comp.
Return the string comp.

Example 1:
Input: word = "abcde"
Output: "1a1b1c1d1e"

Explanation:
Initially, comp = "". Apply the operation 5 times, choosing "a", "b", "c", "d", and "e" as the prefix in each operation.
For each prefix, append "1" followed by the character to comp.

Example 2:
Input: word = "aaaaaaaaaaaaaabb"
Output: "9a5a2b"

Explanation:
Initially, comp = "". Apply the operation 3 times, choosing "aaaaaaaaa", "aaaaa", and "bb" as the prefix in each operation.
For prefix "aaaaaaaaa", append "9" followed by "a" to comp.
For prefix "aaaaa", append "5" followed by "a" to comp.
For prefix "bb", append "2" followed by "b" to comp.

Constraints:
1 <= word.length <= 2 * 105
word consists only of lowercase English letters.
'''


class StringCompressionIII:
    def compressedString(self, word: str) -> str:
        if not word:
            return ''

        result = []
        cur_char = word[0]
        count = 1

        for c in word[1:]:
            if c == cur_char:
                if count == 9:
                    result.append('9')
                    result.append(c)
                    count = 1
                else:
                    count += 1
            else:
                result.append(str(count))
                result.append(cur_char)
                cur_char = c
                count = 1

        result.append(str(count))
        result.append(cur_char)

        return ''.join(result)

    def compressedStringFirstApproach(self, word: str) -> str:
        result = ""

        for c in word:
            if len(result) == 0:
                result = '1' + c
            else:
                if c == result[-1]:
                    val = int(result[-2])
                    if val == 9:
                        result += '1' + c
                    else:
                        result = result[:-2] + str(val+1) + c
                else:
                    result += '1' + c

        return result


if __name__ == '__main__':
    stringCompressionIII = StringCompressionIII()
    print(stringCompressionIII.compressedString("aaaaaaaaaaaaaabb"))