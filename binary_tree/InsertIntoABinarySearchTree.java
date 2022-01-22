/*
701. Insert into a Binary Search Tree

You are given the root node of a binary search tree (BST) and a value to insert into the tree.
Return the root node of the BST after the insertion.
It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion,
as long as the tree remains a BST after insertion. You can return any of them.

Example 1:
Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
Explanation: Another accepted tree is:

Example 2:
Input: root = [40,20,60,10,30,50,70], val = 25
Output: [40,20,60,10,30,50,70,null,null,25]

Example 3:
Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
Output: [4,2,7,1,3,5]

Constraints:
The number of nodes in the tree will be in the range [0, 104].
-108 <= Node.val <= 108
All the values Node.val are unique.
-108 <= val <= 108
It's guaranteed that val does not exist in the original BST.
 */
package tree;

import java.util.List;
import tree.BinaryTreeTraversal;

public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7,
                new TreeNode(5, new TreeNode(2, new TreeNode(1), new TreeNode(3)),null),
                        new TreeNode(9));

        TreeNode result = insertIntoBST(root,4);
        //Print the result in-order
        BinaryTreeTraversal.inorderTraversal(result).forEach(System.out::println);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode orgRoot = root;
        boolean setNode = false;
        if (root == null) return new TreeNode(val);
        while (root != null && ! setNode) {
            if (val > root.val) {
                if (root.right != null) root = root.right;
                else {
                    root.right = new TreeNode(val);
                    setNode = true;
                }
            }
            else if (val < root.val) {
                if (root.left != null) root = root.left;
                else {
                    root.left = new TreeNode(val);
                    setNode = true;
                }
            }
        }
        return orgRoot;
    }
}
