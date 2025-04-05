package Data_Structure_Algorithms_Topic_Wise_Questions.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    static class Cell {
        int val;
        int row;
        int col;

        public Cell(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        PriorityQueue<Cell> queue = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(int i=0; i<k; i++) {
            queue.offer(new Cell(arr[i][0], i, 0));
        }

        ArrayList<Integer> mergedSortedList = new ArrayList<>();

        while(!queue.isEmpty()) {
            Cell cell = queue.poll();

            mergedSortedList.add(cell.val);

            int currRow = cell.row;
            int currCol = cell.col;

            if(currCol+1 < arr[currRow].length) {
                queue.offer(new Cell(arr[currRow][currCol+1], currRow, currCol+1));
            }
        }
        return mergedSortedList;
    }

    public static void main(String[] args) {
        System.out.println(mergeKArrays(new int[][]{
                {1,5,9},
                {2,7},
                {3,11,15,20}
        }, 3));
    }
}
