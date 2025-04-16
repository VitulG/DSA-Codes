package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

public class FloydWarshall {

    public static void floydWarshall(int[][] dist) {
        // Code here
        int nodes = dist.length;

        for(int i=0; i<nodes; i++) {
            for (int j=0; j<nodes; j++) {
                // if there is no direct edge between two nodes assign them as Infinity
                if(dist[i][j] == -1) {
                    dist[i][j] = Integer.MAX_VALUE;
                }

                // self node distance always be 0
                if(i == j) {
                    dist[i][j] = 0;
                }
            }
        }

        // process Floyd Warshall algo to take every node as Intermediate for source and destination nodes
        for(int inter = 0; inter < nodes; inter++) {
            for(int src = 0; src < nodes; src++) {
                for(int dst = 0; dst < nodes; dst++) {
                    if(dist[src][inter] != Integer.MAX_VALUE && dist[inter][dst] != Integer.MAX_VALUE
                            && dist[src][dst] > dist[src][inter] + dist[inter][dst]) {
                        dist[src][dst] = dist[src][inter] + dist[inter][dst];
                    }
                }
            }
        }

        // reassign original distance nodes
        for(int i=0; i<nodes; i++) {
            for (int j=0; j<nodes; j++) {
                if(dist[i][j] == Integer.MAX_VALUE) {
                    dist[i][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
