package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_search_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class ValidateBinarySearchTree {

    /*
        ✅ Approach:
            To validate if a binary tree is a Binary Search Tree (BST),
            we perform a recursive traversal from the root node and maintain a valid range `(min, max)` for each node.

            For a valid BST:
                - Every node’s value must lie strictly between its allowed `min` and `max` range.
                - For the left child → the `max` becomes the current node’s value.
                - For the right child → the `min` becomes the current node’s value.

            At each node:
                - If `node.val <= min` or `node.val >= max`, return false.
                - Otherwise, continue checking the left and right subtrees recursively.

            If we reach all null nodes without violating the conditions, the tree is a valid BST.

            ✅ Time Complexity:
                - O(n) — we visit every node once.

            ✅ Space Complexity:
                - O(h) — height of the tree (due to recursion stack)
                - O(log n) for balanced tree
                - O(n) for skewed tree
     */

    public static boolean validateBST(TreeNode node, int min, int max) {
        if(node == null) {
            return true;
        }

        if(node.val >= max || node.val <= min) {
            return false;
        }

        boolean leftSub = validateBST(node.left, min, node.val);
        boolean rightSub = validateBST(node.right, node.val, max);

        return leftSub && rightSub;
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {

    }
}
