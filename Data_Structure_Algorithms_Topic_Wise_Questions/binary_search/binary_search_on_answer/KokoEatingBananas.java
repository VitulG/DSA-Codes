package Data_Structure_Algorithms_Topic_Wise_Questions.binary_search.binary_search_on_answer;

public class KokoEatingBananas {

    /*
        Approach to solve this question we need the least time required to eat all the piles of bananas by Koko
            we can use binary search on the hours to check if koko can eat all the piles in k hours.
            if yes, that means koko can also eat all the bananas if we increase the time so we will decrease the time
            and move to left half or else koko can't eat all the piles of bananas so we would go in right half increase the time

            TC -> O(n log max(pile))
            SC -> O(1)
     */

    public static boolean isPossibleToEatBananasWithinHours(int[] piles, int maxHours, int currHours) {
        long totalTime = 0;

        for(int pile : piles) {
            totalTime += (pile + currHours -1) / currHours;
        }

        return totalTime <= maxHours;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        if(piles.length == 0) {
            return 0;
        }

        int low = 1;
        int high = Integer.MIN_VALUE;

        for(int pile : piles) {
            high = Math.max(high, pile);
        }

        int k = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(isPossibleToEatBananasWithinHours(piles, h, mid)) {
                k = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
    }
}
