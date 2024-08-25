public class AverageWaitingTime {

    public static double averageWaitingTime(int[][] customers) {
        if(customers.length < 1) {
            return 0.0;
        }

        int time = 0;
        double sum  = 0;

        for(int[] customer : customers) {
            int arrival = customer[0];
            int foodTime = customer[1];

            time = Math.max(arrival, time) + foodTime;

            sum += (time-arrival);
        }
        return (double) sum/customers.length;
    }

    public static void main(String[] args) {
        System.out.println(averageWaitingTime(new int[][]{{1,2},{2,5},{4,3}}));
    }
    
}
