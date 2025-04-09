package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.ArrayList;
import java.util.List;

import static Data_Structure_Algorithms_Topic_Wise_Questions.graph.BreadthFirstSearch.getAdjacencyList;

public class ArticulationPoint {

    public static void dfs(int src, int parent, List<List<Integer>> adjList, boolean[] isVisited, int[] tin,
                           int[] low, int[] markNodes, int[] timer) {
        isVisited[src] = true;
        tin[src] = low[src] = timer[0]++;

        int children = 0;

        for(int nbr : adjList.get(src)) {
            if(nbr == parent) {
                continue;
            }
            if(!isVisited[nbr]) {
                dfs(nbr, src, adjList, isVisited, tin, low, markNodes, timer);
                low[src] = Math.min(low[src], low[nbr]);

                if(low[nbr] > tin[src] && parent != -1) {
                    markNodes[src] = 1;
                }
                children++;
            }else {
                low[src] = Math.min(low[src], low[nbr]);
            }
        }
        if(parent == -1 && children > 1) {
            markNodes[src] = 1;
        }
    }

    public static List<Integer> articulationPoints(int V, int[][] edges) {
        List<List<Integer>> adjList = getAdjacencyList(V, edges);

        int[] tin = new int[V];
        int[] low = new int[V];
        int[] markArticulationNode = new int[V];
        int[] timer = {0};
        boolean[] isVisited = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!isVisited[i]) {
                dfs(i, -1, adjList, isVisited, tin, low, markArticulationNode, timer);
            }
        }

        List<Integer> articulationPoints = new ArrayList<>();

        for(int i=0; i<V; i++) {
            if(markArticulationNode[i] == 1) {
                articulationPoints.add(i);
            }
        }
        return articulationPoints;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {1, 2}, {1, 3}, {3, 4}
        };
        int V = 5;

        System.out.println(articulationPoints(V, edges));
    }
}
