import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsOfFarmland {

    static int r =0;
    static int c = 0;

    public static void dfs(int[][] land, int row, int col, boolean[][] isVisited) {
        isVisited[row][col] = true;
        
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        
        for(int i=0; i<4; i++) {
            int nr = row + dx[i];
            int nc = col + dy[i];
            
            if(nr >= 0 && nc >= 0 && nr < land.length && nc < land[0].length && land[nr][nc]== 1 && !isVisited[nr][nc]) {
                dfs(land, nr, nc, isVisited);
            }
        }
        r = Math.max(r, row);
        c = Math.max(c, col);

    }

    public static int[][] findFarmland(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;

        boolean[][] isVisited = new boolean[rows][cols];
       
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(land[i][j] == 1 && !isVisited[i][j]) {
                    List<Integer> currlist = new ArrayList<Integer>();
                    currlist.add(i);
                    currlist.add(j);

                    r = i;
                    c = j;

                    dfs(land, i, j, isVisited);

                    currlist.add(r);
                    currlist.add(c);
                    list.add(currlist);
                }
            }
        }
        
        int[][] ans = new int[list.size()][4];

        for(int i=0; i<list.size(); i++) {
            List<Integer> l = list.get(i);
            ans[i][0] = l.get(0);
            ans[i][1] = l.get(1);
            ans[i][2] = l.get(2);
            ans[i][3] = l.get(3);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[][] ans = findFarmland(new int[][]{{1,0,0},{0,1,1},{0,1,1}});

        for(int[] i : ans) {
            for(int j : i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}