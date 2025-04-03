package Data_Structure_Algorithms_Topic_Wise_Questions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsII {

    public static void generateUniqueSubsets(int[] nums, int idx, List<Integer> curr, List<List<Integer>> uniqueSubsets) {

        uniqueSubsets.add(new ArrayList<>(curr));

        for(int i=idx; i<nums.length; i++) {
            if(i > idx && nums[i] == nums[i-1]) {
                continue;
            }
            curr.add(nums[i]);
            generateUniqueSubsets(nums, i+1, curr, uniqueSubsets);
            curr.remove(curr.size()-1);
        }
    }

    public static List<List<Integer>> subsetWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> uniqueSubsets = new ArrayList<>();
        generateUniqueSubsets(nums, 0, new ArrayList<>(), uniqueSubsets);
        return uniqueSubsets;
    }

    public static void main(String[] args) {
        System.out.println(subsetWithDup(new int[]{1,2,2}));
    }
}
