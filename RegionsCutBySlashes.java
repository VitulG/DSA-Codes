public class RegionsCutBySlashes {

    public static void dfs(int[][] matrix, int row, int col, boolean[][] isVisited) {
        isVisited[row][col] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 0; i<4; i++) {
            int nr = row+dx[i];
            int nc = col+dy[i];

            if(nr >= 0 && nc >= 0 && nr < matrix.length && nc < matrix[0].length && matrix[nr][nc] == 0 && !isVisited[nr][nc]) {
                dfs(matrix, nr, nc, isVisited);
            }
        }
    }

    public static int regionsBySlashes(String[] grid) {
        if(grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length();

        int[][] matrix = new int[rows*3][cols*3];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i].charAt(j) == '/') {
                    matrix[i*3][j*3+2] = 1;
                    matrix[i*3+1][j*3+1] = 1;
                    matrix[i*3+2][j*3] = 1;
                }else if(grid[i].charAt(j) == '\\') {
                    matrix[i*3][j*3] = 1;
                    matrix[i*3+1][j*3+1] = 1;
                    matrix[i*3+2][j*3+2] = 1;
                }
            }
        }

        // now applying dfs
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];

        int regions = 0;

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 0 && !isVisited[row][col]) { 
                    dfs(matrix, row, col, isVisited);
                    regions++;
                }
            }
        }
        return regions;

    }

    public static void main(String[] args) {
        System.out.println(regionsBySlashes(new String[]{" /","  "}));
    }
}