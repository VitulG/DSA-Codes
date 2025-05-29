package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class SymmetricTree {

    /*
        Approach: -
            - Use DFS to recursively compare the left and right subtrees.
            - At each step, the left subtree's left child should match the right subtree's right child, and vice versa.
            - Base case:
                - If both nodes are null, return true.
                - If only one is null or their values differ, return false.
            - Recurse for:
                - left.left vs right.right
                - left.right vs right.left

            Time Complexity: O(n)  -> Each node is visited once.
            Space Complexity: O(h) -> h is the height of the tree (due to recursion stack).
     */

    public static boolean isSymmetricTree(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }

        if((left != null && right == null) || (left == null && right != null)) {
            return false;
        }

        if(left.val != right.val) {
            return false;
        }
        return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricTree(root.left, root.right);
    }

    public static void main(String[] args) {

    }
}
