package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.PriorityQueue;

public class MinimumCostToConnectAllHousesInACity {

    public static int minCost(int[][] houses) {
        int nodes = houses.length;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        queue.offer(new int[]{0,0});

        boolean[] isVisited = new boolean[nodes];

        int minCost = 0;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();

            int src = node[0];
            int distance = node[1];

            if(isVisited[src]) {
                continue;
            }

            isVisited[src] = true;
            minCost += distance;

            for(int dst=0; dst<nodes; dst++) {
                if(!isVisited[dst]) {
                    int newDistance = Math.abs(houses[src][0] - houses[dst][0]) +
                            Math.abs(houses[src][1] - houses[dst][1]);
                    queue.offer(new int[]{dst, newDistance});
                }
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{
                {0, 7},
                {0, 9},
                {20, 7},
                {30, 7},
                {40, 70}
        }));
    }
}
