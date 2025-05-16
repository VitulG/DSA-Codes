package Data_Structure_Algorithms_Topic_Wise_Questions.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SmallestRangeInKLists {

    /*
        Approach: - 1. Using Priority Queue to keep track of min value as we will keep a max value while adding
                           a new heap node value in the heap so that we can check which is the closest range of
                           maximum value - minimum value if we found smaller range just update the ranges of min
                           and max and return a list with these values.
                       TC -> O(n*k log k)
                       SC -> O(k)
     */

    static class HeapNode {
        int value;
        int rowNumber;
        int columnNumber;

        public HeapNode(int value, int rowNumber, int columnNumber) {
            this.value = value;
            this.rowNumber = rowNumber;
            this.columnNumber = columnNumber;
        }
    }

    public static ArrayList<Integer> findSmallestRange(int[][] arr) {
        PriorityQueue<HeapNode> queue = new PriorityQueue<>((a, b) -> a.value - b.value);

        int maxValue = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            int value = arr[i][0];
            queue.offer(new HeapNode(value, i, 0));
            maxValue = Math.max(maxValue, arr[i][0]);
        }

        int rangeStart = -100000;
        int rangeEnd = 100000;

        while (!queue.isEmpty()) {
            HeapNode currentNode = queue.poll();
            int minValue = currentNode.value;
            int currentRow = currentNode.rowNumber;
            int currentCol = currentNode.columnNumber;

            if(maxValue - minValue < rangeEnd - rangeStart) {
                rangeEnd = maxValue;
                rangeStart = minValue;
            }

            if(currentCol + 1 < arr[currentRow].length) {
                int nextValueInRow = arr[currentRow][currentCol+1];
                queue.offer(new HeapNode(nextValueInRow, currentRow, currentCol+1));
                maxValue = Math.max(maxValue, nextValueInRow);
            }else {
                break;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(rangeStart);
        ans.add(rangeEnd);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findSmallestRange(new int[][]{
                {2,4},
                {1,7},
                {20,40}
        }));
    }
}
