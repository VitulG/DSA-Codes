package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.two_d;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        // Approach 1. using Brute force, we have two options for this I can buy the stock on that day or sell on that day so I can use DP here
        // TC -> O(2^n) with DP -> O(n) SC -> O(1) with dp O(n)

        // Approach is to take every take as greedy we want a day in which the price as much as low and for sale we want to find out the max price day for selling the stock
        // TC -> O(n) SC -> O(1)

        int maxProfit = Integer.MIN_VALUE;
        int buy = prices[0];

        for(int i=1; i< prices.length; i++) {
            int margin = prices[i] - buy;
            maxProfit = Math.max(maxProfit, margin);
            buy = Math.min(buy, prices[i]);
        }
        return Math.max(maxProfit, 0);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
