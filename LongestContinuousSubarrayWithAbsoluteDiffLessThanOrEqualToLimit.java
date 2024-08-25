import java.util.Collections;
import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    static class Pair implements Comparable<Pair>{
        int element;
        int index;

        public Pair(int element, int index) {
            this.element = element;
            this.index = index;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(this.element, pair.element);
        }
    }

    public static int longestSubarray(int[] nums, int limit) {
        int maxSubArray = 0;

        PriorityQueue<Pair> min = new PriorityQueue<Pair>();
        PriorityQueue<Pair> max = new PriorityQueue<Pair>(Collections.reverseOrder());

        int i = 0;
        int j = 0;

        while(j < nums.length) {
            min.offer(new Pair(nums[j], j));
            max.offer(new Pair(nums[j], j));

            if(Math.abs((min.peek().element - max.peek().element)) <= limit) {
                maxSubArray = Math.max(maxSubArray, j - i + 1);
                min.offer(new Pair(nums[j], j));
                max.offer(new Pair(nums[j], j));
                j++;
            }else{
                int minIdx = Math.min(min.peek().index, max.peek().index);
                i = minIdx + 1;

                while(min.peek().index < i) {
                    min.poll(); 
                }

                while(max.peek().index < i) {
                    max.poll();
                }
            }
        }
        return maxSubArray;

    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0));
    }
}
