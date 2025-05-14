package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

public class IncreasingTripletSubsequence {

    /*
        Approach 1: Brute Force
        - Try all possible triplets and check if there exists a strictly increasing one.
        - TC -> O(n^3)
        - SC -> O(1)

    Approach 2: Greedy
        - Track the smallest and second-smallest elements while traversing.
        - If we find a number greater than both, we found the triplet.
        - TC -> O(n)
        - SC -> O(1)
     */

    public static boolean increasingTriplet(int[] nums) {
        if(nums.length == 0) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int num : nums) {
            if(num <= first) {
                first = num;
            }else if(num <= second) {
                second = num;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
