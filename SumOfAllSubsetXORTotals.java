public class SumOfAllSubsetXORTotals {

    public static int sumXorTotal(int[] nums, int idx, int currXor) {
        if(idx == nums.length) {
            return currXor;
        }
        int withXor = sumXorTotal(nums, idx+1, currXor^nums[idx]);
        int withoutXor = sumXorTotal(nums, idx+1, currXor);

        return withXor + withoutXor;
    }

    public static int subsetXORSum(int[] nums) {
        return sumXorTotal(nums, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1,3}));
    }
    
}
