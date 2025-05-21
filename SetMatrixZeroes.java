import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {

    static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void setZeroes(int[][] matrix) {
        if(matrix.length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Cell> zeroCells = new ArrayList<>();

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(matrix[row][col] == 0) {
                    zeroCells.add(new Cell(row, col));
                }
            }
        }

        for(Cell cell : zeroCells) {
            int row = cell.row;
            int col = cell.col;

            for(int c = 0; c < cols; c++) {
                matrix[row][c] = 0;
            }

            for(int r = 0; r < rows; r++) {
                matrix[r][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5},
        };

        setZeroes(matrix);

        for(int[] row : matrix) {
            for(int val : row) {
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
}
