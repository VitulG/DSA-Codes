package Data_Structure_Algorithms_Topic_Wise_Questions.binary_search;

public class SplitArrayLargestSum {

    /*
        Approach: - Brute force, we get start from 1 to until we get the sum which we required. and check with that
                      sum can we do the partition of the array at most k if yes, we can check till the sum of all the
                      number in the array.

                      TC -> O(n*n)
                      SC -> O(1)

        Approach: - Binary Search, Instead of iterating on the sum linearly, we can do binary search on the sum the idea is
                        1. set the upper and lower bound where we have to search in the array from 1 to the sum of all the
                            numbers in the array.
                        2. after that, we will find the middle sum if we possibly split that array into k splits if yes that means
                            we can partition from that number and so on. So, move to the left part to minimize that sum.
                            if not, we have to increase our sum so move right.
                        3. In our helper function, we will start with one partition, and we will check
                            a. if the current sum <= middle sum so we can increase our sum.
                            b. else if we found a number > middle sum that means we can't divide the array into k split so return false.
                            c. else we have to partition into one more subarray and start fresh with that number.
                            d. in the end, we can check if we partition array <= k split.

                            TC -> O(n * log(sum))
                            SC -> O(1)
     */

    public static boolean isPossibleToSplitArray(int[] arr, int k, int sum) {
        int partitions  = 1;
        int currentSum  = 0;

        for (int num : arr) {
            if (partitions > k) {
                return false;
            }

            if (currentSum + num <= sum) {
                currentSum += num;
            } else {
                if (num > sum) {
                    return false;
                }
                currentSum = num;
                partitions++;
            }
        }
        return partitions <= k;
    }

    public static int splitArray(int[] arr, int k) {
        if(arr.length == 0) {
            return 0;
        }

        int lo = 1;
        int hi = 0;

        for(int num : arr) {
            hi += num;
        }

        int ans = -1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(isPossibleToSplitArray(arr, k, mid)) {
                ans = mid;
                hi = mid -1;
            }else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{1, 1, 2}, 2));
    }
}
