/*
Given the root of a binary tree, then value v and depth d,
you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1,
create two tree nodes with value v as N's left subtree root and right subtree root.
And N's original left subtree should be the left subtree of the new left subtree root,
its original right subtree should be the right subtree of the new right subtree root.
If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as
the new root of the whole original tree, and the original tree is the new root's left subtree.

Input:
A binary tree as following:
       4
     /   \
    2     6
   / \   /
  3   1 5

v = 1

d = 2

Output:
       4
      / \
     1   1
    /     \
   2       6
  / \     /
 3   1   5
 */
package tree;

public class AddOneRowToTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode newRoot = addOneRow(root, 5, 1);
        System.out.println("new root-" + newRoot.val + " left-" + newRoot.left.val);

    }

    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode tmpNode = root;
            root = new TreeNode(v, tmpNode, null);
            // return root;
        }
        else addOneRowHelper(root, v, d, 1);
        // System.out.println(root);
        return root;
    }

    public static void addOneRowHelper(TreeNode root, int v, int d, int level) {

        if (level == d-1) {
            TreeNode tmpNode = root.left;
            if (tmpNode != null) root.left = new TreeNode (v, tmpNode, null);
            else root.left = new TreeNode (v, null, null);
            tmpNode = root.right;
            if (tmpNode != null) root.right = new TreeNode (v, null, tmpNode);
            else root.right = new TreeNode (v, null, null);

            return;
        }
        if (root.left != null) addOneRowHelper(root.left, v, d, level+1);
        if (root.right != null) addOneRowHelper(root.right, v, d, level+1);
        return;
    }
}
