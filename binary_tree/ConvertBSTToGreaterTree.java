/*
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original
 BST is changed to the original key plus sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 */
package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ConvertBSTToGreaterTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4)),
                new TreeNode(3, new TreeNode(5), null));

        TreeNode rootGT = convertBST(root);
        System.out.println(rootGT.val + ", " + rootGT.left.val + " , " + rootGT.right.val);
    }

    public static TreeNode convertBST(TreeNode root) {
        int acc = 0;
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> treeStack = new ArrayDeque<>();
        TreeNode curNode = root;
        while ( curNode != null || !treeStack.isEmpty()) {
            while(curNode != null) {
                treeStack.push(curNode);
                curNode = curNode.right;
            }
            curNode = treeStack.pop();
            acc += curNode.val;

            curNode.val = acc;
            curNode = curNode.left;
        }
        return root;
    }
}
