package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class RootToLeafPathsSum {

    /*
        Approach:
            - Use DFS to traverse from root to all leaf nodes.
            - At each step, build the number represented by the current path by shifting currentSum left (×10) and adding node.val.
            - When a leaf node is reached, add the formed number to the total sum.

        Time Complexity  : O(n) — each node is visited once
        Space Complexity : O(h) — call stack height (h = height of tree)
    */

    public static void getTreePathsSum(TreeNode node, int currentSum, int[] totalSum) {
        if(node == null) {
            return;
        }

        currentSum = (currentSum*10) + node.val;

        if(node.left == null && node.right == null) {
            totalSum[0] += currentSum;
        }

        getTreePathsSum(node.left, currentSum, totalSum);
        getTreePathsSum(node.right, currentSum, totalSum);
    }

    public static int treePathsSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] totalSum = {0};
        getTreePathsSum(root, 0, totalSum);

        return totalSum[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.right = new TreeNode(4);

        System.out.println(treePathsSum(root));
    }
}
