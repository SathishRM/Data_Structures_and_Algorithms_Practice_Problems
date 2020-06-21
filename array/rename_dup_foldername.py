class Solution:
    def getFolderNames(self, names: list([str])) -> list([str]):
        ans = list()
        ans_dict = dict()
        for name in names:
            if name not in ans_dict:
                ans_dict[name] = 0
            else:
                k = ans_dict[name] + 1
                while name + '(' + str(k) + ')' in ans_dict:
                    k += 1
                ans_dict[name] = k
                name = name + '(' + str(k) + ')'
                ans_dict[name] = 0
            ans.append(name)

        return ans
s = Solution()
print(s.getFolderNames(["kaido","kaido(1)","kaido","kaido(1)"]))
