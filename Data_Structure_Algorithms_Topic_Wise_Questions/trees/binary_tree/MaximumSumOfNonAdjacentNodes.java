package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfNonAdjacentNodes {

    public static int getMaximumSum(TreeNode node, Map<TreeNode, Integer> dp) {
        if(node == null) {
            return 0;
        }

        if(dp.containsKey(node)) {
            return dp.get(node);
        }

        int notTake = getMaximumSum(node.left, dp) + getMaximumSum(node.right, dp);

        int take = 0;
        take += node.val;

        if(node.left != null) {
            take += getMaximumSum(node.left.left, dp);
            take += getMaximumSum(node.left.right, dp);
        }

        if(node.right != null) {
            take += getMaximumSum(node.right.left, dp);
            take += getMaximumSum(node.right.right, dp);
        }

        int maxSum = Math.max(take, notTake);
        dp.put(node, maxSum);

        return maxSum;
    }

    public static int getMaxSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Map<TreeNode, Integer> dp = new HashMap<>();
        return getMaximumSum(root, dp);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(getMaxSum(root));
    }
}
