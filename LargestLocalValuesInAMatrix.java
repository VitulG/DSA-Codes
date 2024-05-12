public class LargestLocalValuesInAMatrix {

    public static int[][] largestLocal(int[][] grid) {
        int size = grid.length;
        int[][] result = new int[size-2][size-2];

        for(int i=1; i<size-1; i++) {
            for(int j=1; j<size-1; j++) {
                int temp = Integer.MIN_VALUE;

                for(int k = i-1; k <= i+1; k++) {
                    for(int l = j-1; l <= j+1; l++) {
                        temp = Math.max(temp, grid[k][l]);
                    }
                }
                result[i-1][j-1] = temp;

            }
        }
        return result;
        
    }

    public static void main(String[] args) {
        int[][] ans = largestLocal(new int[][]{{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}});

        for(int[] row : ans) {
            for(int ele : row) {
                System.out.print(ele +" ");
            }
            System.out.println();
        }
    }
    
}
