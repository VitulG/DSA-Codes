public class MinimumNumberOfDaysToMakeMBouquets {

    public static boolean isPossibleToMakeBouquet(int[] bloomDays, int day, int m, int k) {
        int totalBouquetsMade = 0;
        int picked = 0;

        for(int bloomDay : bloomDays) {
            if(bloomDay <= day) {
                picked += 1;
                if(picked == k) {
                    totalBouquetsMade += 1;
                    picked = 0;
                }
            }else {
                picked = 0;
            }

            if(totalBouquetsMade == m) {
                return true;
            }
        }
        return false;
    }

    public static int minDays(int[] bloomDay, int m, int k) {

        if(m*k > bloomDay.length) {
            return -1;
        }

        int left = 1;
        int right = Integer.MIN_VALUE;

        for(int day : bloomDay ) {
            right = Math.max(right, day);
        }

        int ans = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(isPossibleToMakeBouquet(bloomDay, mid, m, k)) {
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[]{7,7,7,7,12,7,7}, 2, 3));        
    }
    
}
