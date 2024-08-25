public class BinarySearchTreeToGreaterSumTree {

    public static void reverseInOrder(TreeNode node, int[] sum) {
        if(node == null) {
            return;
        }   
        reverseInOrder(node.right, sum);
        sum[0] += node.val;
        node.val = sum[0];
        reverseInOrder(node.left, sum);
    }

    public static TreeNode bstToGst(TreeNode root) {
        if(root == null) {
            return null;
        }
        reverseInOrder(root, new int[]{0});
        return root;
    }

    public static void main(String[] args) {
        
    }
    
}
