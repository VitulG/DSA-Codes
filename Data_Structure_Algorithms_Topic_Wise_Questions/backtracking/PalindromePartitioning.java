package Data_Structure_Algorithms_Topic_Wise_Questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    /*
         Approach:
            - We need to generate **all possible partitions** of the given string such that each substring in a partition is a **palindrome**.
            - This is a classic **Backtracking** problem.

            Steps:
                1. If the input string is empty, return an empty list.
                2. Create a helper backtracking function to explore all partitions.
                3. In each recursive call:
                    - Iterate from the current index to the end.
                    - Check if the substring from current index to i is a palindrome.
                    - If yes:
                        - Add substring to the current path.
                        - Recurse with the remaining substring.
                        - Backtrack by removing the last added substring.
                4. Use a helper function to check if a substring is a palindrome.

            Time Complexity: O(n * 2^n)
                - For a string of length n, there are 2^(n-1) ways to partition it.
                - For each partitioning, checking each substring takes O(n) time in the worst case.

            Space Complexity: O(n)
                - Due to the recursion stack and the space used by the current list storing one partition path.
     */

    public static boolean isPalindromicString(String str, int st, int en) {
        if(st >= en) {
            return true;
        }

        if(str.charAt(st) != str.charAt(en)) {
            return false;
        }
        return isPalindromicString(str, st+1, en-1);
    }

    public static void generatePalindromicPartitions(String str, int idx, List<String> currentPalindromicPartitions,
                                                     List<List<String>> palindromicPartitions) {
        if(idx >= str.length()) {
            palindromicPartitions.add(new ArrayList<>(currentPalindromicPartitions));
            return;
        }

        for(int i=idx; i<str.length(); i++) {
            String substring = str.substring(idx, i+1);
            if(isPalindromicString(substring, 0, substring.length()-1)) {
                currentPalindromicPartitions.add(substring);
                generatePalindromicPartitions(str, i+1, currentPalindromicPartitions, palindromicPartitions);
                currentPalindromicPartitions.remove(currentPalindromicPartitions.size()-1);
            }
        }

    }

    public static List<List<String>> partition(String str) {
        if(str.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<String>> palindromicPartitions = new ArrayList<>();
        generatePalindromicPartitions(str, 0, new ArrayList<>(), palindromicPartitions);
        return palindromicPartitions;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
