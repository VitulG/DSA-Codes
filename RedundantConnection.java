public class RedundantConnection {

    public static int findParent(int node, int[] parent) {
        if(node == parent[node]) {
            return node;
        }
        return parent[node] = findParent(parent[node], parent);
    }

    public static void unionBySize(int src, int dst, int[] parent, int[] size) {
        int srcParent = findParent(src, parent);
        int dstParent = findParent(dst, parent);

        if(dstParent > srcParent) {
            parent[srcParent] = dstParent;
            size[dstParent] += size[srcParent];
        }else {
            parent[dstParent] = srcParent;
            size[srcParent] += size[dstParent];
        }

    }

    public static int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;

        int[] parent = new int[len+1];
        int[] size = new int[len+1];

        for(int i=1; i<=len; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];

            if(findParent(src, parent) == findParent(dst, parent)) {
                return edge;
            }
            unionBySize(src, dst, parent, size);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result = findRedundantConnection(new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {1,4},
                {1,5}
        });

        System.out.println(result[0]+" "+result[1]);
    }
}
