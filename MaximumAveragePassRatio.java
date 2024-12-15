import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
    private static double getRatio(int pass, int total) {
        return pass+1 / (double) total+1 - (double) pass / total;
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->
                Double.compare(getRatio(b[0], b[1]), getRatio(a[0], a[1])));

        for(int[] schoolClass : classes) {
            queue.offer(schoolClass);
        }

        while(extraStudents > 0) {
            if(!queue.isEmpty()) {
                int[] schoolClass = queue.poll();
                schoolClass[0]++;
                schoolClass[1]++;
                queue.offer(schoolClass);
                extraStudents--;
            }
        }

        double maxAvgClassRatio = 0.0d;

        while(!queue.isEmpty()) {
            int[] schoolClass = queue.poll();
            maxAvgClassRatio += (double) schoolClass[0] / schoolClass[1];
        }
        return maxAvgClassRatio / classes.length;
    }

    public static void main(String[] args) {
        System.out.println(maxAverageRatio(new int[][]{
                {1,2},
                {3,5},
                {2,2}
        }, 2));
    }
}
