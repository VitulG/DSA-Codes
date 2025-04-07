package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_search_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class MinimumAbsoluteDifferenceInBST {

    // brute force approach is to get inorder traversal and iterate on the list and get the min diff
    // TC -> O(2N), SC -> O(N)

    public static void inorderBSTTraversal(TreeNode node, TreeNode[] parent, int[] minDiff) {
        if(node == null){
            return;
        }
        inorderBSTTraversal(node.left, parent, minDiff);

        if(parent[0] != null) {
            minDiff[0] = Math.min(minDiff[0], Math.abs(parent[0].val - node.val));
        }
        parent[0] = node;

        inorderBSTTraversal(node.right, parent, minDiff);
    }

    public static int getMinimumDifference(TreeNode root) {
        int[] minDiff = {Integer.MAX_VALUE};
        TreeNode[] prev = {null};

        inorderBSTTraversal(root, prev, minDiff);

        // TC - > O(N), SC -> O(1)

        return minDiff[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(236);
        root.left = new TreeNode(104);
        root.right = new TreeNode(701);
        root.left.right = new TreeNode(227);
        root.right.right = new TreeNode(911);

        System.out.println(getMinimumDifference(root));
    }
}
