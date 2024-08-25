import java.util.ArrayList;
import java.util.List;

public class FindIfPathExistsInGraph {

    public static List<List<Integer>> getAdjacencyList(int vertices, int[][] edges) {
        
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for(int i=0; i<vertices; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;

    }

    public static boolean dfs(List<List<Integer>> adjList, int source, int destination, boolean[] isVisited) {
        isVisited[source] = true;

        if(source == destination) {
            return true;
        }

        // for(int nbr : adjList.get(source)) {
        //     if(!isVisited[nbr] && dfs(adjList, nbr, destination, isVisited)) {
        //         return true;
        //     }
        // }

        List<Integer> nbrs = adjList.get(source);

        for(int i=0; i<nbrs.size(); i++) {
            if(!isVisited[nbrs.get(i)] && dfs(adjList, nbrs.get(i), destination, isVisited)) {
                return true;
            }
        }
        return false;

    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = getAdjacencyList(n, edges);
        boolean[] isVisited = new boolean[n];
        return dfs(adjList, source, destination, isVisited);

    }

    public static void main(String[] args) {
        System.out.println(validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
    }

}