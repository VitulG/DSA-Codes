package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumWeightCycle {
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static List<List<Edge>> getAdjacencyList(int V, int[][] edges) {
        List<List<Edge>> adjacencyList = new ArrayList<>();

        for(int i=0; i<V; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adjacencyList.get(edge[0]).add(new Edge(edge[1], edge[2]));
            adjacencyList.get(edge[1]).add(new Edge(edge[0], edge[2]));
        }
        return adjacencyList;
    }

    public static void removeEdge(List<List<Edge>> adjList, int src, int dst, int wt) {
        adjList.get(src).removeIf(edge -> edge.to == dst && edge.weight == wt);
        adjList.get(dst).removeIf(edge -> edge.to == src && edge.weight == wt);
    }

    public static int[] dijkstra(int V, List<List<Edge>> adjList, int src) {
        PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[src] = 0;
        queue.offer(new Edge(src, 0));

        while(!queue.isEmpty()) {
            Edge edge = queue.poll();

            int curr = edge.to;
            int wt = edge.weight;

            if(distance[curr] < wt) {
                continue;
            }

            for(Edge nbr : adjList.get(curr)) {
                if(distance[nbr.to] > distance[curr] + nbr.weight) {
                    distance[nbr.to] = distance[curr] + nbr.weight;
                    queue.offer(new Edge(nbr.to, distance[nbr.to]));
                }
            }
        }
        return distance;
    }

    public static int findMinCycle(int V, int[][] edges) {
        // code here

        // create a graph using adjacency List
        List<List<Edge>> adjList = getAdjacencyList(V, edges);

        // initialize the minimum cycle to that I can keep track of the minimum cycle path
        int minCyclePath = Integer.MAX_VALUE;

        // now take every edge and remove it and check if I can go from source to destination via another edge
        for(int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];

            // remove this edge now
            removeEdge(adjList, source, destination, weight);

            // now applying the dijkstra algo to find the shortest path in a cycle if exists for src to dest via another edge
            int[] shortestDistance = dijkstra(V, adjList, source);

            // cycle exists
            if(shortestDistance[destination] != Integer.MAX_VALUE) {
                minCyclePath = Math.min(minCyclePath, shortestDistance[destination] + weight);
            }

            // backtrack the edges to check for another cycle
            adjList.get(source).add(new Edge(destination, weight));
            adjList.get(destination).add(new Edge(source, weight));
        }
        return minCyclePath == Integer.MAX_VALUE ? -1 : minCyclePath;
    }

    public static void main(String[] args) {
        System.out.println(findMinCycle(5, new int[][]{
                {0,1,2},
                {1,2,2},
                {1,3,1},
                {1,4,1},
                {0,4,3},
                {2,3,4}
        }));
    }
}
