package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

public class SumOfNodesOnTheLongestPath {

    /*
        Approach: -
                    1. First, I need to figure out what the maximum depth of the tree is.
                    2. Once the maximum depth is found (using tree traversal), I can then look for the maximum sum along the deepest path.
                    3. During traversal, I maintain the current path sum and recursively call left and right children.
                    4. Whenever I reach a leaf node at the maximum depth, I compare and update the maximum sum if needed.
                    5. After the full traversal, the result will hold the maximum sum of any root-to-leaf path of maximum length.

                    Time Complexity:  O(n) — we visit each node once.
                    Space Complexity: O(h) — due to recursion stack (h = height of the tree).
     */

    public static int getMaximumDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }

        return Math.max(getMaximumDepth(node.left), getMaximumDepth(node.right)) + 1;
    }

    public static void getMaxDepthPathSum(TreeNode node, int currentSum, int[] maxSum, int currentDepth, int maxDepth) {
        if(node == null) {
            return;
        }
        currentSum += node.val;

        if(node.left == null && node.right == null && currentDepth == maxDepth) {
            maxSum[0] = Math.max(maxSum[0], currentSum);
        }

        getMaxDepthPathSum(node.left, currentSum, maxSum, currentDepth+1, maxDepth);
        getMaxDepthPathSum(node.right, currentSum, maxSum, currentDepth+1, maxDepth);

    }

    public static int sumOfLongRootToLeafPath(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int maxDepth = getMaximumDepth(root) - 1;
        int[] maxSum = {Integer.MIN_VALUE};

        getMaxDepthPathSum(root, 0, maxSum, 0, maxDepth);

        return maxSum[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);
        root.left.left.left = new TreeNode(1);

        System.out.println(sumOfLongRootToLeafPath(root));
    }
}
