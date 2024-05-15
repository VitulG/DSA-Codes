import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindTheSafestPathInAGrid {
    static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static boolean isPossibleSafenessFactor(int currentSafenessFactor, int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        boolean[][] isVisited = new boolean[rows][cols];

        if(mat[0][0] < currentSafenessFactor) {
            return false;
        }
        
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(0, 0));
        isVisited[0][0] = true;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int currRow = pair.row;
            int currCol = pair.col;

            if(currRow == rows-1 && currCol == cols-1) {
                return true;
            }

            for(int i=0; i<4; i++) {
                int nr = currRow + dx[i];
                int nc = currCol + dy[i];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && !isVisited[nr][nc] && mat[nr][nc] >= currentSafenessFactor) {
                    isVisited[nr][nc] = true;
                    queue.offer(new Pair(nr, nc));
                }
            }
        }
        return false;

    }

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int rows = grid.size();
        int cols = grid.get(0).size();
        
        Queue<Pair> queue = new LinkedList<Pair>();
        boolean[][] isVisited = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid.get(i).get(j) == 1) {
                    isVisited[i][j] = true;
                    queue.offer(new Pair(i, j));
                }
            }
        }
        
        int[][] mat = new int[rows][cols];
        int level = 0;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                
                Pair pair = queue.poll();
                mat[pair.row][pair.col] = level;
                
                for(int j=0; j<4; j++) {
                    int nr = pair.row + dx[j];
                    int nc = pair.col + dy[j];

                    if(nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && !isVisited[nr][nc]) {
                        isVisited[nr][nc] = true;
                        queue.offer(new Pair(nr, nc));
                    }
                }
            }
            level++;
        }

        // binary search on safest Path
        int lo = 0;
        int hi = 400;

        int safenessFactor = 0;

        while(lo <= hi) {
            int mid = lo + (hi-lo) / 2;

            if(isPossibleSafenessFactor(mid, mat)) {
                safenessFactor = mid;
                lo = mid+1;
            }else{
                hi = mid -1;
            }
        }
        return safenessFactor;
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<List<Integer>>();

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(1);
        list1.add(1);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(0);
        list2.add(1);
        list2.add(1);

        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(0);
        list3.add(0);
        list3.add(0);

        grid.add(list1);
        grid.add(list2);
        grid.add(list3);
    

        System.out.println(maximumSafenessFactor(grid));

    }
    
}
