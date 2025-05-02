package Data_Structure_Algorithms_Topic_Wise_Questions.matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    /*
    *
    *  Approach is to check for every row and every column in the 9x9 matrix
    * check for the 3x3 sub matrices
    * TC -> O(n * n) SC -> O(1)
    *
    */

    public static boolean isValidSubSudoku(char[][] board, int startRow, int endRow, int startCol, int endCol) {
        Set<Character> set = new HashSet<>();

        for(int row = startRow; row <= endRow; row++) {
            for(int col = startCol; col <= endCol; col++) {
                if(board[row][col] == '.') {
                    continue;
                }
                if(set.contains(board[row][col])) {
                    return false;
                }
                set.add(board[row][col]);
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // check for the row
        for(int row = 0; row < rows; row++) {
            Set<Character> set = new HashSet<>();
            for(int col = 0; col < cols; col++) {
                if(board[row][col] == '.') {
                    continue;
                }
                if(set.contains(board[row][col])) {
                    return false;
                }
                set.add(board[row][col]);
            }
        }

        // check for the col
        for(int col = 0; col < cols; col++) {
            Set<Character> set = new HashSet<>();
            for(int row = 0; row < rows; row++) {
                if(board[row][col] == '.') {
                    continue;
                }
                if(set.contains(board[row][col])) {
                    return false;
                }
                set.add(board[row][col]);
            }
        }

        // check for the submatrix
        for(int row = 0; row < rows; row += 3) {
            for(int col = 0; col < cols; col += 3) {
                if(!isValidSubSudoku(board, row, row+2, col, col+2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
