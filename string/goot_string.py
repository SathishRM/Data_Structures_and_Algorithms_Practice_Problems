
def makeGood(self, s: str) -> str:
    '''
    Given a string s of lower and upper case English letters.
    A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
    0 <= i <= s.length - 2
    s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
    To make the string good, you can choose two adjacent characters that make the string bad and remove them.
    You can keep doing this until the string becomes good.
    Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
    Input: s = "leEeetcode"
    Output: "leetcode"
    '''
    result = ''
    i = 0
    str_len = len(s)
    if str_len > 1:
        while i < str_len-1:
            if abs(ord(s[i]) - ord(s[i+1])) == 32:
                i += 2
                result = self.makeGood(result+s[i:])
                break
            else:
                result += s[i]
                i += 1

        else:
            if s and abs(ord(s[-1]) - ord(s[-2])) != 32:
                result += s[-1]
    else:
        result = s

    return result
