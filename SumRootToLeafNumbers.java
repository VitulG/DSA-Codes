public class SumRootToLeafNumbers {

    public static void preorderTraversal(TreeNode node, int[] sum, int num) {
        if(node == null) {
            return; 
        }
        
        num = (num*10)+node.val;

        if(node.left == null && node.right == null) {
            sum[0] += num;
            return;
        }

        preorderTraversal(node.left, sum, num);
        preorderTraversal(node.right, sum, num);

    }

    public static int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int[] sum = {0};
        preorderTraversal(root, sum, 0);
        return sum[0];

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        System.out.println(sumNumbers(root));
    }
}