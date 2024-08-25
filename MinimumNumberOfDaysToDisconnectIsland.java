public class MinimumNumberOfDaysToDisconnectIsland {

    public static void dfs(int[][] grid, int row, int col, boolean[][] isVisited) {
        isVisited[row][col] = true;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        for(int i=0; i<4; i++) {
            int nr = row+dx[i];
            int nc = col+dy[i];

            if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1 && !isVisited[nr][nc]) {
                dfs(grid, nr, nc, isVisited);
            }
        }
    }

    public static boolean isDisconnected(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] isVisitedCell = new boolean[rows][cols];
        boolean hasLands = false;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1 && !isVisitedCell[i][j]) {
                    if(hasLands) {
                        return true;
                    }
                    dfs(grid, i, j, isVisitedCell);
                    hasLands = true;
                }
            }
        }
        return !hasLands;
    }

    public static int minDays(int[][] grid) {
        int islands = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1 && !isVisited[i][j]) {
                    dfs(grid, i, j, isVisited);
                    islands++;
                }
            }
        }

        if(islands > 1 || islands == 0) {
            return 0;
        }

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if(isDisconnected(grid)) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[][]{{1,1,0,1,1},{1,1,1,1,1},{1,1,0,1,1},{1,1,0,1,1}}));
    }
}