import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    private PriorityQueue<Integer> queue;
    private int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        queue = new PriorityQueue<Integer>(k);
        this.k = k;

        for(int num : nums) {
            queue.offer(num);
        }
    }
    
    public int add(int val) {
        if(queue.size() < this.k) {
            queue.offer(val);
        } else if(val > queue.peek()) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(2, new int[]{0});
        System.out.println(kthLargest.add(-1));
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(3));
    }
}