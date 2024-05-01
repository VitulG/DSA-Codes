public class WordSearchI {

    public static boolean isWordExist(char[][] board, String word, int row, int col, int idx) {
        if(idx == word.length()) {
            return true;
        }
        
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col]  == '@' || board[row][col] != word.charAt(idx)) {
            return false;
        }

        char carry = board[row][col];
        board[row][col] = '@';
        
        boolean up = isWordExist(board, word, row-1, col, idx+1);
        boolean down = isWordExist(board, word, row+1, col, idx+1);
        boolean left = isWordExist(board, word, row, col-1, idx+1);
        boolean right = isWordExist(board, word, row, col+1, idx+1);

        board[row][col] = carry;
        
        return up || down || left || right;

    }

    public static boolean exist(char[][] board, String word) {

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(isWordExist(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "EVIL"));
    }
}
