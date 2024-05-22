public class DistributeCoinsInBinaryTree {

    public static int postorderTraversal(TreeNode node, int[] maxCoins) {
        if(node == null) {
            return 0;
        }

        int left  = postorderTraversal(node.left , maxCoins);
        int right = postorderTraversal(node.right, maxCoins);

        maxCoins[0] += Math.abs(left) + Math.abs(right);

        return node.val-1 + left + right;

    }

    public static int distributeCoins(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] maxCoins = {0};
        postorderTraversal(root, maxCoins);
        return maxCoins[0];
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(3);
        root.right = new TreeNode(0);

        System.out.println(distributeCoins(root));
    }
    
}
