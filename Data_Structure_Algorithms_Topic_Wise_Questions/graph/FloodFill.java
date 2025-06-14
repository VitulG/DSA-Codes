package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

public class FloodFill {

    public static void dfs(int[][] image, int sr, int sc, int newColor, int prevColor, int[] dr, int[] dc, boolean[][] isVisited) {
        image[sr][sc] = newColor;
        isVisited[sr][sc] = true;

        for(int i=0; i<4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if(nr < image.length && nc < image[0].length && nr >= 0 && nc >= 0 && !isVisited[nr][nc] && image[nr][nc] == prevColor) {
                dfs(image, nr, nc, newColor, prevColor, dr, dc, isVisited);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;

        int prevColor = image[sr][sc];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        boolean[][] isVisited = new boolean[rows][cols];

        dfs(image, sr, sc, color, prevColor, dr, dc, isVisited);

        return image;
    }

    public static void main(String[] args) {
        int[][] newImage = floodFill(new int[][]{
                {1,1,1},
                {1,1,0},
                {1,0,1}
        }, 1, 1, 2);

        for(int[] row : newImage) {
            for(int pixel : row) {
                System.out.print(pixel+" ");
            }
            System.out.println();
        }

    }
}
