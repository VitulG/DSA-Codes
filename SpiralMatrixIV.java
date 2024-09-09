import java.util.Arrays;

public class SpiralMatrixIV {

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];

        for(int[] row : result) {
            Arrays.fill(row, -1);
        }

        if (head == null) {
            return result;
        }

        ListNode curr = head;
        int rowStart = 0;
        int rowEnd = m - 1;
        int colStart = 0;
        int colEnd = n - 1;

        while(rowStart <= rowEnd && colStart <= colEnd) {
            for(int col= rowStart; col <= colEnd; col++) {
                if(curr != null) {
                    result[rowStart][col] = curr.val;
                    curr = curr.next;
                }
            }
            rowStart++;

            for(int row = rowStart; row <= rowEnd; row++) {
                if(curr != null) {
                    result[row][colEnd] = curr.val;
                    curr = curr.next;
                }
            }
            colEnd--;

            if(rowStart <= rowEnd) {
                for(int col = colEnd; col >= colStart; col--) {
                    if(curr != null) {
                        result[rowEnd][col] = curr.val;
                        curr = curr.next;
                    }
                }
                rowEnd--;
            }

            if(colStart <= colEnd) {
                for(int row = rowEnd; row >= rowStart; row--) {
                    if(curr != null) {
                        result[row][colStart] = curr.val;
                        curr = curr.next;
                    }
                }
                colStart++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);

        int[][] result = spiralMatrix(3,5, head);

        for(int[] row : result) {
            for(int el : row) {
                System.out.print(el+" ");
            }
            System.out.println();
        }
    }
}
