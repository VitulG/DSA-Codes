import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {

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

    // brute force
    public static List<Integer> findMinHeightTreesUsingBf(int n, int[][] edges) {

        if(n==1) {
            return Collections.singletonList(0);
        }

        List<List<Integer>> adjList = getAdjacencyList(n, edges);

        List<Integer> minLevelRoots = new ArrayList<Integer>();
        int currMinHeight = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            int root = i;
            
            Queue<Integer> queue= new ArrayDeque<Integer>();
            queue.offer(root);

            boolean[] isVisited = new boolean[n];
            isVisited[root] = true;
            
            int level = 0;

            while(!queue.isEmpty()) {
                int size = queue.size();

                while(size-- > 0) {
                    int node = queue.poll();

                    for(int nbr : adjList.get(node)) {
                        if(!isVisited[nbr]) {
                            queue.offer(nbr);
                            isVisited[nbr] = true;
                        }
                    }
                }
                level++;
            }
            if(level < currMinHeight) {
                minLevelRoots.clear();
                minLevelRoots.add(root);
                currMinHeight = level;
            }else if(level == currMinHeight) {
                minLevelRoots.add(root);
            }
        }
        return minLevelRoots;
    }

    // topo sort
    public static List<Integer> findMinHeightTreesOptimally(int n, int[][] edges) {
        if(n==1) {
            return Collections.singletonList(0);
        }

        List<List<Integer>> adjList = getAdjacencyList(n, edges);

        int[] indegree = new int[n];

        for(int i=0; i<n; i++) {
            for(int nbr : adjList.get(i)) {
                indegree[nbr]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();

        for(int i=0; i<n; i++) {
            if(indegree[i] == 1) {
                queue.offer(i);
            }
        }

        while(n > 2) {
            int queueSize = queue.size();
            n -= queueSize;

            for(int i=0; i<queueSize; i++) {
                int leafNode = queue.poll();

                for(int nbr : adjList.get(leafNode)) {
                    indegree[nbr] -= 1;
                    if(indegree[nbr] == 1) {
                        queue.offer(nbr);
                    }
                }
            }
        }
        return new ArrayList<>(queue);

    }

    public static void main(String[] args) {
        System.out.println(findMinHeightTreesOptimally(1, new int[][]{{}}));
    }
}
