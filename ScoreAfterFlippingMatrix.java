public class ScoreAfterFlippingMatrix {

    public static void toggleRow(int[][] grid, int row, int cols) {
        for(int i=0; i<cols; i++){
            grid[row][i] = (grid[row][i] == 0) ? 1 : 0;
        }
    }

    public static void toggleColumn(int[][] grid, int col, int rows) {
        for(int i=0; i<rows; i++) {
            grid[i][col] = (grid[i][col] == 0) ? 1 : 0;
        }
    }


    public static int matrixScore(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // check for rows if the first cell contains 0 then the flip the row
        for(int i=0; i<rows; i++) {
            if(grid[i][0] == 0) {
                toggleRow(grid, i, cols);
            }
        }

        // check for cols if the no. of zeros are greater than the number of ones
        for(int j=0; j < cols; j++) {
            int ones = 0;
            int zeros = 0;
            for(int i =0; i<rows; i++) {
                if(grid[i][j] == 0) {
                    zeros++;
                }else{
                    ones++;
                }
            }

            if(zeros > ones) {
                toggleColumn(grid, j, rows);
            }
        }

        // calculate the sum
        int sum = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                sum += (Math.pow(2, cols-1-j) * grid[i][j]);
            }
        }
        return sum;
        
    }


    public static void main(String[] args) {
        System.out.println(matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}}));
    }
}
