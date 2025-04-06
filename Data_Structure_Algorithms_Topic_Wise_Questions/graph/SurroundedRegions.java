package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

public class SurroundedRegions {

    public static void dfs(char[][] board, int row, int col, boolean[][] isVisited, int[] dr, int[] dc) {
        isVisited[row][col] = true;

        for(int i=0; i<4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && board[nr][nc] == 'O' && !isVisited[nr][nc]) {
                dfs(board, nr, nc, isVisited, dr, dc);
            }
        }

    }

    public static void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] isVisited = new boolean[rows][cols];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // start from the 0th row
        for(int c = 0; c<cols; c++) {
            if(board[0][c] == 'O' && !isVisited[0][c]) {
                dfs(board, 0, c, isVisited, dr, dc);
            }
        }

        // start from the 0th col
        for(int r=0; r<rows; r++) {
            if(board[r][0] == 'O' && !isVisited[r][0]) {
                dfs(board, r, 0, isVisited, dr, dc);
            }
        }

        // start from the last row
        for(int c = 0; c<cols; c++) {
            if(board[rows-1][c] == 'O' && !isVisited[rows-1][c]) {
                dfs(board, rows-1, c, isVisited, dr, dc);
            }
        }

        // start from the last col
        for(int r = 0; r<rows; r++) {
            if(board[r][cols-1] == 'O' && !isVisited[r][cols-1]) {
                dfs(board, r, cols-1, isVisited, dr, dc);
            }
        }

        for(int i=0; i<rows; i++) {
            for(int j = 0; j<cols; j++) {
                if(board[i][j] == 'O' && !isVisited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
