package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    /*
        Approach 1: Brute Force (Naive Simulation)
                - Repeatedly generate the next number as the sum of squares of digits.
                - Keep a list or brute-force search to see if we've seen this number before.
                - If we encounter a repeated number, it means we are in a cycle → return false.
                - If we reach 1 → return true.

                Time Complexity: O(n²)  // due to repeated full-list scanning (inefficient)
                Space Complexity: O(n)  // for storing previous numbers

        ---------------------------------------------------------

        Approach 2: Hashing (Efficient)
                - Use a HashSet to store seen numbers while generating the sum of squares.
                - If a number is repeated → cycle → return false.
                - If we reach 1 → return true.

                Time Complexity: O(log n)
                    (Because each digit-square sum reduces the number quickly. Most numbers converge to 1 or a cycle in <20 steps.)
                Space Complexity: O(log n)
                    (Set stores each intermediate number once.)
     */

    public static int getNumberDigitSquare(int number) {
        int ans = 0;

        while(number != 0) {
            int rem = number % 10;
            ans += (rem * rem);
            number /= 10;
        }
        return ans;
    }

    public static boolean isHappy(int num) {
        if(num == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        set.add(num);

        while(num != 1) {
            int newNumber = getNumberDigitSquare(num);
            if(set.contains(newNumber)) {
                return false;
            }
            set.add(newNumber);
            num = newNumber;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
