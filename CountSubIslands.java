public class CountSubIslands {

    public static boolean dfs(int[][] grid1, int[][] grid2, int row, int col, boolean[][] isVisited) {
        isVisited[row][col] = true;
        boolean isSubIsland = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i=0; i<4; i++) {
            int nr = row + dx[i];
            int nc = col + dy[i];

            if(nr >= 0 && nc >= 0 && nr < grid1.length && nc < grid1[0].length && grid2[nr][nc] == 1 &&
                    !isVisited[nr][nc]) {
                boolean result = dfs(grid1, grid2, nr, nc, isVisited);

                if(!result) {
                    isSubIsland = false;
                }
            }
        }

        if(grid1[row][col] == 0) {
            isSubIsland = false;
        }
        return isSubIsland;
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length;
        int cols = grid1[0].length;

        int subIslands = 0;

        boolean[][] isVisited = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid2[i][j] == 1 && !isVisited[i][j]) {
                    if(dfs(grid1, grid2, i, j, isVisited)) {
                        subIslands++;
                    }
                }
            }
        }
        return subIslands;
    }

    public static void main(String[] args) {
        System.out.println(countSubIslands(new int[][]{{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},
                {1,1,0,1,1}}, new int[][]{{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}}));
    }
}
