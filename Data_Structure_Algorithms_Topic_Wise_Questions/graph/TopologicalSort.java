package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {

    public static List<List<Integer>> getAdjacencyList(int nodes, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        return graph;
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // create graph
        List<List<Integer>> adjList = getAdjacencyList(V, edges);

        //create an in_degree of the node
        int[] in_degree = new int[V];

        for(int i=0; i<V; i++) {
            for(int nbr : adjList.get(i)) {
                in_degree[nbr]++;
            }
        }

        // put all those nodes in which they have 0 in_degrees
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<V; i++) {
            if(in_degree[i] == 0) {
                queue.offer(i);
            }
        }

        // final Step is to pop out the node and print the node which have 0 in_degree
        ArrayList<Integer> topoNodes = new ArrayList<>();

        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            topoNodes.add(currNode);

            for(int nbr : adjList.get(currNode)) {
                in_degree[nbr]--;
                if(in_degree[nbr] == 0) {
                    queue.offer(nbr);
                }
            }
        }
        return topoNodes;
    }

    public static void main(String[] args) {
        System.out.println(topoSort(4, new int[][]{
                {3,0},
                {1,0},
                {2,0}
        }));
    }
}
