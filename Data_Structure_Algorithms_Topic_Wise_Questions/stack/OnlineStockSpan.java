package Data_Structure_Algorithms_Topic_Wise_Questions.stack;

import java.util.Stack;

    /*
        Approach: - 1. We have to create a data structure to deal with the stocks so One thing we know that if any stock
                            is coming with <= current day price so we can pop those price and count those days and return
                            the span days
                       TC -> O(1)
                       SC -> O(n)
     */

class StockSpanner {
    static class Stock {
        int price;
        int span;

        public Stock(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    private final Stack<Stock> stack;

    public StockSpanner() {
        this.stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while(!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }
        stack.push(new Stock(price, span));

        return span;
    }
}

public class OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();

        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));

    }
}
