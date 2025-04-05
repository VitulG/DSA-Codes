package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {

    public static void dfs(int src, List<List<Integer>> adjList, boolean[]  isVisited) {
        isVisited[src] = true;

        for(int nbr : adjList.get(src)) {
            if(!isVisited[nbr]) {
                dfs(nbr, adjList, isVisited);
            }
        }
    }

    public static List<List<Integer>> getAdjacencyList(int cities, int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<cities; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<isConnected.length; i++) {
            for(int j=0; j<isConnected[i].length; j++) {
                if(i!=j && isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        return graph;
    }

    public static int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = getAdjacencyList(isConnected.length, isConnected);

        int provinces = 0;
        boolean[] isVisited = new boolean[isConnected.length];

        for(int i=0; i<isConnected.length; i++) {
            if(!isVisited[i]) {
                dfs(i, adjList, isVisited);
                provinces++;
            }
        }
        return provinces;
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        }));
    }
}
