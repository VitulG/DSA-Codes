import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ModifyGraphEdgeWeights {

    static class Node {
        int neighbor;
        long weight;

        public Node(int neighbor, long weight) {
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }

    public static List<List<Node>> getAdjacencyList(int n, int[][] edges) {
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            graph.get(u).add(new Node(v, wt));
            graph.get(v).add(new Node(u, wt));
        }
        return graph;
    }

    public static long[] dijkstraAlgo(int n, int[][] edges, int src) {
        List<List<Node>> adjList = getAdjacencyList(n, edges);

        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[src] = 0L;

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> Math.toIntExact(a.weight - b.weight));
        queue.offer(new Node(src, 0));

        while (!queue.isEmpty()) {
            Node currVertex = queue.poll();
            int currNode = currVertex.neighbor;
            long currNodeWt = currVertex.weight;

            for (Node nbr : adjList.get(currNode)) {
                int nbrNode = nbr.neighbor;
                long nbrWt = nbr.weight;

                if (nbrWt < 0) {
                    continue; // Skip if weight is still -1
                }

                if (currNodeWt + nbrWt < distance[nbrNode]) {
                    distance[nbrNode] = currNodeWt + nbrWt;
                    queue.offer(new Node(nbrNode, distance[nbrNode]));
                }
            }
        }
        return distance;
    }

    public static int[][] modifiedGraphEdges(int n, int[][] edges, int source,
                                             int destination, int target) {
        // Run Dijkstra to check the initial distances
        long[] initialDistance = dijkstraAlgo(n, edges, source);
        if (initialDistance[destination] < target) {
            // If already matching, just set all -1 weights to 1
            return new int[0][];
        }

        boolean isMatched = (initialDistance[destination] == target);
        int LARGE_VALUE = (int) 2e9;

        for (int[] edge : edges) {
            if (edge[2] == -1) {
                edge[2] = isMatched ? LARGE_VALUE : 1; // Assign the smallest possible value if no match

                if (!isMatched) {
                    long[] newShortestDist = dijkstraAlgo(n, edges, source);

                    if (newShortestDist[destination] <= target) {
                        isMatched = true;
                        edge[2] += (int) (target - newShortestDist[destination]);  // Adjust weight to match target distance
                    }
                }
            }
        }
        return isMatched ? edges : new int[0][];
    }

    public static void main(String[] args) {
        int[][] result = modifiedGraphEdges(5, new int[][]{{4,1,-1},{2,0,-1},{0,3,-1},{4,3,-1}}, 0,
                1, 5);

        assert result != null;


        for(int[] row : result) {
            for(int ele : row) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}

