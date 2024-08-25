public class SpiralMatrixIII {

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        int[][] matrix = new int[rows*cols][2];

        int steps = 0;
        int direction = 0;

        matrix[0] = new int[]{rStart, cStart};
        int size = 1;

        while(size < rows * cols) {
            if(direction == 0 || direction == 2) {
                steps++;
            }

            for(int i=0; i<steps; i++) {
                rStart += directions[direction][0];
                cStart += directions[direction][1];

                if(rStart < rows && rStart >= 0 && cStart < cols && cStart >= 0) {
                    matrix[size++] = new int[]{rStart, cStart};
                }
            }
            direction = (direction+1)%4;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = spiralMatrixIII(5, 6, 1, 4);

        for(int[] row : matrix) {
            for(int ele : row) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
