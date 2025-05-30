import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindClosestNodeToGivenTwoNodes {

    public static List<List<Integer>> getAdjacencyList(int nodes, int[] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            if(edges[i] != -1) {
                graph.get(i).add(edges[i]);
            }
        }
        return graph;
    }

    public static void dfs(int src, List<List<Integer>> adjList, int[] distance, boolean[] isVisited) {
        isVisited[src] = true;

        for(int nbr : adjList.get(src)) {
            if(!isVisited[nbr]) {
                distance[nbr] = distance[src] + 1;
                dfs(nbr, adjList, distance, isVisited);
            }
        }
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        List<List<Integer>> adjList = getAdjacencyList(edges.length, edges);

        int[] distance1 = new int[edges.length];
        boolean[] isVisited = new boolean[edges.length];
        Arrays.fill(distance1, -1);

        distance1[node1] = 0;
        dfs(node1, adjList, distance1, isVisited);

        int[] distance2 = new int[edges.length];
        Arrays.fill(distance2, -1);

        Arrays.fill(isVisited, false);
        distance2[node2] = 0;
        dfs(node2, adjList, distance2, isVisited);

        int node = -1;
        int minDistance = Integer.MAX_VALUE;

        for(int i=0; i<edges.length; i++) {
            if(distance1[i] == -1 || distance2[i] == -1) {
                continue;
            }

            if(Math.max(distance1[i], distance2[i]) < minDistance) {
                node = i;
                minDistance = Math.max(distance1[i], distance2[i]);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        System.out.println(closestMeetingNode(new int[]{1,2,-1}, 0, 2));
    }
}
