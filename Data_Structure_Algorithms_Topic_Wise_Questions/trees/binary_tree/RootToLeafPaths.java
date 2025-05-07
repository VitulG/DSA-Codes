package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

import java.util.ArrayList;

public class RootToLeafPaths {

    public static void generateAllPossiblePaths(TreeNode node, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> paths) {
        if(node == null) {
            return;
        }
        currentPath.add(node.val);

        if(node.left == null && node.right == null) {
            paths.add(new ArrayList<>(currentPath));
        }else {
            generateAllPossiblePaths(node.left, currentPath, paths);
            generateAllPossiblePaths(node.right, currentPath, paths);
        }
        currentPath.remove(currentPath.size()-1);

    }

    public static ArrayList<ArrayList<Integer>> paths(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        generateAllPossiblePaths(root, new ArrayList<>(), paths);

        return paths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(paths(root));
    }
}
