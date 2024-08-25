import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuildAMatrixWithConditions {

    public static List<List<Integer>> getAdjacencyList(int k, int[][] rows) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for(int i=0; i<=k; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int[] row : rows) {
            graph.get(row[0]).add(row[1]);
        }
        return graph;
    }

    public static int[] toposort(int k, List<List<Integer>> graph) {
        int[] indegree = new int[k+1];
        Arrays.fill(indegree, 0);

        for(int i=1; i<=k; i++) {
            for(int nbr : graph.get(i)) {
                indegree[nbr]++;
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;

        for(int i=1; i<=k; i++) {
            if(indegree[i]==0) {
                queue.offer(i);
                count++;
            }
        }

        int[] ans = new int[k];
        int idx = -1;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            ans[++idx] = node;

            for(int nbr : graph.get(node)) {
                indegree[nbr]--;
                if(indegree[nbr] == 0) {
                    queue.offer(nbr);
                    count++;
                }
            }
        }
        return (count == k) ? ans : new int[]{};
    }

    
    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        if(rowConditions.length <= 0 || colConditions.length <= 0) {
            return new int[][]{};
        }

        List<List<Integer>> rowGraph = getAdjacencyList(k, rowConditions);
        List<List<Integer>> colGraph = getAdjacencyList(k, colConditions);

        int[] rows = toposort(k, rowGraph);
        if(rows.length == 0) {
            return new int[][]{};
        }

        int[] cols = toposort(k, colGraph);
        if(cols.length == 0) {
            return new int[][]{};
        }

        int[][] ans = new int[k][k];

        for(int row = 0; row < rows.length; row++) {
            for(int col = 0; col < cols.length; col++) {
                if(cols[col] == rows[row]) {
                    ans[row][col] = rows[row];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] result = buildMatrix(3, new int[][]{{1,2},{3,2}}, new int[][]{{2,1},{3,2}});

        for(int[] row : result) {
            for(int ele : row) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
