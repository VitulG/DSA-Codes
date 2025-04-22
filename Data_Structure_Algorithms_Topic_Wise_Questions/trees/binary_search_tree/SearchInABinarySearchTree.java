package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_search_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class SearchInABinarySearchTree {

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }

        if(root.val == val) {
            return root;
        }

        TreeNode node;

        if(root.val < val) {
            node = searchBST(root.right, val);
        }else {
            node = searchBST(root.left, val);
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode subTree = searchBST(root, 2);

        System.out.println(subTree.val);
    }
}
