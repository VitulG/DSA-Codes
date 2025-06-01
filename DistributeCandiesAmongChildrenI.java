public class DistributeCandiesAmongChildrenI {

    public static int distributeCandies(int n, int limit) {
        int ways = 0;

        for(int first = 0; first <= limit; first++) {
            for(int second = 0; second <= limit; second++) {
                int remainingForThird = n - first - second;

                if(remainingForThird >= 0 && remainingForThird <= limit) {
                    ways++;
                }

            }
        }
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(distributeCandies(3,3));
    }
}
