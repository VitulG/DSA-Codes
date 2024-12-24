import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindMinimumDiameterAfterMergingTwoTrees {

    public static List<List<Integer>> getAdjacencyList(int[][] edges, int len) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<len; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public static int getDiameter(List<List<Integer>> adjList, int len) {
        int[] firstEndNode = bfs(adjList, len, 0);
        int[] nodeDiameter = bfs(adjList, len, firstEndNode[0]);
        return nodeDiameter[1]-1;
    }

    public static int[] bfs(List<List<Integer>> adjList, int n, int src) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(src);

        boolean[] isVisited = new boolean[n];
        isVisited[src] = true;

        int farthestNode = src;
        int distance = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int node = queue.poll();
                farthestNode = node;

                for(int nbr : adjList.get(node)) {
                    if(!isVisited[nbr]) {
                        isVisited[nbr] = true;
                        queue.offer(nbr);
                    }
                }
            }
            distance++;
        }
        return new int[]{farthestNode, distance};
    }

    public static int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        List<List<Integer>> adjList1 = getAdjacencyList(edges1, edges1.length+1);
        List<List<Integer>> adjList2 = getAdjacencyList(edges2, edges2.length+1);

        int tree1Diameter = getDiameter(adjList1, edges1.length+1);
        int tree2Diameter = getDiameter(adjList2, edges2.length+1);

        int combinedDiameter = ((tree1Diameter+1)/2) + ((tree2Diameter+1)/2) + 1;

        return Math.max(tree1Diameter, Math.max(tree2Diameter, combinedDiameter));
    }

    public static void main(String[] args) {
        System.out.println(minimumDiameterAfterMerge(
                new int[][]{
                        {0,1},
                        {0,2},
                        {0,3},
                        {2,4},
                        {2,5},
                        {3,6},
                        {2,7}
                }
        , new int[][]{
                        {0,1},
                        {0,2},
                        {0,3},
                        {2,4},
                        {2,5},
                        {3,6},
                        {2,7}
                }));
    }
}
