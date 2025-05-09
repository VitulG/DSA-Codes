package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    /*
        Approach is here to use level order traversal of a binary tree if the ith node is last then it must be a
            right node so we can collect in our answer list level by level.
            TC -> O(n)
            SC -> O(n)
     */

    public static List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> rightSideNodes = new ArrayList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=1; i<=size; i++) {
                TreeNode currentNode = queue.poll();

                if(i == size) {
                    rightSideNodes.add(currentNode.val);
                }

                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return rightSideNodes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideView(root));
    }
}
