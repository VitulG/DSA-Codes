package Data_Structure_Algorithms_Topic_Wise_Questions.queue;

import java.util.*;

public class SlidingWindowMaximum {

    /*
        Approach 1: Brute Force
            - Maintain a sliding window of size k.
            - For each window, scan all k elements to find the maximum.
            - Slide the window by removing the leftmost element and adding a new one to the right.

            Time Complexity: O(n * k)
            Space Complexity: O(k) (for temporary window storage)

        Approach 2: Optimized using Monotonic Queue (Deque)
            - Use a deque to store indices of elements in decreasing order of their values.
            - For each element:
                - Remove indices from the back whose values are less than the current element (they can never be max again).
                - Add the current element's index to the back.
                - Remove the front index if it's outside the current window (i - queue.peekFirst() >= k).
                - The front of the deque always holds the index of the current maximum in the window.

            Time Complexity: O(n), each element is pushed and popped at most once.
            Space Complexity: O(k), for storing indices in deque.
    */

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return new int[]{};
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<k; i++) {
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }

        int[] ans = new int[nums.length - k + 1];
        int idx = 0;

        ans[idx++] = nums[queue.peekFirst()];

        for(int i=k; i<nums.length; i++) {
            while(!queue.isEmpty() && i - queue.peekFirst() >= k) {
                queue.removeFirst();
            }

            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);

            ans[idx++] = nums[queue.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,-1}, 1)));
    }
}
