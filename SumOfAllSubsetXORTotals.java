public class SumOfAllSubsetXORTotals {

    public static int sumXorTotal(int[] nums, int idx, int currXor) {
        if(idx == nums.length) {
            return currXor;
        }
        int takeXor = sumXorTotal(nums, idx+1, currXor^nums[idx]);
        int skipXor = sumXorTotal(nums, idx+1, currXor);

        return takeXor + skipXor;
    }

    public static int subsetXORSum(int[] nums) {
        return sumXorTotal(nums, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1, 3, 5}));
    }
    
}
