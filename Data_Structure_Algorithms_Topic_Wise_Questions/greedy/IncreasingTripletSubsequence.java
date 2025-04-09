package Data_Structure_Algorithms_Topic_Wise_Questions.greedy;

public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        /*
        * Brute force solution TC -> O(n^3) we need to optimize this definitely
        * Optimal solution is using two pointers first and second as we know the condition i<j<k
        * agar main i aur j ki value update karu aur first two smallest mil gaye to next greater will be the third
        * from there I can return true immediately else return false TC -> O(n)
        */

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int num : nums) {
            if(first >= num) {
                first = num;
            }else if(second >= num) {
                second = num;
            }else {
                return true; // triplet found
            }
        }
        return false; // we couldn't find
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{2,1,5,0,4,6}));
    }
}
