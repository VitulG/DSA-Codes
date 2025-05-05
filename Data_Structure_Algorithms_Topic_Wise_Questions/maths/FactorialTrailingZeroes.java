package Data_Structure_Algorithms_Topic_Wise_Questions.maths;

public class FactorialTrailingZeroes {
    /*
        Approach 1. Generate the factorial of the given n and check how many zeroes are there, but it has a major issue of Integer
                        overflow.
                    TC -> O(n), SC -> O(1)

        Approach 2: Mathematical Optimization (Recommended)
                    - A trailing zero is produced by multiplying 2 and 5.
                    - In n!, number of 2s is always more than 5s.
                    - So count how many times 5 is a factor in numbers from 1 to n.
                    - That includes 5, 25, 125, ... (all powers of 5).
                    - Add n/5 + n/25 + n/125 + ... until n/i becomes 0.
                    - TC: O(log₅n), SC: O(1)
     */

    public static int trailingZeroes(int n) {
        if(n == 0) {
            return 0;
        }

        if(n < 5) {
            return 0;
        }

        int trailingZeroes = 0;

        for(int i=5; i<=n; i*=5) {
            trailingZeroes += (n / i);
        }
        return trailingZeroes;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(789));
    }
}
