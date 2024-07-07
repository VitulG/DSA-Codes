public class WaterBottles {

    public static int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        
        while(numBottles >= numExchange) {
            int spend = numBottles / numExchange;
            int remaining = numBottles % numExchange;
            ans += spend;
            numBottles = remaining + spend;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
    }
    
}
