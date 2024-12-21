import java.util.ArrayDeque;
import java.util.Queue;

public class CousinsInBinaryTreeI {

    public static boolean isCousin(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int childCount = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                int parentCount = 0;

                if(node.left != null) {
                    if(node.left.val == x || node.right.val == y) {
                        childCount++;
                        parentCount++;
                    }
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    if(node.right.val == x || node.right.val == y) {
                        childCount++;
                        parentCount++;
                    }
                    queue.offer(node.right);
                }

                if(parentCount == 2) {
                    return false;
                }
            }
            if(childCount == 2) {
                return true;
            }

            if(childCount == 1) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
