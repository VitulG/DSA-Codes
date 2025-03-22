package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TwoSumIVInputIsABST {

    public static void inorderBSTTraversal(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }

        inorderBSTTraversal(node.left, list);
        list.add(node.val);
        inorderBSTTraversal(node.right, list);
    }

    public static boolean findTarget(TreeNode root, int k) {
        if(root == null) {
            return false;
        }
        List<Integer> numbers = new ArrayList<>();
        inorderBSTTraversal(root, numbers);

        int le = 0;
        int ri = numbers.size()-1;

        while(le < ri) {
            if(numbers.get(le) + numbers.get(ri) == k) {
                return true;
            }else if(numbers.get(le) + numbers.get(ri) < k) {
                le++;
            }else {
                ri--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.println(findTarget(root, 19));

    }
}
