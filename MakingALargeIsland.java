public class MakingALargeIsland {

    public static void dfs(int row, int col, int[][] grid, int[] ans, int[] dx, int[] dy, boolean[][] isVisited) {
        isVisited[row][col] = true;
        ans[0]++;

        for(int i=0; i<4; i++) {
            int nr = row + dx[i];
            int nc = col + dy[i];

            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && grid[nr][nc] == 1 && !isVisited[nr][nc]) {
                dfs(nr, nc, grid, ans, dx, dy, isVisited);
            }
        }
    }

    public static int largestIsland(int[][] grid) {
        int len = grid.length;
        int maxArea = 0;

        boolean[][] isVisited = new boolean[len][len];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(grid[i][j] == 1 && !isVisited[i][j]) {
                    int[] ans = {0};
                    dfs(i, j, grid, ans, dx, dy, isVisited);

                    maxArea = Math.max(maxArea, ans[0]);
                }
            }
        }

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(grid[i][j] == 0) {
                    grid[i][j] = 1;
                    int[] ans = {0};
                    isVisited = new boolean[len][len];
                    dfs(i, j, grid, ans, dx, dy, isVisited);

                    maxArea = Math.max(maxArea, ans[0]);

                    grid[i][j] = 0;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestIsland(new int[][]{
                {1,0},
                {1,0}
        }));
    }
}
