import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfIntegersToChooseFromARangeI {

    public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedNumbers = new HashSet<>();

        for(int bn : banned) {
            bannedNumbers.add(bn);
        }

        int ans = 0;
        int currSum = 0;

        for(int i=1; i<=n; i++) {
            if(!bannedNumbers.contains(i)) {
                currSum += i;
                if(currSum <= maxSum) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxCount(new int[]{11},7,50));
    }
}
