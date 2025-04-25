package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsBinaryTreeHeap {

    // Approach I break this problem into two helper functions.
    // 1. will check if the tree follows HOP and
    // 2. will check if It's complete or not


    public static boolean checkHeapOrder(TreeNode node) {
        if(node == null) {
            return true;
        }

        boolean checkLeft = checkHeapOrder(node.left);
        boolean checkRight = checkHeapOrder(node.right);

        if(node.left != null && node.val < node.left.val) {
            return false;
        }

        if(node.right != null && node.val < node.right.val) {
            return false;
        }
        return checkLeft && checkRight;
    }

    public static boolean checkCompleteBinaryTree(TreeNode node) {
        if(node == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        boolean isChildNull = false;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                TreeNode currNode = queue.poll();
                if(currNode == null) {
                    isChildNull = true;
                }else {
                    if(isChildNull) {
                        return false;
                    }
                    queue.offer(currNode.left);
                    queue.offer(currNode.right);
                }
            }
        }
        return true;
    }

    public static boolean isHeap(TreeNode root) {
        if(root == null) {
            return true;
        }

        boolean isHeapOrderPropertySatisfied = checkHeapOrder(root);
        boolean isTreeComplete = checkCompleteBinaryTree(root);

        return isTreeComplete && isHeapOrderPropertySatisfied;
    }

    // Time Complexity -> O(2N);
    // Space Complexity -> O(2N);  I used Queue here to check if the tree is complete or not and the recursive stack.

    public static void main(String[] args) {
        TreeNode root = new TreeNode(97);
        root.left = new TreeNode(46);
        root.right = new TreeNode(37);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(31);

        System.out.println(isHeap(root));
    }
}
