package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

import java.util.ArrayList;

public class PredecessorAndSuccessor {

    /*
        🔍 Problem: Find the predecessor and successor of a given key in a Binary Search Tree (BST).

        ✅ Approach 1: Brute Force (Inorder Traversal and Binary Search)
            - Convert the BST into a sorted list via inorder traversal.
            - Use binary search to find predecessor and successor.
            - Time Complexity: O(n)
            - Space Complexity: O(n)  // storing all nodes in a list

        ✅ Approach 2: Optimized (Direct BST Traversal in Two Passes)
            - First pass: Find predecessor (greatest node < key)
            - Second pass: Find successor (smallest node > key)
            - Time Complexity: O(h), where h = height of the tree
            - Space Complexity: O(1)  // no extra space used except recursion stack if applicable
    */

    public static void inorderTraversal(TreeNode node, ArrayList<TreeNode> nodes) {
        if(node == null) {
            return;
        }
        inorderTraversal(node.left, nodes);
        nodes.add(node);
        inorderTraversal(node.right, nodes);
    }

    public static int[] findKeyNode(ArrayList<TreeNode> nodes, int key) {
        int low = 0;
        int high = nodes.size()-1;

        int pre = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nodes.get(mid).val == key) {
                return new int[]{mid-1, mid+1};
            }else if(nodes.get(mid).val < key) {
                pre = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return new int[]{pre, low};
    }

    public static ArrayList<TreeNode> findPreSuc(TreeNode root, int key) {
        if(root == null) {
            return new ArrayList<>();
        }

        ArrayList<TreeNode> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);

        int[] keyNode = findKeyNode(nodes, key);

        TreeNode predecessor = new TreeNode(-1);

        if(keyNode[0] >= 0) {
            predecessor = new TreeNode(nodes.get(keyNode[0]).val);
        }

        TreeNode successor = new TreeNode(-1);

        if(keyNode[1] < nodes.size()) {
            successor = new TreeNode(nodes.get(keyNode[1]).val);
        }

        ArrayList<TreeNode> ans = new ArrayList<>();
        ans.add(predecessor);
        ans.add(successor);

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(1);
        root.right = new TreeNode(9);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(10);
        root.left.right.left = new TreeNode(3);

        ArrayList<TreeNode> result = findPreSuc(root, 1);

        System.out.println("Pre: "+result.get(0).val);
        System.out.println("Suc: "+result.get(1).val);
    }
}
