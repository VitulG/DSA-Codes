package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class InvertBinaryTree {

    /*
        Approach: -
                    - To solve this question, we use **postorder traversal** (left → right → root).
                    - The idea is to recursively reach each node's children.
                    - After reaching a node (typically a leaf or internal node), we swap its left and right children.
                    - This effectively mirrors the entire binary tree.

                    Time Complexity:  O(n) — each node is visited exactly once.
                    Space Complexity: O(h) — due to recursion stack, where h is the height of the tree.
     */

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode leftSub = invertTree(root.left);
        TreeNode rightSub = invertTree(root.right);

        root.left = rightSub;
        root.right = leftSub;

        return root;
    }

    public static void main(String[] args) {

    }
}
