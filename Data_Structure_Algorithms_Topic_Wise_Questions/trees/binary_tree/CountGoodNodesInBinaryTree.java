package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class CountGoodNodesInBinaryTree {

    /*
        Approach here is to use Pre order traversal while I am currently at a node X, so I have to keep track of the
            maximum value nodes so that if I get a node with < max node value so I can ignore that node and else
            I can keep count those good nodes.

            TC -> O(n)
            SC -> O(height of the tree)
     */

    public static void preorder(TreeNode node, int max, int[] goodNodes) {
        if(node == null) {
            return;
        }

        if(node.val >= max) {
            goodNodes[0]++;
            max = node.val;
        }
        preorder(node.left, max, goodNodes);
        preorder(node.right, max, goodNodes);
    }

    public static int goodNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int[] goodNodes = {0};
        preorder(root, root.val, goodNodes);

        return goodNodes[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(goodNodes(root));
    }
}
