public class MaximumMatrixSum {

    public static long maxMatrixSum(int[][] matrix) {
        long sum = 0L;
        int negativeNumbers = 0;
        int smallestNumber = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int num : row) {
                sum += Math.abs(num);

                if (num < 0) {
                    negativeNumbers++;
                }

                smallestNumber = Math.min(smallestNumber, Math.abs(num));
            }
        }
        return (negativeNumbers % 2 == 0) ? sum : sum - 2L *smallestNumber;
    }

    public static void main(String[] args) {
        System.out.println(maxMatrixSum(new int[][]{
                {1,2,3},
                {-1,-2,-3},
                {1,2,3}
        }));
    }
}
