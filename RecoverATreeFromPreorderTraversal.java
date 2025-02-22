public class RecoverATreeFromPreorderTraversal {

    public static TreeNode constructBinaryTree(String str, int[] idx, int depth) {
        if(idx[0] >= str.length()) {
            return null;
        }

        int j = idx[0];

        while(j < str.length() && str.charAt(j) == '-') {
            j++;
        }

        int dash = j - idx[0];

        if(depth != dash) {
            return null;
        }

        idx[0] += dash;

        int num = 0;

        while(idx[0] < str.length() && Character.isDigit(str.charAt(idx[0]))) {
            num = (num*10) + (str.charAt(idx[0]) - '0');
            idx[0]++;
        }

        TreeNode root = new TreeNode(num);

        root.left = constructBinaryTree(str, idx, depth+1);
        root.right = constructBinaryTree(str, idx, depth+1);


        return root;
    }

    public static TreeNode recoverFromPreorder(String traversal) {
        int[] idx = {0};
        int depth = 0;

        return constructBinaryTree(traversal, idx, depth);
    }

    public static void main(String[] args) {

    }
}
