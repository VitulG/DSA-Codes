import java.util.ArrayList;
import java.util.List;

public class KthSmallestInLexicographicalOrder {

    public static int getCount(long curr, long next, int num) {
        int count = 0;

        while(curr <= num) {
            count += (int) (next - curr);
            curr *= 10;
            next *= 10;
            next = Math.min(next, num+1);
        }
        return count;
    }
    public static int findKthNumber(int num, int k) {
        k -= 1;
        int curr = 1;

        while(k > 0) {
            long currCount = getCount(curr, curr+1, num);

            if(currCount <= k) {
                curr++;
                k -= (int) currCount;
            }else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        int num = 22, k = 14;
        System.out.println(findKthNumber(num, k)); // Output: 21
    }
}
