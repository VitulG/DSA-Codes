import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValueII {

    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();

        int idx = 0;

        for(int num : nums) {
            queue.offer((long) nums[idx++]);
        }

        int minOps = 0;

        while(queue.size() > 1 && queue.peek() < k) {
            minOps++;

            long firstMin = queue.poll();
            long secondMin = queue.poll();

            long newNum = (Math.min(firstMin, secondMin) * 2) + Math.max(firstMin, secondMin);

            queue.offer(newNum);

        }
        return minOps;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1,1,2,4,9}, 20));
    }
}
