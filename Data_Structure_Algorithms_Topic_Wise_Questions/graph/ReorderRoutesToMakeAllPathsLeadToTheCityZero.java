package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    public static List<List<int[]>> getAdjacencyList(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] connection : connections) {
            graph.get(connection[0]).add(new int[]{connection[1], 1});
            graph.get(connection[1]).add(new int[]{connection[0], 0});
        }
        return graph;
    }

    public static int dfs(int src, List<List<int[]>> adjList, boolean[] isVisited) {
        isVisited[src] = true;
        int changes = 0;

        for(int[] nbr :adjList.get(src)) {
            int nextCity = nbr[0];
            int direction = nbr[1];

            if(!isVisited[nextCity]) {
                changes += direction + dfs(nextCity, adjList, isVisited);
            }

        }
        return changes;
    }

    public static int minReorder(int n, int[][] connections) {
        List<List<int[]>> adjList = getAdjacencyList(n, connections);

        // make simple dfs call starts from 0;
        boolean[] isVisited = new boolean[n];

        return dfs(0, adjList, isVisited);
    }

    public static void main(String[] args) {
        System.out.println(minReorder(6, new int[][]{
                {0,1},
                {1,3},
                {2,3},
                {4,0},
                {4,5}
        }));
    }
}
