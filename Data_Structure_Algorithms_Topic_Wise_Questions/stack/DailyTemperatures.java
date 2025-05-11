package Data_Structure_Algorithms_Topic_Wise_Questions.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    /*
        Approach 1. I will check the next warmer day for the current day on the right side and will keep a counter
                        how many days I have waited and put that counter in the answer.
                    TC -> O(n^2), SC -> O(1)

        Approach 2. Using Stack, we will traverse from the right side and pop those days which is cooler than the current
                        ith day and take that difference
                    TC -> O(n), SC -> O(n)
     */

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = temperatures.length-1; i>=0; i--) {
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                days[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return days;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}
