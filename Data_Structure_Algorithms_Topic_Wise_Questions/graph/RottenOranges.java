package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int rottingOranges(int[][] grid) {
        Queue<Cell> queue = new ArrayDeque<>();

        int freshOranges = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    freshOranges++;
                }

                if(grid[i][j] == 2) {
                    queue.offer(new Cell(i, j));
                }
            }
        }

        if(freshOranges == 0) {
            return 0;
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int minutes = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean isFreshOrangesAvailable = false;

            for(int i=0; i<size; i++) {
                Cell cell = queue.poll();

                for(int j=0; j<4; j++) {
                    int nr = cell.row + dr[j];
                    int nc = cell.col + dc[j];

                    if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && grid[nr][nc] == 1) {
                        freshOranges--;
                        grid[nr][nc] = 2;
                        isFreshOrangesAvailable = true;
                        queue.offer(new Cell(nr, nc));
                    }

                }

            }
            if(isFreshOrangesAvailable) {
                minutes++;
            }
        }
        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        System.out.println(rottingOranges(new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1}
        }));
    }
}
