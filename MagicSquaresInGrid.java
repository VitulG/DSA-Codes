public class MagicSquaresInGrid {

    private static boolean isValidMagicSquare(int row, int col, int[][] grid) {
        // check for unique numbers in the grid
        boolean[] hasSaw = new boolean[10];
        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                int number = grid[row+i][col+j];
                if(number < 1 || number > 9 || hasSaw[number]) {
                    return false;
                }
                hasSaw[number] = true;
            }
        }

        // Check the sums of rows, columns, and diagonals
        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != sum) {
                return false;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (grid[row][col + j] + grid[row + 1][col + j] + grid[row + 2][col + j] != sum) {
                return false;
            }
        }

        // Check diagonals
        if (grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != sum) {
            return false;
        }
        if (grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] != sum) {
            return false;
        }

        return true;
    }


    public static int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int magicGrids = 0;

        for(int i=0; i<rows-2; i++) {
            for(int j=0; j<cols-2; j++) {
                if(isValidMagicSquare(i, j, grid)) {
                    magicGrids++;
                }
            }
        }
        return magicGrids;
    }

    public static void main(String[] args) {
        System.out.println(numMagicSquaresInside(new int[][]{{4,3,8,4},{9,5,1,9},{2,7,6,2}}));
    }
}