public class EvaluateBooleanBinaryTree {

    public static boolean evaluateTreeNodes(TreeNode node) {
        if(node.val == 0 || node.val == 1) {
            return node.val == 1;
        }

        if(node.val == 2) {
            return evaluateTree(node.left) || evaluateTree(node.right);
        }else if(node.val == 3) {
            return evaluateTree(node.left) && evaluateTree(node.right);
        }
        return false;
    }


    public static boolean evaluateTree(TreeNode root) {
        if(root == null) {
            return false;
        }
        return evaluateTreeNodes(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        System.out.println(evaluateTree(root));
    }
}