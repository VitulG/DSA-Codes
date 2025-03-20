public class MinimumCostWalkInWeightedGraph {

    public static int findParent(int[] parent, int num) {
        if(parent[num] == num) {
            return num;
        }
        return parent[num] = findParent(parent, parent[num]);
    }

    public static void union(int src, int dst, int[] parent, int[] size, int[] cost, int wt) {
        int srcParent = findParent(parent, src);
        int dstParent = findParent(parent, dst);

        if(srcParent != dstParent) {
            if(size[srcParent] > size[dstParent]) {
                parent[dstParent] = srcParent;
                size[srcParent] += size[dstParent];
                cost[srcParent] &= cost[dstParent];
            }else {
                parent[srcParent] = dstParent;
                size[dstParent] += size[srcParent];
                cost[dstParent] &= cost[srcParent];
            }
        }
        cost[srcParent] &= wt;
        cost[dstParent] &= wt;
    }

    public static int[] minimumCost(int n, int[][] edges, int[][] queries) {
        int[] parent = new int[n];
        int[] size = new int[n];
        int[] cost = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
            cost[i] = -1;
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if(findParent(parent, u) != findParent(parent, v)) {
                union(u, v, parent, size, cost, wt);
            }
        }

        int[] ans = new int[queries.length];
        int idx = 0;

        for(int[] query : queries) {
            int src = query[0];
            int dst = query[1];

            if(findParent(parent, src) != findParent(parent, dst)) {
                ans[idx++] = -1;
            }else if(src == dst) {
                ans[idx++] = 0;
            } else {
                ans[idx++] = cost[findParent(parent, src)];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = minimumCost(5, new int[][]{
                {0,1,7},
                {1,3,7},
                {1,2,1}
        }, new int[][]{
                {0,3},
                {3,4}
        });

        for(int val : ans) {
            System.out.print(val+" ");
        }
    }
}
