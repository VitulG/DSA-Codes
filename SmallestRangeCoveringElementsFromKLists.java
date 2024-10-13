import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists {

    static class ValueInfo {
        int value;
        int listPosition;
        int idxInList;

        public ValueInfo(int value, int listPosition, int idxInList) {
            this.value = value;
            this.listPosition = listPosition;
            this.idxInList = idxInList;
        }

    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        int kLists = nums.size();
        PriorityQueue<ValueInfo> queue = new PriorityQueue<>((a,b) -> a.value - b.value);
        int maxElement = Integer.MIN_VALUE;

        for(int i=0; i<kLists; i++) {
            int value = nums.get(i).get(0);
            queue.offer(new ValueInfo(value, i, 0));
            maxElement = Math.max(maxElement, nums.get(i).get(0));
        }

        int[] range = {-1000000, 1000000};

        while(!queue.isEmpty()) {
            ValueInfo value = queue.poll();
            int minElement = value.value;
            int listNumber = value.listPosition;
            int idx = value.idxInList;

            if(maxElement - minElement < range[1] - range[0]) {
                range[0] = minElement;
                range[1] = maxElement;
            }

            if(idx+1 < nums.get(listNumber).size()) {
                int nextElement = nums.get(listNumber).get(idx+1);
                queue.offer(new ValueInfo(nextElement, listNumber, idx+1));
                maxElement = Math.max(maxElement, nextElement);
            }else {
                break;
            }
        }
        return range;
    }

    public static void main(String[] args) {
        List<Integer> first = List.of(4,10,15,24,26);
        List<Integer> second = List.of(0,9,12,20);
        List<Integer> third = List.of(5,18,22,30);
        List<List<Integer>> lists = List.of(first, second, third);

        int[] result = smallestRange(lists);
        System.out.println(result[0]+", "+result[1]);

    }
}
