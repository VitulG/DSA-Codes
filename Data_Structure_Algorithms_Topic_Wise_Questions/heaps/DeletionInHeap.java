package Data_Structure_Algorithms_Topic_Wise_Questions.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeletionInHeap {

    public static int poll(List<Integer> heap) {
        int poll = heap.getFirst();
        Collections.swap(heap, 0, heap.size()-1);
        heap.removeLast();

        int rootIdx = 0;

        while(true) {
            int leftChildIdx = 2 * rootIdx + 1;
            int rightChildIdx = 2 * rootIdx + 2;
            int smallest = rootIdx;

            if(leftChildIdx < heap.size() && heap.get(leftChildIdx) < heap.get(rootIdx)) {
                smallest = leftChildIdx;
            }

            if(rightChildIdx < heap.size() && heap.get(rightChildIdx) < heap.get(rootIdx)) {
                smallest = rightChildIdx;
            }

            if(rootIdx == smallest) {
                break;
            }

            Collections.swap(heap, rootIdx, smallest);
            rootIdx = smallest;
        }
        return poll;
    }


    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>(Arrays.asList(2,3,5,17,7,10,19));
        System.out.println(poll(heap));
        System.out.println(poll(heap));
    }
}
