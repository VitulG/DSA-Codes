package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class PathSum {

    /*
        Approach: - 1. Traverse the whole node in the tree when we reach leaf node we have to check if the sum
                            equals to a target sum if yes then return true else return false;
                       TC -> O(n)
                       SC -> O(h)
     */

    public static boolean isPathExists(TreeNode node, int currentSum, int targetSum) {
        if(node == null) {
            return false;
        }

        currentSum += node.val;

        if(node.left == null && node.right == null) {
            return currentSum == targetSum;
        }

        return isPathExists(node.left, currentSum, targetSum) ||
                isPathExists(node.right, currentSum, targetSum);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        return isPathExists(root, 0, targetSum);
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
        root.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(root, 22));
    }
}
