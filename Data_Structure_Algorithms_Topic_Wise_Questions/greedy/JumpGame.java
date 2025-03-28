package Data_Structure_Algorithms_Topic_Wise_Questions.greedy;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int maxReach = 0;

        // max Reach rakho 0 pe aur check karo and max update karo ki uss index se kitna max ja sakte hai
        // agar kissi index pe maxReach kam reh jati hai to waha hum kabhi nahi pahuch paayenge..
        // using greedily we can solve this one using dynamic programming
        for(int i=0; i<nums.length; i++) {
            if(maxReach < i) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print(canJump(new int[]{3,2,1,0,4}));
    }
}
