import java.util.ArrayList;
import java.util.List;

public class SubsetsI {

    public static void generateSubsets(int[] nums, int idx, List<Integer> currList, List<List<Integer>> list) {
        if(idx >= nums.length) {
            list.add(new ArrayList<>(currList));
            return;
        }


        // not take it
        generateSubsets(nums, idx+1, currList, list);

        // take it
        currList.add(nums[idx]);
        generateSubsets(nums, idx+1, currList, list);

        // backtrack
        currList.remove(currList.size()-1);

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        generateSubsets(nums, 0, new ArrayList<>(), list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{0}));
    }
    
}
