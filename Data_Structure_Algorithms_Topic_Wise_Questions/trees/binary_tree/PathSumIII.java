package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class PathSumIII {

    /*
        Approach: - We have to make root, its left and right child as well and call for how many paths will be there
                        for current paths which make that target sum.
                    TC -> O(n^2)
                    SC -> O(h)
     */

    public static int getPaths(TreeNode node, int currentSum, int targetSum) {
        if(node == null) {
            return 0;
        }

        currentSum += node.val;

        int paths = 0;

        if(currentSum == targetSum) {
            paths++;
        }

        paths += getPaths(node.left, currentSum, targetSum);
        paths += getPaths(node.right, currentSum, targetSum);

        return paths;
    }

    public static int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }

        return getPaths(root, 0, targetSum) + pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);

        System.out.println(pathSum(root, 8));
    }
}
