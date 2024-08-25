public class StepByStepDirectionsFromABinaryTreeNodeToAnother {

    public static TreeNode findLCA(TreeNode node, int first, int second) {
        if(node == null) {
            return null;
        }

        if(node.val == first || node.val == second) {
            return node;
        }

        TreeNode left = findLCA(node.left, first, second);
        TreeNode right = findLCA(node.right, first, second);

        if(left != null && right != null) {
            return node;
        }

        if(left != null) {
            return left;
        }
        return right;

    }

    public static boolean getPath(TreeNode node, int startValue, StringBuilder list) {
        if(node == null) {
            return false;
        }

        if(node.val == startValue) {
            return true;
        }

        list.append('L');
        if(getPath(node.left, startValue, list)) {
            return true;
        }
        list.deleteCharAt(list.length()-1);

        list.append('R');
        if(getPath(node.right, startValue, list)) {
            return true;
        }
        list.deleteCharAt(list.length()-1);

        return false;

    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        if(root == null) {
            return "";
        }

        //step 1. find the LCA node
        TreeNode lcaNode = findLCA(root, startValue, destValue);

        StringBuilder srcToRootPath = new StringBuilder("");
        StringBuilder rootToDestPath = new StringBuilder("");

        //step 2. traverse the src to root
        getPath(lcaNode, startValue, srcToRootPath);
        
        // step 3.
        getPath(lcaNode, destValue, rootToDestPath);

        int idx = 0;

        while(idx < srcToRootPath.length()) {
            srcToRootPath.setCharAt(idx, 'U');
            idx++;
        }

        srcToRootPath.append(rootToDestPath);

        return srcToRootPath.toString();

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        System.out.println(getDirections(root, 3, 6));
    }
    
}
