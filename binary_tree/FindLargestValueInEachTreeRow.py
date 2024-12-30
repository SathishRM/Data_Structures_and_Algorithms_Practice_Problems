"""
515. Find Largest Value in Each Tree Row
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
Example 1:
       1
     /  \
    3    2
  /  \    \
 5    3    9
Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]

Example 2:
Input: root = [1,2,3]
Output: [1,3]

Constraints:
The number of nodes in the tree will be in the range [0, 104].
-231 <= Node.val <= 231 - 1

"""
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class LargestValueInEachTreeRow:
    def __init__(self):
        self.result = []

    def largestValues(self, root: Optional[TreeNode]) -> list[int]:
        self.largestValuesHelper(root, 0)
        return self.result

    def largestValuesHelper(self, root: Optional[TreeNode], level: int) -> None:
        if root:
            if len(self.result) > level:
                if self.result[level] < root.val:
                    self.result[level] = root.val
            else:
                self.result.append(root.val)

            self.largestValuesHelper(root.left, level + 1)
            self.largestValuesHelper(root.right, level + 1)


if __name__ == '__main__':
    root = TreeNode(1, TreeNode(3, TreeNode(5), TreeNode(3)), TreeNode(2, None, TreeNode(9)))
    findLargestValues = LargestValueInEachTreeRow()
    print(findLargestValues.largestValues(root))
