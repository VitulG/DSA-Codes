package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public static List<List<Integer>> getAdjacencyList(int nodes, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public static void bfs(int src, List<List<Integer>> adjList, List<Integer> bfsTraversalNodes, boolean[] isVisited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(src);
        isVisited[src] = true;

        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            bfsTraversalNodes.add(currNode);

            for(int nbr : adjList.get(currNode)) {
                if(!isVisited[nbr]) {
                    queue.offer(nbr);
                    isVisited[nbr] = true;
                }
            }
        }
    }

    public static List<Integer> breadthFirstSearch(int n, int[][] edges) {
        List<List<Integer>> adjList = getAdjacencyList(n, edges);

        boolean[] isVisited = new boolean[n];

        // graph may be disconnected, so I am thinking in that direction
        List<Integer> bfsTraversalNodes = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(!isVisited[i]) {
                bfs(i, adjList, bfsTraversalNodes, isVisited);
            }
        }
        return bfsTraversalNodes;
    }

    public static void main(String[] args) {
        System.out.println(breadthFirstSearch(6, new int[][]{
                {0,1},
                {1,2},
                {3,4},
                {4,5}
        }));
    }
}
