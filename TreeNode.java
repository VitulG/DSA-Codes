public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    // Constructor to initialize only the value
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    // Constructor to initialize the value and both children
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}