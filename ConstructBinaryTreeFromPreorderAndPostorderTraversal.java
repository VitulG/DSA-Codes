import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public static TreeNode constructBinaryTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart,
                                               int postEnd, Map<Integer, Integer> map) {
        if(preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        if(preStart == preEnd) {
            return root;
        }

        int nextNode = preorder[preStart+1];
        int nextNodeIdxInPost = map.get(nextNode);
        int leftSubTreeSize = nextNodeIdxInPost - postStart + 1;

        root.left = constructBinaryTree(preorder, preStart + 1,  preStart + leftSubTreeSize,
                postorder, postStart, leftSubTreeSize, map);
        root.right = constructBinaryTree(preorder, preStart + leftSubTreeSize + 1, preEnd,
                postorder, nextNodeIdxInPost + 1, postEnd - 1, map);

        return root;
    }

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i<postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return constructBinaryTree(preorder, 0, preorder.length-1, postorder,
                0, postorder.length-1, map);
    }

    public static void main(String[] args) {

    }
}
