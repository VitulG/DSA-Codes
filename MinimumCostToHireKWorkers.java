import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {

    static class Pair {
        int quality;
        double ratio;

        public Pair(int quality, double ratio) {
            this.quality = quality;
            this.ratio   = ratio;
        }
    }

    static class SortPairs implements Comparator<Pair> {

        @Override
        public int compare(Pair p1, Pair p2) {
            return Double.compare(p1.ratio, p2.ratio);
        }

    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int size = quality.length;
        Pair[] pairs = new Pair[size];

        for(int i=0; i<size; i++) {
            double ratio = (double) wage[i] / quality[i];
            pairs[i] = new Pair(quality[i], ratio);
        }
        
        Arrays.sort(pairs, new SortPairs());

        double minCost = Double.MAX_VALUE;
        int totalQuality = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(Pair worker : pairs) {
            totalQuality += worker.quality;
            queue.offer(worker.quality);

            if(queue.size() > k) {
                totalQuality -= queue.poll();
            }

            if(queue.size() == k) {
                minCost = Math.min(minCost, totalQuality*worker.ratio);
            }
        }
        return minCost;
    }
    
    public static void main(String[] args) {
        System.out.println(mincostToHireWorkers(new int[]{10,20,5}, new int[]{70,50,30}, 2));
    }
}



