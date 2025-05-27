package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_search_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

import java.util.ArrayList;

public class PrintLeafNodesFromPreorderTraversalOfBST {

    /*
        Approach:
            - Given preorder traversal of a BST, we need to extract all the leaf nodes.
            - We'll construct the BST implicitly during traversal using BST properties:

                i. Any value in the left subtree must be < current node.
                ii. Any value in the right subtree must be > current node.
                iii. For left child recursion, we pass the current node’s value as the new upper bound.
                iv. For right child recursion, we keep the existing upper bound.
                v. A node is a leaf if both its left and right recursive calls return null — we collect such nodes.

                        TC -> O(n) // no. of nodes
                        SC -> O(n) // recursion stack + list
     */

    public static ArrayList<Integer> leafNodes(int[] preorder) {
        if(preorder.length == 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> leafNodes = new ArrayList<>();
        int[] idx = {0};
        constructBST(preorder, idx, Integer.MAX_VALUE, leafNodes);

        return leafNodes;
    }

    public static TreeNode constructBST(int[] preorder, int[] idx, int upperBound, ArrayList<Integer> leafNodes) {
        if(idx[0] >= preorder.length || preorder[idx[0]] > upperBound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx[0]++]);
        root.left = constructBST(preorder, idx, root.val, leafNodes);
        root.right = constructBST(preorder, idx, upperBound, leafNodes);

        if(root.left == null && root.right == null) {
            leafNodes.add(root.val);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(leafNodes(new int[]{4, 2, 1, 3, 6, 5}));
    }
}
