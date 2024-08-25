public class PathWithMaximumGold {

    public static int getGold(int[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        int currCellGold = grid[row][col];
        grid[row][col] = 0;

        int up = getGold(grid, row-1, col);
        int down = getGold(grid, row+1, col);
        int left = getGold(grid, row, col-1);
        int right = getGold(grid, row, col+1);

        grid[row][col] = currCellGold;

        return Math.max(up, Math.max(down, Math.max(left, right))) + currCellGold;

    }

    public static int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int maxGold = Integer.MIN_VALUE;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) { 
                if(grid[row][col] != 0) {
                    int currentGold = getGold(grid, row, col);
                    maxGold = Math.max(maxGold, currentGold);
                }
            }
        }
        return (maxGold == Integer.MIN_VALUE) ? 0 : maxGold;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumGold(new int[][]{{0,6,0},{5,8,7},{0,9,0}}));
    }
    
}
