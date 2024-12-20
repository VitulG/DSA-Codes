import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ReverseOddLevelsOfBinaryTree {

    public static TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int level = 0;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();

            for(int i=0; i<levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevelNodes.add(node);

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            if(level%2 != 0) {
                int left = 0;
                int right = currentLevelNodes.size()-1;

                while(left < right) {
                    int temp = currentLevelNodes.get(left).val;
                    currentLevelNodes.get(left).val = currentLevelNodes.get(right).val;
                    currentLevelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            level++;
        }
        return root;
    }

    public static void getPreorder(TreeNode root) {
        TreeNode curr = root;

        while(curr != null) {
            if(curr.left == null) {
                System.out.print(curr.val+" ");
                curr = curr.right;
            }else {
                TreeNode rightMostNode = getRightMostNode(curr.left, curr);
                if(rightMostNode.right == null) {
                    System.out.print(curr.val+" ");
                    rightMostNode.right = curr;
                    curr = curr.left;
                }else {
                    rightMostNode.right = null;
                    curr = curr.right;
                }
            }
        }
    }
    private static TreeNode getRightMostNode(TreeNode rightMostNode, TreeNode curr) {
        while(rightMostNode.right != null && rightMostNode.right != curr) {
            rightMostNode = rightMostNode.right;
        }
        return rightMostNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);

        TreeNode result = reverseOddLevels(root);
        getPreorder(result);
    }
}
