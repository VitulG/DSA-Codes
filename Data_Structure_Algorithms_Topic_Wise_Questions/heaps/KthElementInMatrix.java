package Data_Structure_Algorithms_Topic_Wise_Questions.heaps;

import java.util.PriorityQueue;

public class KthElementInMatrix {
    /*

    Approach 1: Brute Force
        - Convert the entire matrix into a 1D array of size n*n.
        - Sort the array and return the (k-1)th element.

        Time Complexity:  O(n * n + n^2 log n^2) => O(n^2 log n)
        Space Complexity: O(n * n)

    Approach 2: Min Heap (Optimized)
        - Treat each row of the matrix as a sorted array.
        - Insert the first element of each row (i.e., the first column elements) into the min heap.
          These are the smallest elements of each row.
        - Then, perform k iterations:
            - Extract the minimum (smallest) element from the heap.
            - Insert the next element in the same row (if it exists) into the heap.
        - After k pops, the kth smallest element will be the answer.

        Time Complexity:  O(k log n) (where n is the number of rows, and heap size is at most n)
        Space Complexity: O(n) for the heap

    */

    static class Cell {
        int row;
        int col;
        int value;

        public Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix.length * matrix[0].length < k) {
            return -1;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> a.value - b.value);

        for(int row = 0; row < rows; row++) {
            queue.offer(new Cell(row, 0, matrix[row][0]));
        }

        int kthSmallestElement = -1;

        while(k-- > 0) {
            Cell cell = queue.poll();
            kthSmallestElement = cell.value;

            int currentRow = cell.row;
            int currentCol = cell.col;

            if(currentCol + 1 < matrix[currentRow].length) {
                queue.offer(new Cell(currentRow, currentCol+1, matrix[currentRow][currentCol+1]));
            }

        }
        return kthSmallestElement;
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{
                {10,20,30,40},
                {15,25,35,45},
                {24,29,37,48},
                {32,33,39,50}
        }, 7));
    }
}
