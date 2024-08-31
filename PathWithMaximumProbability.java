import java.util.*;

public class PathWithMaximumProbability {

    static class Pair implements Comparable<Pair>{
        double probability;
        int node;

        public Pair(double probability, int node) {
            this.probability = probability;
            this.node = node;
        }

        @Override
        public int compareTo(Pair pair) {
            return Double.compare(pair.probability, this.probability);
        }

    }

    public static List<List<Pair>> getAdjacencyList(int nodes, int[][] edges, double[] succProb) {
        List<List<Pair>> graph = new ArrayList<>();

        for(int i=0; i<nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            graph.get(edges[i][0]).add(new Pair(succProb[i], edges[i][1]));
            graph.get(edges[i][1]).add(new Pair(succProb[i], edges[i][0]));
        }
        return graph;
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // i will use Dijkstra algorithm
        double[] dist = new double[n];
        Arrays.fill(dist, 0.0d);
        dist[start] = 1.0d;

        List<List<Pair>> adjacencyList = getAdjacencyList(n, edges, succProb);

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(1.0d, start));

        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            int currentNode = current.node;
            double currentProbability = current.probability;

            if(currentNode == end) {
                return currentProbability;
            }

            for(Pair nbr : adjacencyList.get(currentNode)) {
                int nbrNode = nbr.node;
                double nbrProbability = currentProbability * nbr.probability;

                if(nbrProbability > dist[nbrNode]) {
                    dist[nbrNode] = nbrProbability;
                    queue.add(new Pair(nbrProbability, nbrNode));
                }
            }
        }
        return 0.0d;
    }

    public static void main(String[] args) {
        System.out.println(maxProbability(3, new int[][]{{0,1},{1,2},{0,2}}, new double[]{0.5,0.5,0.2},
                0,2));
    }
}
