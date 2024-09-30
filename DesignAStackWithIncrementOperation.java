class CustomStack {
    private final int[] arr;
    private int elements;

    public CustomStack(int maxSize) {
        this.arr = new int[maxSize];
        this.elements = -1;
    }

    public void push(int x) {
        if(elements >= arr.length-1) {
            return;
        }else {
            arr[++elements] = x;
        }
    }

    public int pop() {
        if(elements == -1) {
            return -1;
        }
        int value = arr[elements];
        elements--;
        return value;
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, elements+1);
        for (int i = 0; i < limit; i++) {
            arr[i] += val;
        }
    }
}


public class DesignAStackWithIncrementOperation {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
