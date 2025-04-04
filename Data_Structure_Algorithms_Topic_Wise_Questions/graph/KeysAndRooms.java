package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.List;

public class KeysAndRooms {

    public static void dfs(int src, List<List<Integer>> rooms, boolean[] isOpened) {
        isOpened[src] = true;

        for(int nextRoom : rooms.get(src)) {
            if(!isOpened[nextRoom]) {
                dfs(nextRoom, rooms, isOpened);
            }
        }
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isOpened = new boolean[rooms.size()];

        dfs(0, rooms, isOpened);

        for(boolean isUnlocked : isOpened) {
            if(!isUnlocked) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
