package Data_Structure_Algorithms_Topic_Wise_Questions.backtracking;

public class RatMazeWithMultipleJumps {

    public static boolean generatePaths(int[][] maze, int r, int c, int destination, int[][] board) {
        if(r == destination && c == destination) {
            board[r][c] = 1;
            return true;
        }

        if(r < 0 || c < 0 || r >= maze.length || c >= maze[0].length || maze[r][c] == 0) {
            return false;
        }

        int steps = maze[r][c];
        board[r][c] = 1;

        for(int i=1; i<=steps; i++) {
            if(generatePaths(maze, r, c+i, destination, board)) {
                return true;
            }

            if(generatePaths(maze, r+i, c, destination, board)) {
                return true;
            }
        }
        board[r][c] = 0;
        return false;
    }

    public static void solve(int[][] maze, int N) {
        int[][] board = new int[N][N];

        if(!generatePaths(maze, 0, 0, N-1, board)) {
            System.out.println("-1");
            return;
        }

        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze[0].length; j++) {
                if(board[i][j] == 1) {
                    maze[i][j] = 1;
                }else {
                    maze[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
