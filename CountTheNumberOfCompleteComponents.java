import java.util.ArrayList;
import java.util.List;

public class CountTheNumberOfCompleteComponents {

    public static List<List<Integer>> getAdjacencyList(int nodes, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public static void dfs(int src, List<List<Integer>> adjList, boolean[] isVisited, List<Integer> connectedComponents) {
        isVisited[src] = true;
        connectedComponents.add(src);

        for(int nbr : adjList.get(src)) {
            if(!isVisited[nbr]) {
                dfs(nbr, adjList, isVisited, connectedComponents);
            }
        }

    }

    public static boolean isCompleteComponent(List<Integer> connectedComponents, List<List<Integer>> adjList) {
        int componentSize = connectedComponents.size();

        for(int node : connectedComponents) {
            if(adjList.get(node).size() != componentSize-1) {
                return false;
            }
        }
        return true;
    }

    public static int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = getAdjacencyList(n, edges);

        boolean[] isVisited = new boolean[n];

        int completeComponents = 0;

        for(int i = 0; i<n; i++) {
            if(!isVisited[i]) {
                List<Integer> connectedComponents = new ArrayList<>();
                dfs(i, adjList, isVisited, connectedComponents);

                if(isCompleteComponent(connectedComponents, adjList)) {
                    completeComponents++;
                }

            }
        }
        return completeComponents;
    }

    public static void main(String[] args) {
        System.out.println(countCompleteComponents(6, new int[][]{
                {0,1},
                {0,2},
                {1,2},
                {3,4},
                {3,5}
        }));
    }
}
