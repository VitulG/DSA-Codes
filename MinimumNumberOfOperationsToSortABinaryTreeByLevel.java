import java.util.*;

import static java.util.Collections.swap;

public class MinimumNumberOfOperationsToSortABinaryTreeByLevel {

    public static int minimumOperations(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int minOperations = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for(int i = 0; i<size; i++) {
                TreeNode node = queue.poll();

                levelNodes.add(node.val);

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            minOperations += getMinOperationsInLevel(levelNodes);
        }
        return minOperations;
    }

    private static int getMinOperationsInLevel(List<Integer> levelNodes) {
        if(levelNodes.size() == 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> sortedList = levelNodes
                .stream()
                .sorted()
                .toList();

        for(int i=0; i<levelNodes.size(); i++) {
            map.put(sortedList.get(i), i);
        }

        int minSwaps = 0;

        for(int originalIdx=0; originalIdx<levelNodes.size(); originalIdx++) {
            while(map.get(levelNodes.get(originalIdx))!=originalIdx)
            {
                minSwaps++;
                swap(levelNodes, map.get(levelNodes.get(originalIdx)), originalIdx);
            }
        }
        return minSwaps;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(9);
        root.right.right.left = new TreeNode(10);

        System.out.println(minimumOperations(root));
    }
}
