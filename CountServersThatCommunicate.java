public class CountServersThatCommunicate {

    public int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] rowServers = new int[rows];
        int[] colServers = new int[cols];

        int communicatedServers = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) {
                    rowServers[i]++;
                    colServers[j]++;
                }
            }
        }

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1 && (rowServers[i] > 1 || colServers[j] > 1)) {
                    communicatedServers++;
                }
            }
        }

        return communicatedServers;
    }

    public static void main(String[] args) {
        System.out.println(new CountServersThatCommunicate().countServers(new int[][]{{1,0},{0,1}}));
    }
}
