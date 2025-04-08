package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.ArrayList;
import java.util.List;

public class BridgeEdgeInAGraph {

    public static List<List<Integer>> getAdjacencyList(int vertices, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<vertices; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public static void dfs(int src, int parent, List<List<Integer>> adjList, boolean[] isVisited, int[] timer,
                           int[] tin, int[] low, int s, int d, boolean[] flag) {
        isVisited[src] = true;
        tin[src] = low[src] = timer[0]++;

        for(int nbr : adjList.get(src)) {
            if(nbr == parent) {
                continue;
            }
            if(!isVisited[nbr]) {
                dfs(nbr, src, adjList, isVisited, timer, tin, low, s, d, flag);
                low[src] = Math.min(low[src], low[nbr]);

                if(low[nbr] > tin[src]) {
                    if((src == s && nbr == d) || (nbr == s || src == d)) {
                        flag[0] = true;
                    }
                }

            }else {
                low[src] = Math.min(low[src], low[nbr]);
            }
        }

    }
    public static boolean isBridge(int V, int[][] edges, int c, int d) {
        List<List<Integer>> adjList = getAdjacencyList(V, edges);

        System.out.println(adjList);

        int[] timer = {0};
        int[] time_of_insertion = new int[V];
        int[] low_time = new int[V];
        boolean[] isVisited = new boolean[V];
        boolean[] flag = {false};

        dfs(0, -1, adjList, isVisited, timer, time_of_insertion, low_time, c, d, flag);

        return flag[0];
    }

    public static void main(String[] args) {
        System.out.println(isBridge(6, new int[][]{
                {0,1},
                {0,2},
                {0,4},
                {2,4},
                {2,3},
                {1,5},
        }, 0, 2));
    }
}
