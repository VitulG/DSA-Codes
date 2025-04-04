import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfDeepestLeaves {

    public static int findDepthOfBinaryTree(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftDepth = findDepthOfBinaryTree(node.left);
        int rightDepth = findDepthOfBinaryTree(node.right);

        return Math.max(leftDepth, rightDepth) + 1; // root itself
    }

    public static void getDeepestLeafNodes(TreeNode node, List<TreeNode> deepestNodes, int currDepth, int maxDepth) {
        if(node == null) {
            return;
        }

        if(node.left == null && node.right == null && currDepth == maxDepth) {
            deepestNodes.add(node);
            return;
        }

        getDeepestLeafNodes(node.left, deepestNodes, currDepth+1, maxDepth);
        getDeepestLeafNodes(node.right, deepestNodes, currDepth+1, maxDepth);

    }

    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root == p || root == q) {
            return root;
        }

        TreeNode lcaLeft = findLCA(root.left, p, q);
        TreeNode lcaRight = findLCA(root.right, p, q);

        if(lcaLeft != null && lcaRight != null) {
            return root;
        }
        return lcaLeft != null ? lcaLeft : lcaRight;
    }

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        // step 1. find the depth of binary tree
        int treeDepth = findDepthOfBinaryTree(root) - 1;

        // step 2. find all the deepest nodes
        List<TreeNode> deepestNodes = new ArrayList<>();
        getDeepestLeafNodes(root, deepestNodes, 0, treeDepth);

        if(deepestNodes.size() == 1) {
            return deepestNodes.get(0);
        }

        TreeNode lca = deepestNodes.get(0);

        // calculate the lca of two nodes
        for(int i=1; i<deepestNodes.size(); i++) {
            lca = findLCA(root, lca, deepestNodes.get(i));
        }
        return lca;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode result = lcaDeepestLeaves(root);
        System.out.println(result.val);
    }
}
