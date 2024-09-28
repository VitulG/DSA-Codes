class MyCircularDeque {

    private int front;
    private int rear;
    private final int[] queue;
    private final int size;
    private int totalElementsInQueue;

    public MyCircularDeque(int k) {
        this.queue = new int[k];
        this.size = k;
        this.front = 0;
        this.rear = k-1;
        this.totalElementsInQueue = 0;
    }

    public boolean insertFront(int value) {
        if(this.isFull()) {
            return false;
        }
        this.front = (this.front - 1 + this.size) % this.size;
        this.queue[this.front] = value;
        this.totalElementsInQueue++;
        return true;
    }

    public boolean insertLast(int value) {
        if(this.isFull()) {
            return false;
        }
        this.rear = (this.rear+1)%this.size;
        this.queue[this.rear] = value;
        this.totalElementsInQueue++;
        return true;
    }

    public boolean deleteFront() {
        if(this.isEmpty()) {
            return false;
        }

        this.front = (this.front+1)%this.size;
        this.totalElementsInQueue--;
        return true;
    }

    public boolean deleteLast() {
        if(this.isEmpty()) {
            return false;
        }

        this.rear = (this.rear - 1 + this.size) % this.size;
        this.totalElementsInQueue--;
        return true;
    }

    public int getFront() {
        return (isEmpty()) ? -1 : this.queue[front];
    }

    public int getRear() {
        return (isEmpty()) ? -1 : this.queue[rear];
    }

    public boolean isEmpty() {
        return this.totalElementsInQueue == 0;
    }

    public boolean isFull() {
        return this.totalElementsInQueue == this.size;
    }
}

public class DesignCircularDeque {
    public static void main(String[] args) {
        MyCircularDeque queue = new MyCircularDeque(3);
        System.out.println(queue.insertLast(1)); // return true
        System.out.println(queue.insertLast(2));
        System.out.println(queue.insertFront(3)); // return true
        System.out.println(queue.insertFront(4));
        System.out.println(queue.getRear());
        System.out.println(queue.isFull());
        System.out.println(queue.deleteLast());
        System.out.println(queue.insertFront(4));
        System.out.println(queue.getFront());
    }
}
