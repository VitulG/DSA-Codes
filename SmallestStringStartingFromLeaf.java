public class SmallestStringStartingFromLeaf {

     static String ans = "";

    public static void preorderTraversal(TreeNode node, StringBuilder curr) {
        if(node == null) {
            return;
        }

        StringBuilder updatedCurr = new StringBuilder();
        updatedCurr.append((char)(node.val+'a'));
        updatedCurr.append(curr);

        if(node.left == null && node.right == null) {    
            if (ans.isEmpty() || ans.compareTo(updatedCurr.toString()) > 0) {
                ans = updatedCurr.toString();
            }
        }
        preorderTraversal(node.left, updatedCurr);
        preorderTraversal(node.right, updatedCurr);

    }

    public static String smallestFromLeaf(TreeNode root) {
        if(root == null) {
            return "";
        }

        preorderTraversal(root, new StringBuilder(""));
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(smallestFromLeaf(root));
    }
}