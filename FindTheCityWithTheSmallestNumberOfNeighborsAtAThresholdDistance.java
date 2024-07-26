import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

    static class Pair {
        int to;
        int distance;

        public Pair(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
    
    public static List<List<Pair>> getAdjacencyList(int cities, int[][] edges) {
        List<List<Pair>> graph = new ArrayList<List<Pair>>();

        for(int i=0; i<cities; i++) {
            graph.add(new ArrayList<Pair>());
        }

        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int distance = edge[2];
            graph.get(from).add(new Pair(to, distance));
            graph.get(to).add(new Pair(from, distance));
        }
        return graph;

    }

    public static int[] dijkastra(int n, List<List<Pair>> adjList, int source) {

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        queue.add(new Pair(source, 0));

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int src = pair.to;

            for(Pair nbr : adjList.get(src)) {
                int dest = nbr.to;
                int weight = nbr.distance;

                if(distance[src] + weight < distance[dest]) {
                    distance[dest] = distance[src] + weight;
                    queue.offer(new Pair(dest, distance[dest]));
                }
            }
        }
        return distance;
    }
    
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // i am using dijkastra's algorithm

        // step 1: make graph
        List<List<Pair>> graph = getAdjacencyList(n, edges);

        int minCityReached = Integer.MAX_VALUE;
        int citiesReahed = -1;

        for(int i=0; i<n; i++) {
            int[] dist = dijkastra(n, graph, i);
            int reachableCities = 0;

            for(int distance : dist) {
                if(distance <= distanceThreshold) {
                    reachableCities++;
                }
            }
            if(reachableCities <= minCityReached) {
                minCityReached = reachableCities;
                citiesReahed = i;
            }
        }
        return citiesReahed;

    }



    public static void main(String[] args) {
        System.out.println(findTheCity(4, new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}}, 4));
    }
    
}
