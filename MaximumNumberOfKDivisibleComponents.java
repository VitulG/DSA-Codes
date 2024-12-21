import java.util.ArrayList;
import java.util.List;

public class MaximumNumberOfKDivisibleComponents {

    public static int dfs(int src,  List<List<Integer>> adjList, int[] values, int k, int[] ans, boolean[] isVisited) {
        isVisited[src] = true;

        int subTreeSum = values[src];

        for(int nbr : adjList.get(src)) {
            if(!isVisited[nbr]) {
               int childSum = dfs(nbr, adjList, values, k, ans, isVisited);
               subTreeSum = (subTreeSum + childSum) % k;
            }
        }

        if(subTreeSum % k == 0) {
            ans[0]++;
            return 0;
        }
        return subTreeSum;

    }

    public static List<List<Integer>> getAdjacencyList(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adjList = getAdjacencyList(n, edges);

        int[] ans = {0};
        boolean[] isVisited = new boolean[n];

        dfs(0, adjList, values, k, ans, isVisited);

        return ans[0];
    }

    public static void main(String[] args) {
        System.out.println(maxKDivisibleComponents(5, new int[][]{
                {0,2},
                {1,2},
                {1,3},
                {2,4}
        }, new int[]{1,8,1,4,4}, 6));
    }
}
