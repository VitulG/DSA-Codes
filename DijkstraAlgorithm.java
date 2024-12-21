import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    static class Node {
        int neighbor;
        int weight;

        public Node(int neighbor, int weight) {
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }

    public static ArrayList<ArrayList<Node>> getAdjacencyList(int vertices, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for(int i=0; i<vertices; i++) {
            graph.add(new ArrayList<>());
        }

        for(ArrayList<Integer> edge : edges) {
            graph.get(edge.get(0)).add(new Node(edge.get(1), edge.get(2)));
            graph.get(edge.get(1)).add(new Node(edge.get(0), edge.get(1)));
        }
        return graph;
    }

    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> edges, int vertices, int source) {
        ArrayList<ArrayList<Node>> adjList = getAdjacencyList(vertices, edges);

        ArrayList<Integer> distance = new ArrayList<Integer>(vertices);
        for(int i=0; i<vertices; i++) {
            distance.add(Integer.MAX_VALUE);
        }
        distance.set(source, 0);

        PriorityQueue<Node> queue = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        queue.offer(new Node(source, 0));

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();

            int currNode = currentNode.neighbor;
            int currWt = currentNode.weight;

            for(Node nbr : adjList.get(currNode)) {
                int neighbor = nbr.neighbor;
                int dist = nbr.weight;

                if(currWt + dist < distance.get(neighbor)) {
                    distance.set(neighbor, currWt + dist);
                    queue.offer(new Node(neighbor, currWt + dist));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 5)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2, 8)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, 9)));
        edges.add(new ArrayList<>(Arrays.asList(1, 3, 2)));
        edges.add(new ArrayList<>(Arrays.asList(2, 3, 6)));

        System.out.println(dijkstra(edges,4,0));
    }
}
