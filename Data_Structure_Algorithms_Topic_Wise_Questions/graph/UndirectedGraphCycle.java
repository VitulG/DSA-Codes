package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.List;

import static Data_Structure_Algorithms_Topic_Wise_Questions.graph.BreadthFirstSearch.getAdjacencyList;

public class UndirectedGraphCycle {

    public static boolean hasGraphCycle(int src, List<List<Integer>> adjList, int parent, boolean[] isVisited) {
        isVisited[src] = true;

        for(int nbr : adjList.get(src)) {
            if(!isVisited[nbr]) {
                if(hasGraphCycle(nbr, adjList, src, isVisited)) {
                    return true;
                }
            }else if(parent != nbr) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adjList = getAdjacencyList(V, edges);

        boolean[] isVisited = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!isVisited[i]) {
                if(hasGraphCycle(i, adjList, -1, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isCycle(4, new int[][]{
                {0,1}
        }));
    }
}
