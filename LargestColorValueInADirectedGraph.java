import java.util.*;

public class LargestColorValueInADirectedGraph {

    public static List<List<Integer>> getAdjacencyList(int nodes, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        return graph;
    }

    public static int largestPathValue(String colors, int[][] edges) {
        int nodes = colors.length();

        List<List<Integer>> adjList = getAdjacencyList(nodes, edges);

        int[] in_degree = new int[nodes];

        for(int i=0; i<nodes; i++) {
            for(int nbr : adjList.get(i)) {
                in_degree[nbr]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

        int[][] countMemo = new int[nodes][26];

        for(int i=0; i<in_degree.length; i++) {
            if(in_degree[i] == 0) {
                queue.offer(i);
                countMemo[i][colors.charAt(i)-'a'] = 1;
            }
        }

        int largestColorValue = Integer.MIN_VALUE;
        int executedNodes = 0;

        while(!queue.isEmpty()) {
            int src = queue.poll();
            executedNodes++;

            largestColorValue = Math.max(largestColorValue, countMemo[src][colors.charAt(src)-'a']);

            for(int nbr : adjList.get(src)) {

                for(int i=0; i<26; i++) {
                    countMemo[nbr][i] = Math.max(countMemo[nbr][i], countMemo[src][i] +
                            (( i == colors.charAt(nbr)-'a') ? 1 : 0));
                }

                in_degree[nbr]--;

                if(in_degree[nbr] == 0) {
                    queue.offer(nbr);
                }
            }

        }
        return executedNodes == nodes ? largestColorValue : -1;
    }

    public static void main(String[] args) {
        System.out.println(largestPathValue("bbbhb", new int[][]{
                {0,2},
                {3,0},
                {1,3},
                {4,1}
        }));
    }
}
