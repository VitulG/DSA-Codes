import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop {

    public static int[] finalPrices(int[] prices) {
        int len = prices.length;
        Stack<Integer> stack = new Stack<>();

        int[] finalCosts = new int[len];

        for(int i = len -1; i >= 0; i--) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                finalCosts[i] = prices[i];
            }else {
                finalCosts[i] = prices[i] - prices[stack.peek()];
            }
            stack.push(i);
        }
        return finalCosts;
    }

    // Time Complexity => O(2N) we are touching an element two times only
    // Space "    "  => O(N) we are using stack

    public static void main(String[] args) {
        int[] result = finalPrices(new int[]{10,1,1,6});

        for(int num : result) {
            System.out.print(num+" ");
        }
    }
}
