import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheCountOfGoodIntegers {

    public static long pow(int num, int pow) {
        if(pow == 0) {
            return 1;
        }

        long result = pow(num, pow/2);

        if((pow&1) != 0) {
            return result * result * num;
        }
        return result * result;
    }

    public static long countGoodIntegers(int n, int k) {
        // Step 1. make string palindrome of digit length n
        int digits = (n+1)/2;

        Set<String> set = new HashSet<>();
        long start = pow(10, digits-1);
        long end = pow(10, digits) - 1;


        for(long i=start; i<=end; i++) {
            StringBuilder number = new StringBuilder(String.valueOf(i));

            if((n&1) != 0) {
                StringBuilder rightHalf = new StringBuilder(number.substring(0, number.length() - 1));
                number.append(rightHalf.reverse());
            }else {
                number.append(number.reverse());
            }

            long currentNumber = Long.parseLong(number.toString());

            if(currentNumber%k == 0) {
                char[] chars = number.toString().toCharArray();
                Arrays.sort(chars);
                set.add(new String(chars));
            }
        }

        // precalculate the factorial
        long[] factorial = new long[11];
        factorial[0] = 1;

        for(int i=1; i<11; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        // Step 2. ki take palindromic divisible string from the set
        long goodIntegers = 0L;

        for(String str : set) {
            int[] freq = new int[10];
            for(char ch : str.toCharArray()) {
                freq[ch-'0']++;
            }

            int totalDigits = str.length();
            int zeroes = freq[0];
            int nonZeroes = totalDigits - zeroes;

            long permutation = nonZeroes * factorial[totalDigits-1];

            for(int i=0; i<10; i++) {
                permutation /= factorial[freq[i]];
            }
            goodIntegers += permutation;
        }
        return goodIntegers;
    }

    public static void main(String[] args) {
        System.out.println(countGoodIntegers(4,7));
    }
}
