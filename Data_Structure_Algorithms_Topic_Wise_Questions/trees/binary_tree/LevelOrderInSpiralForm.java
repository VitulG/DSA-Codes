package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrderInSpiralForm {

    public static ArrayList<Integer> findSpiral(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        boolean isLeft = false;

        ArrayList<Integer> spiralOrder = new ArrayList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();

            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            if(isLeft) {
                spiralOrder.addAll(currentLevel);
            }else {
                for(int i=currentLevel.size()-1; i>=0; i--) {
                    spiralOrder.add(currentLevel.get(i));
                }
            }
            isLeft = !isLeft;
        }
        return spiralOrder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(findSpiral(root));
    }
}
