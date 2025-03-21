public class BinarySearchTreeToGreaterSumTree {
    public static void reverseInorder(TreeNode node, int[] sum) {
        if(node == null) {
            return;
        }
        reverseInorder(node.right, sum);
        sum[0] += node.val;
        node.val = sum[0];
        reverseInorder(node.left, sum);
    }

    public static TreeNode bstToGst(TreeNode root) {
        if(root == null) {
            return null;
        }

        int[] sum = {0};
        reverseInorder(root, sum);

        return root;
    }

    public static void main(String[] args) {

    }
}
