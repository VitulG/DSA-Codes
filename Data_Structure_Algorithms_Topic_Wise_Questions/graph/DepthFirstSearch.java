package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.ArrayList;
import java.util.List;

import static Data_Structure_Algorithms_Topic_Wise_Questions.graph.BreadthFirstSearch.getAdjacencyList;

public class DepthFirstSearch {

    public static void dfs(int src, List<List<Integer>> adjList, List<Integer> dfsTraversalNode, boolean[] isVisited) {
        isVisited[src] = true;
        dfsTraversalNode.add(src);

        for(int nbr : adjList.get(src)) {
            if(!isVisited[nbr]) {
                dfs(nbr, adjList, dfsTraversalNode, isVisited);
            }
        }
    }

    public static List<Integer> depthFirstSearch(int n, int[][] edges) {
        List<List<Integer>> adjList = getAdjacencyList(n, edges);

        boolean[] isVisited = new boolean[n];
        List<Integer> dfsTraversalNode = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(!isVisited[i]) {
                dfs(i, adjList, dfsTraversalNode, isVisited);
            }
        }
        return dfsTraversalNode;
    }

    public static void main(String[] args) {
        System.out.println(depthFirstSearch(5, new int[][]{
                {0,1}, {0,2}, {1,3}, {1,4}
        }));
    }
}
