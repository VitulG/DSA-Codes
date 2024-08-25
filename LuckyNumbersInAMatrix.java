import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix {

    static class Cell {
        int num;
        int row;
        int col;

        public Cell(int num, int row, int col) {
            this.num = num;
            this.row = row;
            this.col = col;
        }
    }

    public static List<Integer> luckyNumbers (int[][] matrix) {
        if(matrix.length == 0 || matrix == null) {
            return null;
        }

        List<Integer> luckyNumbers = new ArrayList<Integer>();

        List<Cell> cells = new ArrayList<Cell>();


        for(int row = 0; row < matrix.length; row++) {
            int minNum = Integer.MAX_VALUE;
            int r = -1;
            int c = -1;
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] < minNum) { 
                    minNum = matrix[row][col];
                    r = row;
                    c = col;
                }
            }
            cells.add(new Cell(minNum, r, c));
        }

        for(Cell cell : cells) {
            int num = cell.num;
            int row = cell.row;
            int col = cell.col;

            int up = row;
            int down = row;

            while(up >= 0) {
                if(matrix[up][col] > num) {
                    break;
                }
                up--;
            }

            while(down < matrix.length) {
                if(matrix[down][col] > num) {
                    break;
                }
                down++;
            }

            if(up < 0 && down == matrix.length) {
                luckyNumbers.add(num);
            }
        }
        return luckyNumbers;
        
    }


    public static void main(String[] args) {
       System.out.println(luckyNumbers(new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}})); 
    }
    
}
