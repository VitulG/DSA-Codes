package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class MaximumDepthOfBinaryTree {

    public static int getMaximumTreeHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftSubHeight = getMaximumTreeHeight(node.left);
        int rightSubHeight = getMaximumTreeHeight(node.right);

        return Math.max(leftSubHeight, rightSubHeight) + 1;
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return getMaximumTreeHeight(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(getMaximumTreeHeight(root));
    }
}
