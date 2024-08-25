public class FindValidMatrixGivenRowAndColumnSums {

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        if(rowSum.length == 0 || colSum.length == 0) {
            return new int[][]{};
        }

        int[][] mat = new int[rowSum.length][colSum.length];

        int row = 0;
        int col = 0;

        while(row < rowSum.length && col < colSum.length) {
            mat[row][col] = Math.min(rowSum[row], colSum[col]);

            rowSum[row] -= mat[row][col];
            colSum[col] -= mat[row][col];

            if(rowSum[row] == 0) row++;
            if(colSum[col] == 0) col++;
        }
        return mat;

    }

    public static void main(String[] args) {
        int[][] result = restoreMatrix(new int[]{3,8}, new int[]{4,7});

        for(int[] row : result) {
            for(int ele : row) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
