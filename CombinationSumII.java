import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void generateCombinations(int idx, int[] candidates, int target, List<List<Integer>> result, List<Integer> curr) {
        if(target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx; i < candidates.length; i++) {
            if(i > idx && candidates[i] == candidates[i - 1]) { 
                continue;
            }

            if(candidates[i] > target) {
                break;
            }

            curr.add(candidates[i]);
            generateCombinations(i+1, candidates, target-candidates[i], result, curr);
            curr.remove(curr.size()-1);
        }
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0 || target < 1) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();

        generateCombinations(0, candidates, target, combinations, curr);
        return combinations;
    }
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
