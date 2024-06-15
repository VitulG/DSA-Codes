import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    static class Pair {
        int project;
        int profit;
        int capital;

        public Pair(int project, int profit, int capital) {
            this.project = project;
            this.profit = profit;
            this.capital = capital;
        }

    }

    static class SortProjects implements Comparator<Pair> {

        @Override
        public int compare(Pair p1, Pair p2) {
            return p1.capital - p2.capital;
        }
        
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capitals) {
        int size = profits.length;

        Pair[] vector = new Pair[size];

        for(int i=0; i<size; i++) {
            vector[i] = new Pair(i, profits[i], capitals[i]);
        }

        Arrays.sort(vector, new SortProjects());

        int maxCapital = w;
        int start = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());

        while(k-- > 0) {
            while(start < size && vector[start].capital <= maxCapital) {
                queue.offer(vector[start].profit);
                start++;
            }
            if(queue.isEmpty()) {
                break;
            }
            maxCapital += queue.poll();
        }
        return maxCapital;

    } 

    public static void main(String[] args) {
        System.out.println(findMaximizedCapital(2, 100, new int[]{1,2,3}, new int[]{1110,111,1111}));
    }
}
