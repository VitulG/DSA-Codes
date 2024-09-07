public class LinkedListInBinaryTree {

    public static boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        if (head == null) return true;

        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public static boolean dfs(ListNode head, TreeNode node) {
        if(head == null) {
            return true;
        }

        if(node == null) {
           return false;
        }

        if(node.val != head.val) {
            return false;
        }
        return dfs(head.next, node.left) || dfs(head.next, node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        System.out.println(isSubPath(head, root)); // true
    }
}
