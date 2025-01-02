"""
2559. Count Vowel Strings in Ranges

You are given a 0-indexed array of strings words and a 2D array of integers queries.
Each query queries[i] = [li, ri] asks us to find the number of strings present in
the range li to ri (both inclusive) of words that start and end with a vowel.

Return an array ans of size queries.length, where ans[i] is the answer to the ith query.
Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.

Example 1:
Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
Output: [2,3,0]
Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
The answer to the query [0,2] is 2 (strings "aba" and "ece").
to query [1,4] is 3 (strings "ece", "aa", "e").
to query [1,1] is 0.
We return [2,3,0].

Example 2:
Input: words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
Output: [3,2,1]
Explanation: Every string satisfies the conditions, so we return [3,2,1].

Constraints:
1 <= words.length <= 105
1 <= words[i].length <= 40
words[i] consists only of lowercase English letters.
sum(words[i].length) <= 3 * 105
1 <= queries.length <= 105
0 <= li <= ri < words.length
"""


class CountVowelStringsInRanges:
    def vowelStrings(self, words: list[str], queries: list[list[int]]) -> list[int]:
        vowSet = {'a','e','i','o','u'}
        vowCount = [0 for _ in range(len(words))]
        result = []
        for i,word in enumerate(words):
            if word[0] in vowSet and word[-1] in vowSet:
                vowCount[i] = vowCount[i-1] + 1
            else:
                vowCount[i] = vowCount[i-1]

        for query in queries:
            cur = vowCount[query[1]] if query[0] == 0 else vowCount[query[1]] - vowCount[query[0]-1]
            result.append(cur)

        # Brute force approach
        # vowCount = { i: 1 if w[0] in vowSet and w[-1] in vowSet else 0 for i,w in enumerate(words) }
        # for query in queries:
        #     cur = 0
        #     for i in range(query[0],query[1]+1):
        #         if vowCount[i] == 1:
        #             cur += 1
        #     result.append(cur)

        return result


if __name__ == '__main__':
    countVowelStringsInRanges = CountVowelStringsInRanges()
    print(
        countVowelStringsInRanges.vowelStrings(["aba","bcb","ece","aa","e"], [[0,2],[1,4],[1,1]])
    )