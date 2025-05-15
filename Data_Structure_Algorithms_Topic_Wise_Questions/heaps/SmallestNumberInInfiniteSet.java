package Data_Structure_Algorithms_Topic_Wise_Questions.heaps;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class SmallestInfiniteSet {
    private final Set<Integer> set;
    private final PriorityQueue<Integer> queue;

    public SmallestInfiniteSet() {
        this.set = new HashSet<>();
        this.queue = new PriorityQueue<>();

        for(int i=1; i<=1000; i++) {
            this.set.add(i);
            this.queue.offer(i);
        }
    }

    public int popSmallest() {
        int smallest = queue.poll();
        set.remove(smallest);
        return smallest;
    }

    public void addBack(int num) {
        if(set.contains(num)) {
            return;
        }
        queue.offer(num);
        set.add(num);
    }
}

public class SmallestNumberInInfiniteSet {
    public static void main(String[] args) {
        SmallestInfiniteSet infiniteSet = new SmallestInfiniteSet();
        infiniteSet.addBack(2);
        System.out.println(infiniteSet.popSmallest());
        System.out.println(infiniteSet.popSmallest());
        System.out.println(infiniteSet.popSmallest());
        infiniteSet.addBack(1);
        System.out.println(infiniteSet.popSmallest());
        System.out.println(infiniteSet.popSmallest());
        System.out.println(infiniteSet.popSmallest());

    }
}
