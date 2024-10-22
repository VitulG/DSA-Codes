import java.util.*;

public class KthLargestSumInABinaryTree {

    public static long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levelSum = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            long currLevelSum = 0;
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                currLevelSum += node.val;

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelSum.add(currLevelSum);
            level++;
        }

        if(k > level) {
            return -1L;
        }

        levelSum.sort(Collections.reverseOrder());

        return levelSum.get(k-1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);

        System.out.println(kthLargestLevelSum(root, 2));
    }
}
