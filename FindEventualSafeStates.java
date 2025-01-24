import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    public static boolean isSafeNode(int node, int[][] graph, int[] states) {
        if(states[node] != 0) {
            return states[node] == 2;
        }

        states[node] = 1;

        for(int nbr : graph[node]) {
            if(!isSafeNode(nbr, graph, states)) {
                return false;
            }
        }

        states[node] = 2;

        return true;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>();

        int[] states = new int[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(isSafeNode(i, graph, states)) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    public static void main(String[] args) {
        System.out.println(eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}));
    }
}
