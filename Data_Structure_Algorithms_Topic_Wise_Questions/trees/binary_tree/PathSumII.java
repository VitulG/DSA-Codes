package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    /*
        Approach: - We will use DFS over here we can take every node in our current list if it meets the target
                        sum so we can add that list in to our ans list and so on and make sure we backtrack.
                    TC -> O(n)
                    SC -> O(h)
     */

    public static void getTargetSumPaths(TreeNode node, int currSum, int targetSum, List<Integer> currentPath,
                                         List<List<Integer>> paths) {
        if(node == null) {
            return;
        }
        currSum += node.val;
        currentPath.add(node.val);

        if(node.left == null && node.right == null) {
            if(currSum == targetSum) {
                paths.add(new ArrayList<>(currentPath));
            }
        }

        getTargetSumPaths(node.left, currSum, targetSum, currentPath, paths);
        getTargetSumPaths(node.right, currSum, targetSum, currentPath, paths);

        currentPath.remove(currentPath.size()-1);

    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> paths = new ArrayList<>();

        getTargetSumPaths(root, 0, targetSum, new ArrayList<>(), paths);

        return paths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
    }
}
