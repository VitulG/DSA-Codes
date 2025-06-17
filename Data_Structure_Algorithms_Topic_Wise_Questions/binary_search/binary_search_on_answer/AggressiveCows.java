package Data_Structure_Algorithms_Topic_Wise_Questions.binary_search.binary_search_on_answer;

import java.util.Arrays;

public class AggressiveCows {

    /*
        Approach 1. Brute force tries all the distance between 0 and the maximum distance stall and checks if we
                        place the cows in d distance where d, 0 <= d <= maxDistance
                    TC -> O(n * maxDistance)
                    SC -> O(1)

        Approach 2. Using Binary Search on distance, we want to minimize the maximum distance between two cows so
                        we can use Binary Search Ove
     */

    public static boolean isPossibleToPlaceCows(int[] stalls, int distance, int cows) {
        int placedStall = stalls[0];
        int cowsPlaced = 1;

        for(int i = 1; i<stalls.length; i++) {
            if(stalls[i] - placedStall >= distance) {
                cowsPlaced++;
                if(cows == cowsPlaced) {
                    return true;
                }
                placedStall = stalls[i];
            }
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);

        int low = 0;
        int high = stalls[stalls.length-1];

        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if((isPossibleToPlaceCows(stalls, mid, k))) {
                ans = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(aggressiveCows(new int[]{10, 1, 2, 7, 5}, 3));
    }
}
