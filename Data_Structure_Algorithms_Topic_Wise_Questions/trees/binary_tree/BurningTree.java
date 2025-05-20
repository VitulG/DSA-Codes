package Data_Structure_Algorithms_Topic_Wise_Questions.trees.binary_tree;

import Data_Structure_Algorithms_Topic_Wise_Questions.trees.TreeNode;

import java.util.*;

public class BurningTree {

    /*
        Approach:
            1. Convert the binary tree into an undirected graph by treating every node as a graph node
                and adding bidirectional edges between a node and its left/right children (and its parent).
            2. To create the adjacency list, we first determine the maximum node value in the tree,
                since node values are unique and can be used as indices.
            3. Build the adjacency list using DFS, linking each node to its parent and children.
            4. Perform a BFS starting from the target node to simulate the spread of fire,
                incrementing time at each level of traversal.

            Time Complexity: O(n), where n is the number of nodes in the tree (each node is visited once).
            Space Complexity: O(n), for the adjacency list, visited array, and BFS queue.
*/

    public static int findMaxNode(TreeNode node, int[] maxNode) {
        if(node == null) {
            return 0;
        }
        maxNode[0] = Math.max(maxNode[0], node.val);
        return 1 + Math.max(findMaxNode(node.left, maxNode), findMaxNode(node.right, maxNode));
    }

    public static void buildAdjacencyList(TreeNode node, TreeNode parent, List<List<Integer>> adjList) {
        if(node == null) {
            return;
        }

        if(parent != null) {
            adjList.get(parent.val).add(node.val);
            adjList.get(node.val).add(parent.val);
        }

        buildAdjacencyList(node.left, node, adjList);
        buildAdjacencyList(node.right, node, adjList);

    }

    public static int minTime(TreeNode root, int target) {
        if(root == null) {
            return 0;
        }

        int[] maxNode = {Integer.MIN_VALUE};
        findMaxNode(root, maxNode);

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<=maxNode[0]; i++) {
            adjList.add(new ArrayList<>());
        }

        buildAdjacencyList(root, null, adjList);

        boolean[] isVisited = new boolean[maxNode[0]+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target);
        isVisited[target] = true;

        int time = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int node = queue.poll();

                for(int nbrNode : adjList.get(node)) {
                    if(!isVisited[nbrNode]) {
                        isVisited[nbrNode] = true;
                        queue.offer(nbrNode);
                    }
                }
            }
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.right.right = new TreeNode(10);

        System.out.println(minTime(root, 10));
    }
}
