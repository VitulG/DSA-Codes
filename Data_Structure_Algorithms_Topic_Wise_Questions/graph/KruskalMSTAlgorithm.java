package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.PriorityQueue;

public class KruskalMSTAlgorithm {

    /*
        ✅ Kruskal's Algorithm (Minimum Spanning Tree)

            1. Sort all edges based on weight (ascending order).
            2. Use a PriorityQueue (min-heap) to process edges in increasing order of weight.
            3. Initialize Disjoint Set Union (DSU) to keep track of connected components.

            4. While the priority queue is not empty:
                a. Pick the edge with the smallest weight.
                b. If the source and destination vertices belong to different components (i.e., no cycle),
                   - Add the edge's weight to the total MST cost.
                   - Union the two components.
                c. If both nodes are already in the same set → skip (would form a cycle).

            5. Repeat until (V - 1) edges are added (MST complete).
            6. Return the total minimum cost.

        ✅ Time Complexity: O(E log E) → dominated by sorting edges / PQ insertions
        ✅ Space Complexity: O(V + E) → DSU + edge storage
    */


    public static int findParent(int[] parent, int node) {
        if(parent[node] == node) {
            return parent[node];
        }
        return parent[node] = findParent(parent, parent[node]);
    }

    public static void union(int sourceParent, int destinationParent, int[] size, int[] parent) {
        if(size[sourceParent] <= size[destinationParent]) {
            parent[sourceParent] = destinationParent;
            size[destinationParent] += size[sourceParent];
        }else {
            parent[destinationParent] = sourceParent;
            size[sourceParent] += size[destinationParent];
        }
    }

    public static int spanningTree(int V, int E, int[][] edges) {
        // Code Here.
        if(edges.length == 0) {
            return 0; // there is no edge or a graph
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for(int[] edge : edges) {
            queue.offer(new int[]{edge[0], edge[1], edge[2]});
        }

        int[] parent = new int[V];
        int[] size = new int [V];

        for(int i=0; i<V; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int minCost = 0;

        while(!queue.isEmpty()) {
            int[] nodeEdge = queue.poll();
            int src = nodeEdge[0];
            int dst = nodeEdge[1];
            int wt = nodeEdge[2];

            int srcPar = findParent(parent, src);
            int dstPar = findParent(parent, dst);

            if(srcPar != dstPar) {
                minCost += wt;
                union(srcPar, dstPar, size, parent);
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,1,5},
                {1,2,3},
                {0,2,1}
        };

        System.out.println(spanningTree(3,3,edges));
    }
}
