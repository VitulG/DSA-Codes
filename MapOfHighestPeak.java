import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MapOfHighestPeak {

    public static int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;

        int[][] newHeights = new int[rows][cols];

        for(int[] row : newHeights) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(isWater[i][j] == 1) {
                    queue.offer(new int[]{i,j});
                    newHeights[i][j] = 0;
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int[] cell = queue.poll();
                assert cell != null;
                int currRow = cell[0];
                int currCol = cell[1];

                for(int j = 0; j < 4; j++) {
                    int newRow = currRow + dx[j];
                    int newCol = currCol + dy[j];

                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && newHeights[newRow][newCol] == -1) {
                        newHeights[newRow][newCol] = newHeights[currRow][currCol] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return newHeights;
    }

    public static void main(String[] args) {
        int[][] newHeights = highestPeak(new int[][]{
                {0,0,1},
                {1,0,0},
                {0,0,0}
        });

        for(int[] height : newHeights) {
            for(int ele : height) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
