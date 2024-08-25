import java.util.Arrays;

public class MaximumTotalImportanceOfRoads {

    public static long maximumImportance(int cities, int[][] roads) {
        int[] degree = new int[cities];

        for(int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        Arrays.sort(degree);

        long value = 1;
        long sum = 0l;

        for(int i : degree) {
            sum += (i * value);
            value++;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(maximumImportance(5, new int[][]{{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));
    }
}
