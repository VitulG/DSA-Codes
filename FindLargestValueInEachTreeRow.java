import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
    public static List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        List<Integer> levelsLargestValue = new ArrayList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            int largestValue = Integer.MIN_VALUE;
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                largestValue = Math.max(largestValue, node.val);

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelsLargestValue.add(largestValue);
        }
        return levelsLargestValue;
    }

    public static void main(String[] args) {

    }
}
