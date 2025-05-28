package Data_Structure_Algorithms_Topic_Wise_Questions.matrix;

public class FindRectangleWithCornersAsOne {

    public static boolean ValidCorner(int[][] mat) {
        // Code here
        if(mat.length == 0) {
            return false;
        }

        int rows = mat.length;
        int cols = mat[0].length;

        for(int c1 = 0; c1 < cols; c1++) {
            for(int c2 = c1 + 1; c2 < cols; c2++) {
                int count = 0;
                for(int r = 0; r < rows; r++) {
                    if(mat[r][c1] == 1 && mat[r][c2] == 1) {
                        count++;
                        if(count >= 2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(ValidCorner(new int[][]{
                {1,0,0,1,0},
                {0,0,1,0,1},
                {0,0,0,1,0},
                {1,0,1,0,1}
        }));
    }
}
