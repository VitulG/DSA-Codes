package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    /*
        Approach is to use Kahn's algorithm over here we can select first which has not any incoming dependency
            and process those courses and proceed further for the next courses
                TC -> O(V+E), SC -> O(n)
     */

    public static List<List<Integer>> getAdjacencyList(int courses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i=0; i<courses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites) {
            adjacencyList.get(prerequisite[0]).add(prerequisite[1]);
        }
        return adjacencyList;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = getAdjacencyList(numCourses, prerequisites);

        int[] in_degree = new int[numCourses];

        for(int course=0; course<numCourses; course++) {
            for(int nextCourse : adjList.get(course)) {
                in_degree[nextCourse]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<numCourses; i++) {
            if(in_degree[i] == 0) {
                queue.offer(i);
            }
        }

        int courseDone = 0;

        while(!queue.isEmpty()) {
            int currentCourse = queue.poll();
            courseDone++;
            for(int nextCourse : adjList.get(currentCourse)) {
                in_degree[nextCourse]--;
                if(in_degree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        return courseDone == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{
                {1,0},
                {0,1}
        }));
    }
}
