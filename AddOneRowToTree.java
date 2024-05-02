import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        if(depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        int currLevel = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(currLevel == depth-1) {
                    TreeNode leftNode = node.left;
                    TreeNode rightNode = node.right;

                    node.left = new TreeNode(val);
                    node.left.left = leftNode;

                    node.right = new TreeNode(val);
                    node.right.right = rightNode;
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }

            }
            currLevel++;
        }
        return root;

    }

    public static void main(String[] args) {
        
    }
    
}
