package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DirectedGraphCycle {

    public static List<List<Integer>> getAdjacencyList(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i<V; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        return graph;
    }

    public static boolean dfs(int src, List<List<Integer>> adjList, boolean[] isVisited, boolean[] path) {
        isVisited[src] = true;
        path[src] = true;

        for(int nbr : adjList.get(src)) {
            if(path[nbr]) {
                return true;
            }

            if(!isVisited[nbr] && dfs(nbr, adjList, isVisited, path)) {
                return true;
            }
        }
        path[src] = false;
        return false;
    }

    // approach 1. using dfs
    public static boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adjList = getAdjacencyList(V, edges);
        boolean[] path = new boolean[V];
        boolean[] isVisited = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!isVisited[i]) {
                if(dfs(i, adjList, isVisited, path)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Approach 2. using Kahn's algorithm
    public static boolean isDirectedGraphCyclic(int V, int[][] edges) {
        List<List<Integer>> adjList = getAdjacencyList(V, edges);

        int[] in_degree = new int[V];

        for(int i=0; i<V; i++) {
            for(int nbr : adjList.get(i)) {
                in_degree[nbr]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<V; i++) {
            if(in_degree[i] == 0) {
                queue.offer(i);
            }
        }

        int nodes = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            nodes++;

            for(int nbr : adjList.get(node)) {
                in_degree[nbr]--;
                if(in_degree[nbr] == 0) {
                    queue.offer(nbr);
                }
            }
        }
        return nodes != V;

    }

    public static void main(String[] args) {

    }
}
