import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfDistancesInTree {

    public static List<List<Integer>> getAdjacencyList(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;

    }

    public static int dfsBase(List<List<Integer>> adjList, int node, int depth, int[] ans, boolean[] isVisited, int[] childNodes) {
        isVisited[node] = true;

        int totalCount = 1;
        ans[0] += depth;

        for(int nbr : adjList.get(node)) {
            if(!isVisited[nbr]) {
                totalCount += dfsBase(adjList, nbr, depth+1, ans, isVisited, childNodes);
            }
        }
        childNodes[node] = totalCount;

        return totalCount;

    }


    public static void finalDfs(List<List<Integer>> adjList, int node, boolean[] isVisited, int[] result, int totalNodes, int[] childNodes) {
        isVisited[node] = true;

        for(int nbr : adjList.get(node)) {
            if(!isVisited[nbr]) {
                result[nbr] = result[node] - childNodes[nbr] + totalNodes-childNodes[nbr];
                finalDfs(adjList, nbr, isVisited, result, totalNodes, childNodes);
            }
        }
    }

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] parentAns = {0};
        int[] childNodes = new int[n];

        List<List<Integer>> adjList = getAdjacencyList(n, edges);

        boolean[] isVisited = new boolean[n];

        dfsBase(adjList, 0, 0, parentAns, isVisited, childNodes);

        int[] result = new int[n];
        result[0] = parentAns[0];

        Arrays.fill(isVisited, false);

        finalDfs(adjList, 0, isVisited, result, n, childNodes);

        return result;

    }

    public static void main(String[] args) {
        int[] ans = sumOfDistancesInTree(6, new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}});

        for(int i : ans) {
            System.out.print(i+" ");
        }
    }
    
}
