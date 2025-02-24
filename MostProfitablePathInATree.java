import java.util.*;

public class MostProfitablePathInATree {

    public static List<List<Integer>> getAdjacencyList(int nodes, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i =0; i<nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public static boolean dfsForBob(int bobPosition, List<List<Integer>> adjList, boolean[] isVisited, int[] timer,
                                 Map<Integer, Integer> bobTimeToVisitNode) {

        isVisited[bobPosition] = true;
        bobTimeToVisitNode.putIfAbsent(bobPosition, timer[0]++);

        if(bobPosition == 0) {
            return true;
        }

        for(int nbr : adjList.get(bobPosition)) {
            if(!isVisited[nbr]) {
                if(dfsForBob(nbr, adjList, isVisited, timer, bobTimeToVisitNode)) {
                    return true;
                }
            }
        }

        bobTimeToVisitNode.remove(bobPosition);
        return false;
    }

    public static void dfsForAlice(int alicePosition, List<List<Integer>> adjList, boolean[] isVisited, int timer,
                                   Map<Integer, Integer> bobTimeToVisitNode, int[] amount, int currAmount, int[] aliceIncome) {
        isVisited[alicePosition] = true;
        int bobTimeToReachThisNode = bobTimeToVisitNode.getOrDefault(alicePosition, Integer.MAX_VALUE);

        if(timer < bobTimeToReachThisNode) {
            currAmount += amount[alicePosition];
        }else if(timer == bobTimeToReachThisNode) {
            currAmount += (amount[alicePosition] / 2);
        }

        if(adjList.get(alicePosition).size() == 1 && alicePosition != 0) {
            aliceIncome[0] = Math.max(aliceIncome[0], currAmount);
        }

        for(int nbr : adjList.get(alicePosition)) {
            if(!isVisited[nbr]) {
                dfsForAlice(nbr, adjList, isVisited, timer+1, bobTimeToVisitNode, amount, currAmount, aliceIncome);
            }
        }

    }

    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> adjList = getAdjacencyList(n, edges);

        // Dfs for bob;
        Map<Integer, Integer> bobTimeToVisitNode = new HashMap<>();
        boolean[] isVisited = new boolean[n];
        int[] timer = {0};

        dfsForBob(bob, adjList, isVisited, timer, bobTimeToVisitNode);

        Arrays.fill(isVisited, false);

        int[] aliceIncome = {Integer.MIN_VALUE};
        dfsForAlice(0, adjList, isVisited, 0, bobTimeToVisitNode, amount, 0, aliceIncome);

        return aliceIncome[0];
    }

    public static void main(String[] args) {
        System.out.println(mostProfitablePath(new int[][]{
                {0,1},
                {1,2},
                {2,3}
        }, 3, new int[]{-5644,-6018,1188,-8502}));
    }
}
