package Data_Structure_Algorithms_Topic_Wise_Questions.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatInAMazeProblemI {
    public static void findPossiblePathsInMaze(ArrayList<ArrayList<Integer>> maze, int r, int c, StringBuilder curr, ArrayList<String> mazePaths) {
        if(r == maze.size()-1 && c == maze.size()-1) {
            mazePaths.add(curr.toString());
            return;
        }

        if(r < 0 || c < 0 || r >= maze.size() || c >= maze.get(0).size() || maze.get(r).get(c) == 0) {
            return;
        }

        maze.get(r).set(c, 0);
        curr.append("U");
        findPossiblePathsInMaze(maze, r-1, c, curr, mazePaths);
        curr.deleteCharAt(curr.length()-1);

        curr.append("D");
        findPossiblePathsInMaze(maze, r+1, c, curr, mazePaths);
        curr.deleteCharAt(curr.length()-1);

        curr.append("L");
        findPossiblePathsInMaze(maze, r, c-1, curr, mazePaths);
        curr.deleteCharAt(curr.length()-1);

        curr.append("R");
        findPossiblePathsInMaze(maze, r, c+1, curr, mazePaths);
        curr.deleteCharAt(curr.length()-1);

    }

    public static ArrayList<String> findPath(ArrayList<ArrayList<Integer>> maze) {
        ArrayList<String> mazePaths = new ArrayList<>();
        findPossiblePathsInMaze(maze, 0, 0, new StringBuilder(), mazePaths);

        // return the list in lexicographically order
        Collections.sort(mazePaths);

        return mazePaths;
    }

    public static void main(String[] args) {

    }
}
