import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SecondMinimumTimeToReachDestination {

    static class Pair {
        int time;
        int node;

        public Pair(int time, int node) {
            this.node = node;
            this.time = time;
        }
    }


    public static List<List<Integer>> getAdjacencyList(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }


    public static int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adjList = getAdjacencyList(n, edges);

        int[] minimumDistance = new int[n+1];
        int[] secondMinimumDistance = new int[n+1];

        Arrays.fill(minimumDistance, Integer.MAX_VALUE);
        Arrays.fill(secondMinimumDistance, Integer.MAX_VALUE);

        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> a.time - b.time);
        queue.offer(new Pair(0, 1));
        minimumDistance[1] = 0;

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int currTime = pair.time;
            int node = pair.node;

            if(node == n && secondMinimumDistance[node] != Integer.MAX_VALUE) {
                return secondMinimumDistance[node];
            }

            int multiple = currTime / change;

            if(multiple%2 != 0) {
                currTime = (multiple+1)*change;
            }

            for(int nbr : adjList.get(node)) {
                if (minimumDistance[nbr] > currTime + time) { // +time for this edge to reach nbr
                    secondMinimumDistance[nbr] = minimumDistance[nbr];
                    minimumDistance[nbr] = currTime + time;
                    queue.offer(new Pair(currTime + time, nbr));
                } else if (secondMinimumDistance[nbr] > currTime + time && minimumDistance[nbr] != currTime + time) {
                    secondMinimumDistance[nbr] = currTime + time;
                    queue.offer(new Pair(currTime + time, nbr));
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(secondMinimum(5, new int[][]{{1,2},{1,3},{1,4},{3,4},{4,5}}, 3, 5));
    }
}
