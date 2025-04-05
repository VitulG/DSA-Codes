package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

    public static void dfs(char[][] grid, int r, int c, boolean[][]  isVisited, int[] dr, int[] dc) {
        isVisited[r][c] = true;

        for(int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1' && !isVisited[nr][nc]) {
                dfs(grid, nr, nc, isVisited, dr, dc);
            }
        }

    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] isVisited = new boolean[rows][cols];

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        int islands = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == '1' && !isVisited[i][j]) {
                    dfs(grid, i, j, isVisited, dr, dc);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }));
    }
}
