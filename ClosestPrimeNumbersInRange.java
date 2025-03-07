import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestPrimeNumbersInRange {

    public static int[] closestPrimes(int left, int right) {
        // applying sieve of eratosthenes
        boolean[] primes = new boolean[1000001];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for(int num = 2; num*num<1000001; num++) {
            if(primes[num]) {
                for(int i = num*num; i<1000001; i += num) {
                    primes[i] = false;
                }
            }
        }

        List<Integer> primeNumbers = new ArrayList<>();

        for(int i = left; i<= right; i++) {
            if(primes[i]) {
                primeNumbers.add(i);
            }
        }

        if(primeNumbers.isEmpty()) {
            return new int[]{-1,-1};
        }

        int currentGap = Integer.MAX_VALUE;
        int first = -1;
        int second = -1;

        for(int i = primeNumbers.size()-1; i>0; i--) {
            if(primeNumbers.get(i) - primeNumbers.get(i-1) <= currentGap) {
                currentGap = primeNumbers.get(i) - primeNumbers.get(i-1);
                first = primeNumbers.get(i-1);
                second = primeNumbers.get(i);
            }
        }

        return new int[]{first, second};
    }

    public static void main(String[] args) {
        int[] pair = closestPrimes(4, 6);

        System.out.println(pair[0]+" "+pair[1]);
    }
}
