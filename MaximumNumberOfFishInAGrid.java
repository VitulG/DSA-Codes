public class MaximumNumberOfFishInAGrid {

    public static void dfs(int[][] grid, int row, int col, int[] dx, int[] dy, int[] currFishCount) {
        currFishCount[0] += grid[row][col];

        grid[row][col] = 0;

        for(int i = 0; i<4; i++) {
            int nr = dx[i] + row;
            int nc = dy[i] + col;

            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && grid[nr][nc] != 0) {
                dfs(grid, nr, nc, dx, dy, currFishCount);
            }
        }
    }

    public static int findMaxFish(int[][] grid) {
        int maxFish = Integer.MIN_VALUE;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int r = 0; r<grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] != 0) {
                    int[] currentFishCount = {0};
                    dfs(grid, r, c, dx, dy, currentFishCount);
                    maxFish = Math.max(maxFish, currentFishCount[0]);
                }
            }
        }
        return (maxFish == Integer.MIN_VALUE) ? 0 : maxFish;
    }

    public static void main(String[] args) {
        System.out.println(findMaxFish(new int[][]{
                {0,2,1,0},
                {4,0,0,3},
                {1,0,0,4},
                {0,3,2,0}
        }));
    }
}
