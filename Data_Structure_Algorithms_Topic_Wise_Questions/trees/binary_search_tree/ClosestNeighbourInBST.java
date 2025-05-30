package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_search_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class ClosestNeighbourInBST {

    /*
        Approach: -
            1. To Solve this question, we know BST is left.val < root.val < right.val
            2. We will check curr.val <= k if yes it means it could be the potential answer store curr.val and
                  move to the right side,
            3. else go to left child until current gets null.

            TC -> O(h)
            SC -> O(1)
     */

    public static int findMaxFork(TreeNode root, int k) {
        // code here.
        if(root == null) {
            return -1;
        }

        int closestGreatestNumber = -1;
        TreeNode curr = root;

        while(curr != null) {
            if(curr.val <= k) {
                closestGreatestNumber = curr.val;
                curr = curr.right;
            }else {
                curr = curr.left;
            }
        }
        return closestGreatestNumber;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(16);

        System.out.println(findMaxFork(root, 14));
    }
}
