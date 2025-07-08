package Data_Structure_Algorithms_Topic_Wise_Questions.backtracking;

import java.util.ArrayList;

public class CombinationSum {

    /*
        Approach: - I have choices to choose an element from the array to make the sum equal to target or not,
                        so we can use backtracking over hare.
                    TC -> O(2^t) // We can use the same element again and again and k is the avg size of the combination
                    SC -> O(2^t)
     */

    public static void generateCombinationSum(int[] arr, int idx, int currentSum, int target,
                                              ArrayList<Integer> current, ArrayList<ArrayList<Integer>> ans) {
        if(idx >= arr.length) {
            return;
        }

        if(currentSum > target) {
            return;
        }

        if(currentSum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }

        generateCombinationSum(arr, idx+1, currentSum, target, current, ans);

        currentSum += arr[idx];
        current.add(arr[idx]);
        generateCombinationSum(arr, idx, currentSum, target, current, ans);

        current.remove(current.size()-1);

    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
        if(arr.length == 0) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        generateCombinationSum(arr, 0, 0, target, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 4, 6, 8}, 8));
    }
}
