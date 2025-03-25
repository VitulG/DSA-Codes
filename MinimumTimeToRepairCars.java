public class MinimumTimeToRepairCars {

    public static boolean isPossibleToRepairCarsInTime(int[] ranks, int cars, long time) {
        int carsRepaired = 0;

        for(int rank : ranks) {
            long maxCarsRepairedByAMechanic = (long) Math.sqrt( (double) time / rank);
            carsRepaired += (int) maxCarsRepairedByAMechanic;
        }
        return carsRepaired >= cars;
    }

    public static long repairCars(int[] ranks, int cars) {
        int maxRank = ranks[0];

        for(int rank : ranks) {
            maxRank = Math.max(maxRank, rank);
        }

        long lo = 1L;
        long hi = (long) maxRank * cars * cars;

        long minTime = hi;

        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            if(isPossibleToRepairCarsInTime(ranks, cars, mid)) {
                minTime = mid;
                hi = mid -1;
            }else {
                lo = mid + 1;
            }
        }
        return minTime;
    }

    public static void main(String[] args) {
        System.out.println(repairCars(new int[]{4,2,3,1}, 10));
    }
}
