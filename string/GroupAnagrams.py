"""
49. Group Anagrams
Given an array of strings strs, group the  anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
"""


class StrAnagramGrouping:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        group = dict()
        for s in strs:
            # key = sum(map(ord,s))
            key = ''.join(sorted(s))
            val = group.get(key, list())
            val.append(s)
            group[key] = val

        return list(group.values())


if __name__ == '__main__':
    obj = StrAnagramGrouping()
    print(obj.groupAnagrams(["eat","tea","tan","ate","nat","bat"]))