/*
700. Search in a Binary Search Tree

You are given the root of a binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
If such a node does not exist, return null.

Example 1:
Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]

Example 2:
Input: root = [4,2,7,1,3], val = 5
Output: []

Constraints:
The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107
 */
package tree;

public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7,
                new TreeNode(5, new TreeNode(2, new TreeNode(1), new TreeNode(3)),null),
                new TreeNode(9));
        TreeNode result = searchBST(root,10);
        //Print the result in-order
        BinaryTreeTraversal.inorderTraversal(result).forEach(System.out::println);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) return root;
            else if (val > root.val) root = root.right;
            else root = root.left;
        }
        return null;
    }
}
