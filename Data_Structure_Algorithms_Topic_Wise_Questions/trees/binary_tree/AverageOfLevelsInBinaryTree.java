package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    /*
        Approach: - Use BFS of a binary tree to get the sum of the current level node and take the avg of them.

                    TC -> O(n)
                    SC -> O(n)
     */

    public static List<Double> averageOfLevels(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Double> ans = new ArrayList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;

            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(sum / size);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(averageOfLevels(root));
    }
}
