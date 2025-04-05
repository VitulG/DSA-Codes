package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

public class FindTheNumberOfIslands {

    public static void dfs(char[][] grid, int row, int col, boolean[][] isVisited, int[] dr, int[] dc) {
        isVisited[row][col] = true;

        for(int i=0; i<8; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && !isVisited[nr][nc] && grid[nr][nc] == 'L') {
                dfs(grid, nr, nc, isVisited, dr, dc);
            }
        }
    }

    public static int countIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] isVisited = new boolean[rows][cols];

        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        int islands = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 'L' && !isVisited[i][j]) {
                    dfs(grid, i, j, isVisited, dr, dc);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        System.out.println(countIslands(new char[][]{
                {'L','L','W','W','W'},
                {'W','L','W','W','L'},
                {'L', 'W', 'W', 'L', 'L'},
                {'W', 'W', 'W', 'W', 'W'},
                {'L', 'W', 'L', 'L', 'W'}
        }));
    }
}
