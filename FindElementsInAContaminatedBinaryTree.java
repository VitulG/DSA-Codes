import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class FindElements {
    private final TreeNode root;
    private final Set<Integer> set;

    public FindElements(TreeNode root) {
        this.root = root;
        this.set = new HashSet<>();

        if(root != null) {
            root.val = 0;
            constructOriginalBinaryTree(this.root);
        }
    }

    private void constructOriginalBinaryTree(TreeNode node) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);
        this.set.add(node.val);

        while(!queue.isEmpty()) {
            TreeNode currRoot = queue.poll();

            if(currRoot.left != null) {
                currRoot.left.val = 2 * currRoot.val + 1;
                set.add(currRoot.left.val);
                queue.offer(currRoot.left);
            }

            if(currRoot.right != null) {
                currRoot.right.val = 2 * currRoot.val + 2;
                set.add(currRoot.right.val);
                queue.offer(currRoot.right);
            }
        }

    }

    public boolean find(int target) {
        return this.set.contains(target);
    }
}

public class FindElementsInAContaminatedBinaryTree {
    public static void main(String[] args) {

    }
}
