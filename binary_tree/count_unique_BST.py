def numTrees(n: int) -> int:
    if n < 2:
        return 1
    else:
        no_trees = [0 for _ in range(n+1)]
        no_trees[0],no_trees[1] = 1,1
        for i in range(2, n+1):
            for j in range(i):
                no_trees[i] += no_trees[j] * no_trees[i-j-1]

        return no_trees[n]

print(numTrees(5))
