package Data_Structure_Algorithms_Topic_Wise_Questions.queue;

import java.util.ArrayDeque;
import java.util.Queue;

class RecentCounter {
    private final Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        this.queue.offer(t);

        while(!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        return this.queue.size();
    }
}


public class NumberOfRecentCalls {
}
