import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    public static TreeNode processTree(TreeNode node, Set<Integer> set, List<TreeNode> forest) {
        if(node == null) {
            return null;
        }

        node.left  = processTree(node.left , set, forest);
        node.right = processTree(node.right, set, forest);

        if(set.contains(node.val)) {
            if(node.left != null) {
                forest.add(node.left);
            }

            if(node.right != null) {
                forest.add(node.right);
            }
            return null;
        }
        return node;
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) {
            return null;
        }

        Set<Integer> set = new HashSet<Integer>();
        List<TreeNode> forest = new ArrayList<TreeNode>();

        for(int delNode : to_delete) {
            set.add(delNode);
        }

        if(!set.contains(root.val)) {
            forest.add(root);
        }

        processTree(root, set, forest);

        return forest;
    }

    
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        

        int[] to_delete = {3,5,2};

        List<TreeNode> forest = delNodes(root, to_delete);

        for(TreeNode node : forest) {
            System.out.print(node.val+" ");
        }
        
    }
    
}
