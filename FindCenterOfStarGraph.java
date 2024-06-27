
public class FindCenterOfStarGraph {

    // observation based question

    public static int findCenter(int[][] edges) {
        int[] firstEdge = edges[0];
        int[] secondEdge = edges[1];

        if(firstEdge[0] == secondEdge[1] || firstEdge[0] == secondEdge[0]) {
            return firstEdge[0];
        }
        return firstEdge[1];
    }


    public static void main(String[] args) {
        System.out.println(findCenter(new int[][]{{1,2},{4,2},{2,3}}));
    }    
}
