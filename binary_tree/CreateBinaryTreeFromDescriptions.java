/*
2196. Create Binary Tree From Descriptions
You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti]
indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

If isLefti == 1, then childi is the left child of parenti.
If isLefti == 0, then childi is the right child of parenti.
Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.

Example 1:
      50
  20       80
15  17   19
Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
Output: [50,20,80,15,17,19]
Explanation: The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.

Example 2:
Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
Output: [1,2,null,null,3,4]
Explanation: The root node is the node with value 1 since it has no parent.
The resulting binary tree is shown in the diagram.


Constraints:
1 <= descriptions.length <= 104
descriptions[i].length == 3
1 <= parenti, childi <= 105
0 <= isLefti <= 1
The binary tree described by descriptions is valid.
 */
package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDescriptions {
    public static void main(String[] args) {
        int[][] descriptions = new int[][] {
                {20,15,1},
                {20,17,0},
                {50,20,1},
                {50,80,0},
                {80,19,1}
        };
        TreeNode result = createBinaryTree(descriptions);
        //Print the result in-order
        BinaryTreeTraversal.inorderTraversal(result).forEach(System.out::println);

    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> childs = new HashSet<>();
        TreeNode parentNode, childNode;
        TreeNode root=null;
        int parent, child, isLeft;
        for (int[] description : descriptions) {
            parent = description[0];
            child = description[1];
            isLeft = description[2];

            // construct parent node
            if (nodes.containsKey(parent)) parentNode = nodes.get(parent);
            else parentNode = new TreeNode(parent);
            // construct child node
            if (nodes.containsKey(child)) childNode = nodes.get(child);
            else childNode = new TreeNode(child);
            // attach child node
            if (isLeft == 1) parentNode.left = childNode;
            else parentNode.right = childNode;

            nodes.put(parent, parentNode);
            nodes.put(child, childNode);

            childs.add(child);
        }
        for (Integer val : nodes.keySet()) {
            if(!childs.contains(val)) {
                root = nodes.get(val);
                break;
            }
        }
        return root;
    }
}
