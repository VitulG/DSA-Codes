package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        // Approach 1. Using Brute force, we can check if a number is existing > n/2 times using a nested loop
        // TC -> O(n^2) SC -> O(1)

        // Approach 2. Using Hashing first store all the frequency in the map and just check if a number has occurred > n/2
        // TC -> O(2n) SC -> O(n)

        // Approach 3. Using Boyer-Moore Voting algorithm
        // TC -> O(2N) SC -> O(1)

        int candidate  = -1;
        int candidateCount = 0;

        for(int num : nums) {
            if(candidateCount == 0) {
                candidate = num;
                candidateCount = 1;
            }else if(num == candidate) {
                candidateCount++;
            }else {
                candidateCount--;
            }
        }

        int occurance = 0;

        for(int num : nums) {
            if(num == candidate) {
                occurance++;
            }
        }
        return occurance > (nums.length/2) ? candidate : -1;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
