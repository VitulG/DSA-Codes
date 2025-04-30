package Data_Structure_Algorithms_Topic_Wise_Questions.heaps;

import java.util.ArrayList;
import java.util.List;

public class InsertionInHeap {
    private final List<Integer> heap;

    public InsertionInHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(3);
        this.heap.add(5);
        this.heap.add(17);
        this.heap.add(7);
        this.heap.add(10);
        this.heap.add(19);
    }

    public void insertInHeap(int num) {
        this.heap.add(num);
        int numIdx = this.heap.size()-1;

        while(numIdx > 0) {
            int parentIdx = (numIdx-1) / 2;

            if(heap.get(parentIdx) <= heap.get(numIdx)) {
                break;
            }else {
                int temp = this.heap.get(numIdx);
                this.heap.set(numIdx, this.heap.get(parentIdx));
                this.heap.set(parentIdx, temp);
                numIdx = parentIdx;
            }
        }
    }

    public int getFirst() {
        return this.heap.getFirst();
    }

    public static void main(String[] args) {
        InsertionInHeap insertion = new InsertionInHeap();
        System.out.println(insertion.getFirst());
        insertion.insertInHeap(2);
        System.out.println(insertion.getFirst());
    }
}
