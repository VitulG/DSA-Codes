import java.util.Collections;
import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {

    public static long maxKElements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums) {
            maxHeap.offer(num);
        }

        long maxScore = 0;

        while(k-- > 0) {
            int num = maxHeap.poll();
            maxScore += num;
            int reducedNum = (int) Math.ceil(num / 3.0);
            maxHeap.offer(reducedNum);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        System.out.println(maxKElements(new int[]{1,10,3,3,3}, 3));
    }
}
