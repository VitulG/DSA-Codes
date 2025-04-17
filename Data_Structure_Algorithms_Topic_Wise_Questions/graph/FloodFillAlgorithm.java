package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.Arrays;

public class FloodFillAlgorithm {

    public static void dfs(int[][] img, int sr, int sc, int newColor, boolean[][] isVisited, int[] dr,
                           int[] dc, int prevColor) {
        isVisited[sr][sc] = true;
        img[sr][sc] = newColor;

        for(int i=0; i<4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if(nr < img.length && nr >= 0 && nc < img[0].length && nc >= 0 && img[nr][nc] == prevColor && !isVisited[nr][nc]) {
                dfs(img, nr, nc, newColor, isVisited, dr, dc, prevColor);
            }
        }

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;

        boolean[][] isVisited = new boolean[n][m];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int prevColor = image[sr][sc];

        if(prevColor == newColor) {
            return image;
        }

        dfs(image, sr, sc, newColor, isVisited, dr, dc, prevColor);

        return image;
    }

    public static void main(String[] args) {
        int[][] newImage = floodFill(new int[][]{
                {1,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        }, 1,2,2);

        for(int[] row : newImage) {
            System.out.println(Arrays.toString(row));
        }
    }
}
