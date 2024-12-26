public class TargetSum {

    public static void getNumberOfDifferentExpressions(int[] arr, int idx, int target, int[] ways) {
        if(idx >= arr.length) {
            if(target == 0) {
                ways[0]++;
            }
            return;
        }

        // for +ve
        getNumberOfDifferentExpressions(arr, idx+1, target-arr[idx], ways);
        // for -ve
        getNumberOfDifferentExpressions(arr, idx+1, target+arr[idx], ways);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int[] ways = {0};
        getNumberOfDifferentExpressions(nums, 0, target, ways);
        return ways[0];
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
