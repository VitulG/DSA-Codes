
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    public static void postorderTraversalAlgo(TreeNode node, List<Integer> nodes) {
        if(node == null) {
            return;
        }
        postorderTraversalAlgo(node.left, nodes);
        postorderTraversalAlgo(node.right, nodes);
        nodes.add(node.val);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> nodes = new ArrayList<>();
        postorderTraversalAlgo(root, nodes);
        return nodes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(postorderTraversal(null));
    }
    
}
