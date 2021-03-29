/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Note: The range of node's value is in the range of 32-bit signed integer.

Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */
package tree;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(averageOfLevels(root).toString());

    }

    public static List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> levelsValue = new ArrayList<ArrayList<Integer>>();
        levelWiseValue(root, levelsValue, 0);

        for(int i=0;i<levelsValue.size();i++) {
            ArrayList<Integer> values = levelsValue.get(i);
            double value = values.stream().mapToDouble(v -> v).average().getAsDouble();
            result.add(value);
        }
        return result;
    }

    public static void levelWiseValue(TreeNode node, ArrayList<ArrayList<Integer>> levelsValue, int level) {
        ArrayList<Integer> values;
        if (levelsValue.size()-1 >= level) {
            levelsValue.get(level).add(node.val);
        }
        else {
            levelsValue.add(new ArrayList<Integer>() {{ add(node.val);}});
        }

        if (node.left != null) levelWiseValue(node.left, levelsValue, level+1);
        if (node.right != null) levelWiseValue(node.right, levelsValue, level+1);
    }
}
