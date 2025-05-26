package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class SameTree {

    /*
        Approach:
            - Recursively traverse both trees and compare corresponding nodes.
                1. If both current nodes are null → return true (both subtrees are empty).
                2. If one is null and the other is not → return false (structure mismatch).
                3. If the values of the current nodes do not match → return false.
                4. Otherwise, recursively check left and right subtrees.

                Time Complexity: O(n)
                    - We visit each node exactly once where n is the total number of nodes.

                Space Complexity: O(h)
                    - h is the height of the tree.
                    - Due to recursion stack in worst case (O(n) in skewed tree, O(log n) in balanced).
     */

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if((p != null && q == null) || (p == null && q != null)) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

    }
}
