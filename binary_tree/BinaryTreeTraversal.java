package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }


public class BinaryTreeTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4)),
                new TreeNode(3, new TreeNode(5), null));
        List<Integer> result = preorderTraversal(root);
        System.out.println("Preorder traversal");
        result.forEach(System.out::println);

        result = inorderTraversal(root);
        System.out.println("Inorder traversal");
        result.forEach(System.out::println);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> treeStack = new ArrayDeque<>();
        if(root != null) {
            treeStack.push(root);
            while (!treeStack.isEmpty()) {
                TreeNode curNode = treeStack.pop();
                result.add(curNode.val);

                if (curNode.right != null) treeStack.push(curNode.right);
                if (curNode.left != null) treeStack.push(curNode.left);
            }
        }
        return result;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> treeStack = new ArrayDeque<>();
        TreeNode curNode = root;
        while ( curNode != null || !treeStack.isEmpty()) {
            while(curNode != null) {
                treeStack.push(curNode);
                curNode = curNode.left;
            }
            curNode = treeStack.pop();
            result.add(curNode.val);
            curNode = curNode.right;
        }

        return result;

    }

}


