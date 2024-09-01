public class ConvertOneDArrayIntoTwoDArray {
    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[][]{};
        }

        int[][] twoDMatrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                twoDMatrix[i][j] = original[i * n + j];
            }
        }
        return twoDMatrix;
    }

    public static void main(String[] args) {
        int[][] result = construct2DArray(new int[]{1,2,3,4},2,2);

        for(int[] row : result) {
            for(int ele : row) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
