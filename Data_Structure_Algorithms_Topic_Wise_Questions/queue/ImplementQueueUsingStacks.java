package Data_Structure_Algorithms_Topic_Wise_Questions.queue;

import java.util.Stack;

class MyQueue {
    private final Stack<Integer> first;
    private final Stack<Integer> second;

    public MyQueue() {
        this.first = new Stack<>();
        this.second = new Stack<>();
    }

    public void push(int x) {
        if(!second.isEmpty()) {
            moveElements(second, first);
        }
        first.push(x);
    }

    public int pop() {
        if(!first.isEmpty()) {
            moveElements(first, second);
        }
        return (second.isEmpty()) ? -1 : second.pop();
    }

    public int peek() {
        if(!first.isEmpty()) {
            moveElements(first, second);
        }
        return (second.isEmpty()) ? -1 : second.peek();
    }

    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
    }

    private static void moveElements(Stack<Integer> from, Stack<Integer> to) {
        while(!from.isEmpty()) {
            to.push(from.pop());
        }
    }
}

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
