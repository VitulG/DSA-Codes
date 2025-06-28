import java.util.*;

public class FindSubsequenceOfLengthKWithTheLargestSum {
    static class Pair {
        int number;
        int index;

        public Pair(int num, int idx) {
            this.number = num;
            this.index = idx;
        }
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        if(nums.length == 0 || nums.length < k) {
            return new int[]{};
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.number - b.number);

        for(int i=0; i< nums.length; i++) {
            queue.offer(new Pair(nums[i], i));

            if(queue.size() > k) {
                queue.poll();
            }
        }

        List<Pair> topKPairs = new ArrayList<>();

        while(!queue.isEmpty()) {
            topKPairs.add(queue.poll());
        }

        topKPairs.sort((a, b) -> a.index - b.index);

        int[] ans = new int[topKPairs.size()];

        for(int i=0; i< topKPairs.size(); i++) {
            ans[i] = topKPairs.get(i).number;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSubsequence(new int[]{3,4,3,3}, 2)));
    }
}
