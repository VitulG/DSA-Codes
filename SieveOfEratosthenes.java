import java.util.Arrays;

public class SieveOfEratosthenes {

    public static boolean isPrimeNumber(int num) {
        boolean[] primeNumbers = new boolean[100001];
        Arrays.fill(primeNumbers, true);
        primeNumbers[0] = false;
        primeNumbers[1] = false;

        for(int i=2; i*i<100001; i++) {
            if(primeNumbers[i]) {
                for(int j = i*i; j<100001; j+=i) {
                    primeNumbers[j] = false;
                }
            }
        }

        return primeNumbers[num];
    }


    public static void main(String[] args) {
        System.out.println(isPrimeNumber(78));
        System.out.println(isPrimeNumber(79));
    }
}
