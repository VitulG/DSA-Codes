import java.util.HashSet;
import java.util.Set;

class UnionFind {
    private int[] parent;
    private int[] size;
    private int group;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        this.group = 0;

        for(int i=0; i<n; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int findParent(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = findParent(parent[x]); // path compression
    }

    public void union(int x, int y) {
        int findParentX = findParent(x);
        int findParentY = findParent(y);

        if(size[findParentX] < size[findParentY]) {
            parent[findParentX] = findParentY;
            size[findParentY] += size[findParentX];
        }else {
            parent[findParentY] = findParentX;
            size[findParentX] += size[findParentY];
        }
    }

    public int getCount() {
        for(int i=0; i<parent.length; i++) {
            if(parent[i] == i) {
                group++;
            }
        }
        return group;
    }
}
public class MostStonesRemovedWithSameRowOrColumn {

    public static int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind unionFind = new UnionFind(n);

        // time complexity is O(n^2)
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    unionFind.union(i, j); // union complexity is O(4*alpha)
                }
            }
        }
        return n - unionFind.getCount();  // O(n) for finding the groups
    }

    public static void main(String[] args) {
        System.out.println(removeStones(new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}}));
    }
}
