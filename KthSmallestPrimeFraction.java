import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {

    static class Pair {
        int first;
        int second;
        double fraction;

        public Pair(int first, int second, double fraction) {
            this.first = first;
            this.second = second;
            this.fraction = fraction;
        }
    }

    static class SortFraction implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return Double.compare(p1.fraction, p2.fraction);
        }
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(new SortFraction());

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                int first = arr[i];
                int second = arr[j];
                double fraction = (double) (first*1.0/second);
                queue.offer(new Pair(first, second, fraction));
            }
        }

        int[] ans = new int[2];

        while(k-- > 0) {
            Pair pair = queue.poll();
            ans[0] = pair.first;
            ans[1] = pair.second;
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] ans = kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3);
        System.out.println(ans[0]+" "+ans[1]);
    }   
}
