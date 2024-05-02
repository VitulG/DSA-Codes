public class SumOfLeftLeaves {

    public static int leftNodeSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int curr = 0;

        if(root.left != null && root.left.left == null && root.left.right == null) {
            curr = root.left.val;
        }

        int leftSub = leftNodeSum(root.left);
        int rightSub = leftNodeSum(root.right);


        return leftSub + rightSub + curr;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int sum = leftNodeSum(root);
        System.out.println("Sum of left leaves: " + sum);
    }
}
