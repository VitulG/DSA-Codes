public class NumberOfIslands {

    public static void dfs(char[][] grid, int row, int col, boolean[][] isVisited) {
        isVisited[row][col] = true;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        for(int i=0; i<4; i++) {
            int nr = row + dx[i];
            int nc = col + dy[i];
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1' && !isVisited[nr][nc]) {
                dfs(grid, nr, nc, isVisited);
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] isVisited = new boolean[rows][cols];
        int islands = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == '1' && !isVisited[i][j]) {
                    dfs(grid, i, j, isVisited);
                    islands+=1;
                }
            }
        }
        return islands;

    }



    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'}, {'0','0','0','0','0'}}));
    }


}