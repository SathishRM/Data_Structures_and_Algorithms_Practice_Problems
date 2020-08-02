class Solution:
    def avoidFlood(self, rains: list([int])) -> list([int]):
        avoid_flood = [1 for _ in rains]
        full_lake = dict()
        no_rains = list()

        for i in range(len(rains)):
            if rains[i] == 0:
                no_rains.append(i)
            else:
                if rains[i] in full_lake:
                    if no_rains and full_lake[rains[i]] < no_rains[-1]:
                        for r_idx in range(len(no_rains)):
                            if full_lake[rains[i]] < no_rains[r_idx]:
                                earliest_empty_idx = no_rains[r_idx]
                                break
                        avoid_flood[earliest_empty_idx] = rains[i]
                        avoid_flood[i] = -1
                        no_rains.pop(r_idx)
                        full_lake[rains[i]] = i
                    else:
                        return list()
                else:
                    full_lake[rains[i]] = i
                    avoid_flood[i] = -1

        return avoid_flood

# rains = [69,0,0,0,69]
# rains = [10,20,20]
rains = [1,2,0,0,2,1]
s = Solution()
print(s.avoidFlood(rains))
