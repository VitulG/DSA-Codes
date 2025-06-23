package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class MinimumDepthOfBinaryTree {

    /*
        Approach:
            - Traverse the binary tree recursively to compute its minimum depth.
            - In a normal (non-skewed) tree, we take the minimum of left and right subtree depths.
            - In a skewed tree (either left or right child is null), we must return the non-null side’s depth,
              since the path to the leaf must go through the existing child.

            Time Complexity:  O(n)   // where n is the number of nodes
            Space Complexity: O(h)   // where h is the height of the tree due to recursion stack
    */


    public static int getMinimumDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }

        if(node.left == null) {
            return getMinimumDepth(node.right) + 1;
        }

        if(node.right == null) {
            return getMinimumDepth(node.left) + 1;
        }

        return Math.min(getMinimumDepth(node.left), getMinimumDepth(node.right)) + 1;
    }

    public static int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return getMinimumDepth(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = null;
        root.right = new TreeNode(20);
        root.right.left = null;
        root.right.right = new TreeNode(7);

        System.out.println(minDepth(root));
    }
}
