package Data_Structure_Algorithms_Topic_Wise_Questions.greedy;

import java.util.Arrays;

public class MinimumSum {

    /*
        Approach 1: Brute Force
            - Generate all possible partitions of digits into two groups.
            - For each partition, form two numbers and compute their sum.
            - Track the minimum possible sum.
            - Time Complexity: O(2^n)
            - Space Complexity: O(n) for recursive stack or bitmask tracking

        Approach 2: Greedy + Sorting
            - Sort the array of digits in ascending order.
            - Distribute digits alternately to two numbers — this ensures both numbers are as small as possible.
            - After forming the two numbers, perform string-based addition to avoid overflow.
            - Time Complexity: O(n log n) due to sorting
            - Space Complexity: O(1) extra (excluding result string)

        Note:
            - If digits are only in range [0-9], we can use Counting Sort for O(n) time overall.
    */


    public static String minSum(int[] arr) {
        // code here
        if(arr.length == 0) {
            return "";
        }

        Arrays.sort(arr);

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        for(int i=0; i< arr.length; i++) {
            if(i % 2 == 0) {
                num2.append(arr[i]);
            }else {
                num1.append(arr[i]);
            }
        }
        return addTwoStringNumbers(num1.toString(), num2.toString());
    }

    public static String addTwoStringNumbers(String first, String second) {
        int i = first.length()-1;
        int j = second.length()-1;
        int carry = 0;

        StringBuilder ans = new StringBuilder();

        while(i >= 0 || j >= 0) {
            int sum = 0;

            if(i >= 0) {
                sum += (first.charAt(i)-'0');
                i--;
            }

            if(j >= 0) {
                sum += (second.charAt(j)-'0');
                j--;
            }
            sum += carry;
            carry = sum / 10;
            ans.append(sum % 10);
        }
        if(carry > 0) {
            ans.append(carry);
        }

        String result = ans.reverse().toString();
        int index = 0;
        while (index < result.length() - 1 && result.charAt(index) == '0') {
            index++;
        }
        return result.substring(index);
    }

    public static void main(String[] args) {
        System.out.println(minSum(new int[]{2, 4, 3, 5, 0, 0, 0, 8, 2, 9, 2}));
    }
}
