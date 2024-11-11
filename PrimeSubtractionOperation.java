import java.util.Arrays;

public class PrimeSubtractionOperation {
    private static void generateIsPrime(boolean[] isPrime) {
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int pn = 2; pn*pn < 1000; pn++) {
            if(isPrime[pn]) {
                for(int pnm = pn * pn; pnm < 1000; pnm+=pn) {
                    isPrime[pnm] = false;
                }
            }
        }
    }

    public static boolean primeSubOperation(int[] nums) {
        boolean[] isPrime = new boolean[1000];
        generateIsPrime(isPrime);

        for(int i = nums.length-2; i >= 0; i--) {
            if(nums[i] >= nums[i+1]) {
                for(int p=2; p<nums[i]; p++) {
                    if(isPrime[p] && nums[i] - p < nums[i+1]) {
                        nums[i] -= p;
                        break;
                    }
                }
            }

            if(nums[i] >= nums[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(primeSubOperation(new int[]{5,8,3}));
    }
}
