'''
1957. Delete Characters to Make Fancy String
A fancy string is a string where no three consecutive characters are equal.
Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.

Example 1:
Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".

Example 2:
Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".

Example 3:
Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".

Constraints:
1 <= s.length <= 105
s consists only of lowercase English letters.
'''


class DeleteCharactersToMakeFancyString:
    def makeFancyString(self, s: str) -> str:
        s += '-'
        result = ''
        p = ''
        count = 1
        for c in s:
            if c == p:
                count += 1
            else:
                if count >= 3:
                    result += p * 2
                else:
                    result += p * count
                count = 1
            p = c

        return result

    def makeFancyStringFirstApproach(self, s: str) -> str:
        for i in range(1,len(s)):
            j = i
            while j < len(s) and s[j-1] == s[j]:
                j+=1

            if j - i >= 2:
                s = s[:i+1] + s[j:]
                i = j
            i+=1
        return s


if __name__ == '__main__':
    deleteCharactersToMakeFancyString = DeleteCharactersToMakeFancyString()
    print(deleteCharactersToMakeFancyString.makeFancyString("aaabaaaa"))