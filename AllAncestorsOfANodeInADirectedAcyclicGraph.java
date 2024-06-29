import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllAncestorsOfANodeInADirectedAcyclicGraph {

    public static List<List<Integer>> getAdjacencyList(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        return graph;
    }

    public static void dfs(int src, int current, List<List<Integer>> adjList, boolean[] isVisited, List<List<Integer>> ancestors) {
        isVisited[src] = true;
        for(int nbr : adjList.get(current)) {
            if(!isVisited[nbr]) {
                isVisited[nbr] = true;
                ancestors.get(nbr).add(src);
                dfs(src, nbr, adjList, isVisited, ancestors);
            }
        }
    }
    
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ancestors = new ArrayList<List<Integer>>();
        List<List<Integer>> adjList = getAdjacencyList(n, edges);

        for(int i=0; i<n; i++) {
            ancestors.add(new ArrayList<Integer>());
        }

        for(int i=0; i<n; i++) {
            boolean[] isVisited = new boolean[n];
            dfs(i, i, adjList, isVisited, ancestors);
        }

        for(List<Integer> list : ancestors) {
            Collections.sort(list);
        }
        return ancestors;
    }

    public static void main(String[] args) {
        System.out.println(getAncestors(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},
            {3,5},{3,6},{3,7},{4,6}}));
    }
}
