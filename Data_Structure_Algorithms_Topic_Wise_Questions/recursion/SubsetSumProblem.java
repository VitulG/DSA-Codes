package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

public class SubsetSumProblem {

    public static void generateSubsetSum(int[] arr, int idx, int currentSum, int targetSum, int[] subsetsWithSum) {
        if(idx >= arr.length) {
            if(currentSum == targetSum) {
                subsetsWithSum[0]++;
            }
            return;
        }
        if(currentSum > targetSum) {
            return;
        }

        generateSubsetSum(arr, idx+1, currentSum, targetSum, subsetsWithSum);
        generateSubsetSum(arr, idx+1, currentSum+arr[idx], targetSum, subsetsWithSum);
    }

    public static int subsets(int[] arr, int sum) {
        int[] subsetsWithSum = {0};
        generateSubsetSum(arr, 0, 0, sum, subsetsWithSum);
        return subsetsWithSum[0];
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3,8,17}, 10));
    }
}
