import java.util.Arrays;
import java.util.Comparator;

public class MostProfitAssigningWork {

    static class Pair {
        int job;
        int difficulty;
        int profit;

        public Pair(int job, int difficulty, int profit) {
            this.job = job;
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }

    static class PairSorter implements Comparator<Pair> {

        @Override
        public int compare(Pair p1, Pair p2) {
            return p1.difficulty - p2.difficulty;
        }
        
    }

    public static int getMinWorkerAbility(int worker, Pair[] pair) {
        int idx = -1;
        int left = 0;
        int right = pair.length-1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(pair[mid].difficulty <= worker) {
                idx = mid;
                left = mid + 1;
            }else {
                right = mid-1;
            }
        }
        return idx;
    }

    public static int maxProfitAssignment(int[] difficulties, int[] profits, int[] workers) {
        int maxProfit = 0;
        int len = difficulties.length;

        Pair[] pairs = new Pair[len];

        for(int i=0; i<len; i++) {
            pairs[i] = new Pair(i, difficulties[i], profits[i]);
        }

        Arrays.sort(pairs, new PairSorter());

        // preprocessed the max profit
        int currProfit = Integer.MIN_VALUE;
        for(Pair pair : pairs) {
            currProfit = Math.max(currProfit, pair.profit);
            pair.profit = currProfit;
        }
        
        for(int worker : workers) {
            int idx = getMinWorkerAbility(worker, pairs);
            if(idx != -1) {
                maxProfit += pairs[idx].profit; 
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(new int[]{68,35,52,47,86}, new int[]{67,17,1,81,3},
         new int[]{92,10,85,84,82}));

         // difficulties => 35 47 52 68 86
         // profit =>       17 81 81 81 81 
    }
}
