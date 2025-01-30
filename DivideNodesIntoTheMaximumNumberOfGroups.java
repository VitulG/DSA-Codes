import java.util.*;

public class DivideNodesIntoTheMaximumNumberOfGroups {

    public static List<List<Integer>> getAdjacencyList(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    public static boolean isBipartiteGraph(int node, List<List<Integer>> adjList, int[] colors, int color) {
        colors[node] = color;

        for(int nbr : adjList.get(node)) {
            if(colors[node] == colors[nbr]) {
                return false;
            }

            if(colors[nbr] == -1) {
                if(!isBipartiteGraph(nbr, adjList, colors, 1 - color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int bfs(int node, List<List<Integer>> adjList, int nodes) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[nodes+1];

        queue.offer(node);
        int level = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int currNode = queue.poll();

                for(int nbrNode : adjList.get(currNode)) {
                    if(!isVisited[nbrNode]) {
                        queue.offer(nbrNode);
                        isVisited[nbrNode] = true;
                    }
                }
            }
            level++;
        }
        return level-1;
    }

    public static int dfs(int node, List<List<Integer>> adjList, int[] levels, boolean[] isVisited) {
        isVisited[node] = true;

        int maxLevels = levels[node];

        for(int nbr : adjList.get(node)) {
            if(!isVisited[nbr]) {
                maxLevels = Math.max(maxLevels, dfs(nbr, adjList, levels, isVisited));
            }
        }
        return maxLevels;
    }

    public static int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adjList = getAdjacencyList(n, edges);

        // Step 1. check if the graph is bipartite check from every component because graph can be disconnected.
        int[] colors = new int[n+1];
        Arrays.fill(colors, -1);
        for(int i=1; i<=n; i++) {
            if(colors[i] == -1 && !isBipartiteGraph(i, adjList, colors, 1)) {
                return -1;
            }
        }

        // step 2. get the max levels from each node.
        int[] levels = new int[n+1];
        for(int i=1; i<=n; i++) {
            levels[i] = bfs(i, adjList, n);
        }

        int maxGroups = 0;
        boolean[] isVisited = new boolean[n+1];
        for(int i=1; i<=n; i++) {
            if(!isVisited[i]) {
                maxGroups += dfs(i, adjList, levels, isVisited);
            }
        }
        return maxGroups;
    }

    public static void main(String[] args) {
        System.out.println(magnificentSets(6, new int[][]{
                {1,2},
                {1,4},
                {1,5},
                {2,6},
                {2,3},
                {4,6}
        }));
    }
}
