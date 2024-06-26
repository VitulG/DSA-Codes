import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {

    public static void inorderTraversal(TreeNode node, List<Integer> processBst) {
        if(node == null) {
            return;
        }
        inorderTraversal(node.left, processBst);
        processBst.add(node.val);
        inorderTraversal(node.right, processBst);
    }

    public static TreeNode constructBalancedBST(List<Integer> nodes, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nodes.get(mid));
        node.left = constructBalancedBST(nodes, start, mid-1);
        node.right = constructBalancedBST(nodes, mid+1, end);
        return node;
    }

    public static TreeNode balenceBST(TreeNode root) {
        if(root == null) {
            return null;
        }

        List<Integer> processBst = new ArrayList<Integer>();
        inorderTraversal(root, processBst);
        return constructBalancedBST(processBst, 0, processBst.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        balenceBST(root);
    }
    
}
