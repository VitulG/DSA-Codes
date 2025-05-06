package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_search_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    /*
        Approach:
        - Use binary search to select the middle element as root.
        - Recursively do the same for left and right halves of the array.
        - This ensures the tree is balanced (height difference between subtrees is minimal).

          Time Complexity: O(n) -> every element is visited once.
          Space Complexity: O(log n) -> due to recursion stack in a balanced tree (height of a tree).
     */

    public static TreeNode constructBST(int[] nums, int low, int high) {
        if(low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = constructBST(nums, low, mid-1);
        root.right = constructBST(nums, mid+1, high);

        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }

        return constructBST(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {

    }
}
