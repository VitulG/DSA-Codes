package Data_Structure_Algorithms_Topic_Wise_Questions.heaps;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    /*
        Approach 1: Sort the array in descending order and return the Kth element.
                        Time Complexity: O(n log n)
                        Space Complexity: O(1) or O(n) depending on sorting algorithm

        Approach 2: Use a Max-Heap (PriorityQueue with reverse order)
                    - Insert all elements, then extract K times.
                        Time Complexity: O(n log n)
                        Space Complexity: O(n)

        Approach 3: Use a Min-Heap of size K
                    - Maintain a heap of size K with the largest K elements.
                    - The root of the heap is the Kth largest.
                        Time Complexity: O(n log k)
                        Space Complexity: O(k)
     */

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int num : nums) {
            queue.offer(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
