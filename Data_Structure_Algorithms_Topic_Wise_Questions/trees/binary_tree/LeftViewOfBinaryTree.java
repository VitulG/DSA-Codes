package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {

    /*
        Approach the key here to use Level order traversal by check the first element as it is a left most element and
                store it in the list and return that left Views list.
            TC -> O(height of the tree), SC -> O(n) // since I need a queue to traverse level by level
     */

    public static ArrayList<Integer> leftView(TreeNode root) {
        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        ArrayList<Integer> leftViews = new ArrayList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();

                if(i == 0) {
                    leftViews.add(node.val);
                }


                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return leftViews;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        System.out.println(leftView(root));
    }
}
