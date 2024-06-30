import java.util.Arrays;
import java.util.Comparator;

class DSU {
    private int[] parent;
    private int[] size;
    private int component;

    public DSU(int size) {
        this.parent = new int[size+1];
        this.size = new int[size+1];
        this.component = size;

        for(int i=1; i<=size; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int findParent(int node) {
        if(node == this.parent[node]) {
            return node;
        }
        return this.parent[node] = findParent(this.parent[node]);
    }

    public void unionComponents(int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);

        if(this.size[parentV] > this.size[parentU]) {
            this.parent[parentU] = parentV;
            this.size[parentV] += this.size[parentU];
        }else {
            this.parent[parentV] = parentU;
            this.size[parentU] += this.size[parentV];
        }
        this.component--;
    }

    public int getComponent() {
        return this.component;
    }
}
public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {

    static class SortEdges implements Comparator<int[]> {
        @Override
        public int compare(int[] arr1, int[] arr2) {
            return arr2[0] - arr1[0];
        }
    }

    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        Arrays.sort(edges, new SortEdges());

        int edgeCount = 0;

        for(int[] edge : edges) {
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];

            if(type == 3) {

                boolean hasAdded = false;
                if(alice.findParent(u) != alice.findParent(v)) {
                    alice.unionComponents(u,v);
                    hasAdded = true;
                }

                if(bob.findParent(u) != bob.findParent(v)) {
                    bob.unionComponents(u,v);
                    hasAdded = true;
                }

                if(hasAdded) {
                    edgeCount++;
                }
            }else if(type == 2) {
                if(bob.findParent(u) != bob.findParent(v)) {
                    bob.unionComponents(u,v);
                    edgeCount++;
                }
            }else{
                if(alice.findParent(u) != alice.findParent(v)) {
                    alice.unionComponents(u,v);
                    edgeCount++;
                }
            }
        }

        if(alice.getComponent() == 1 && bob.getComponent() == 1) {
            return edges.length - edgeCount;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(maxNumEdgesToRemove(4, new int[][]{{3,1,2},{3,2,3},{1,1,3},
                                    {1,2,4},{1,1,2},{2,3,4}}));
    }
}
