class Solution:
    def xorOperation(self, n: int, start: int) -> int:
        nums = [ start + 2 * i for i in range(n)]
        result = nums[0]

        for i in range(1,n):
            result = result ^ nums[i]

        return result

s = Solution()
print(s.xorOperation(5, 2))
