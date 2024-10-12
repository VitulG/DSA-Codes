import java.util.*;

public class DivideIntervalsIntoMinimumNumberOfGroups {

    static class SortIntervals implements Comparator<int[]> {

        @Override
        public int compare(int[] i1, int[] i2) {
            return i1[0] - i2[0];
        }
    }


    public static int minGroups(int[][] intervals) {
        Arrays.sort(intervals, new SortIntervals());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int[] interval : intervals) {
            // agar interval the start time previous waale se jayada hai to vo ek group main reh sakte hai
            if(!queue.isEmpty() && queue.peek() < interval[0]) {
                queue.poll();
            }
            // end time push kar do varna
            queue.offer(interval[1]);
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {{5,10},{6,8},{1,5},{2,3},{1,10}};
        System.out.println(minGroups(intervals)); // Output: 3
    }
}
