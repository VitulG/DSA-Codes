package Data_Structure_Algorithms_Topic_Wise_Questions.stack;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {

    /*
        ✅ Approach 1: Brute Force
           - For each element, scan all elements to its right and find the first one that is greater.
           - Time Complexity: O(n^2)
           - Space Complexity: O(1)

        ✅ Approach 2: Monotonic Stack
           - Scan the array from right to left (since we're finding NGE on the right).
           - Maintain a stack that always has potential NGE candidates.
           - For each element:
                - Pop elements from the stack that are smaller or equal to it.
                - If stack is not empty, its top is the next greater element.
                - Else, no NGE → use -1.
                - Push current element to stack.
           - Time Complexity: O(n)
           - Space Complexity: O(n) (for stack + result)

        💡 Why Stack Works?
           - Stack helps us skip over irrelevant elements (smaller ones) quickly.
           - Guarantees O(n) total operations because each element is pushed and popped at most once.
     */

    public static void reverseList(ArrayList<Integer> list) {
        int st = 0;
        int en = list.size()-1;

        while(st < en) {
            int temp = list.get(st);
            list.set(st, list.get(en));
            list.set(en, temp);
            st++;
            en--;
        }
    }

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        if(arr.length == 0) {
            return new ArrayList<>();
        }

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> nextGreaterElements = new ArrayList<>();

        for(int i=arr.length-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }
            nextGreaterElements.add((stack.isEmpty()) ? -1 : stack.peek());
            stack.push(arr[i]);
        }
        reverseList(nextGreaterElements);
        return nextGreaterElements;
    }

    public static void main(String[] args) {
        System.out.println(nextLargerElement(new int[]{6, 8, 0, 1, 3}));
    }
}
