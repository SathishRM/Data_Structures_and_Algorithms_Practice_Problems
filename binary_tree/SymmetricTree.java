/*
101. Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 */
package tree;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4)),
                new TreeNode(3, new TreeNode(5), null));
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 != null && root2 != null && root1.val == root2.val)
            return isSymmetric(root1.left,root2.right) && isSymmetric(root1.right, root2.left);
        else return false;

    }
}
