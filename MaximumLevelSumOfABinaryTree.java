import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public static int maxLevelSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;
        int maxLevel = 0;
        int maxSum = Integer.MIN_VALUE;

        while(!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;

            for(int i=0; i<size; i++) {
                TreeNode currNode = queue.poll();
                sum += currNode.val;

                if(currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if(currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }

            if(sum > maxSum) {
                maxSum = sum;
                maxLevel = level + 1;
            }
            level++;

        }
        return maxLevel;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        System.out.println(maxLevelSum(root));
    }
}
