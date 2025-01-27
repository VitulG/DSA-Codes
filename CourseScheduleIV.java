import java.util.*;

public class CourseScheduleIV {

    public static List<List<Integer>> getAdjacencyList(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
        return graph;
    }

    public static List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adjList = getAdjacencyList(n, prerequisites);

        // Step 1. create in_degree array to get the in_degrees of all the nodes;
        int[] in_degree = new int[n];

        for(int i=0; i<n; i++) {
            for(int nbr : adjList.get(i)) {
                in_degree[nbr]++;
            }
        }

        // step 2. create queue to put all the nodes which have 0 in_degree
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            if(in_degree[i] == 0) {
                queue.offer(i);
            }
        }

        // step 3. process for the rest
        Map<Integer, Set<Integer>> prereqMap = new HashMap<>();

        for(int i=0; i<n; i++) {
            prereqMap.put(i, new HashSet<>());
        }

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adjList.get(current)) {
                prereqMap.get(neighbor).add(current);
                prereqMap.get(neighbor).addAll(prereqMap.get(current));

                in_degree[neighbor]--;

                if (in_degree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for(int[] query : queries) {
            int src = query[0];
            int dest = query[1];
            ans.add(prereqMap.get(dest).contains(src));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPrerequisite(3, new int[][]{
                {1,2},
                {1,0},
                {2,0}
        }, new int[][]{
                {1,0},
                {1,2}
        }));
    }
}
