package tree;

import java.util.*;

import static java.util.Collections.sort;

public class VerticalOrderTraversalBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4)),
                new TreeNode(3, new TreeNode(5), null));

        List<List<Integer>> result = verticalTraversal(root);
        result.forEach(System.out::println);

    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        TreeMap<Integer, ArrayList<Integer>> nodeMapping = new TreeMap<>();
        int x = 0;
        verticalTraversalHelper(root, x, nodeMapping);
        //nodeMapping.forEach((k,v) -> System.out.println(k + " - " + v));
        nodeMapping.forEach((k,v) -> {
            sort(v);
            result.add(v);
        });
        return result;

    }

    public static void verticalTraversalHelper(TreeNode root, int x, TreeMap<Integer,ArrayList<Integer>> nodeMapping) {
        if (root != null) {
            ArrayList<Integer> valuesList =  nodeMapping.getOrDefault(x, new ArrayList<>());
            valuesList.add(root.val);
            nodeMapping.put(x, valuesList);

            verticalTraversalHelper(root.left, x-1, nodeMapping);
            verticalTraversalHelper(root.right, x+1, nodeMapping);
        }
    }
}
