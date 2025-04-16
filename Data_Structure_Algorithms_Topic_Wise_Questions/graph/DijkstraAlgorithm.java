package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    static class Node {
        int destination;
        int weight;

        public Node(int dst, int wt) {
            this.destination = dst;
            this.weight = wt;
        }
    }

    public static List<List<Node>> getAdjacencyList(int nodes, int[][] edges) {
        List<List<Node>> adjacencyList = new ArrayList<>();

        for(int i=0; i<nodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            int wt = edge[2];

            adjacencyList.get(src).add(new Node(dst, wt));
            adjacencyList.get(dst).add(new Node(src, wt));
        }
        return adjacencyList;
    }

    public static int[] dijkstra(int V, int[][] edges, int src) {
        // code here

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // create Adjacency List
        List<List<Node>> adjList = getAdjacencyList(V, edges);

        // use a min heap to store the min edges
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        queue.offer(new Node(src, 0));

        distance[src] = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            int currNode = node.destination;
            int currWeight = node.weight;

            if(distance[currNode] < currWeight) {
                continue;
            }

            for(Node nbrNode : adjList.get(currNode)) {
                if(distance[nbrNode.destination] > distance[currNode] + nbrNode.weight) {
                    distance[nbrNode.destination] = distance[currNode] + nbrNode.weight;
                    queue.offer(new Node(nbrNode.destination, distance[nbrNode.destination]));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dijkstra(3, new int[][]{
                {0,1,1},
                {1,2,3},
                {0,2,6}
        }, 2)));
    }
}
