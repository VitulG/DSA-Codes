package Data_Structure_Algorithms_Topic_Wise_Questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void generateSubsets(int[] nums, int idx, List<Integer> curr, List<List<Integer>> ans) {
        if(idx >= nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        generateSubsets(nums, idx+1, curr, ans);

        curr.add(nums[idx]);
        generateSubsets(nums, idx+1, curr, ans);
        curr.remove(curr.size()-1);

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
