package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.Arrays;

public class BellmanFord {

    public static int[] bellmanFord(int V, int[][] edges, int src) {
        // The Algorithm states that to relax all edges V-1 times

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for(int i=0; i<V-1; i++) {
            for(int[] edge : edges) {
                int source = edge[0];
                int destination = edge[1];
                int weight = edge[2];

                if(distance[source] != Integer.MAX_VALUE && distance[source] + weight < distance[destination]) {
                    distance[destination] = distance[source] + weight;
                }
            }
        }

        // Now check if there is a negative cycle if yes, then return -1
        for(int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];

            if(distance[source] != Integer.MAX_VALUE && distance[source] + weight < distance[destination]) {
                return new int[]{-1};
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[] result = bellmanFord(5, new int[][]{
                {1,3,2},
                {4,3,-1},
                {2,4,1},
                {1,2,1},
                {0,1,5}
        }, 0);

        System.out.println(Arrays.toString(result));

    }
}
