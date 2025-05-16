package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.Arrays;

public class TwoSum {

    /*
        Approach 1. Brute force using two nested loops for those two indices.
                    TC -> O(n^2)
                    SC -> O(1)

        Approach 2. Using two pointers, first sort the array of the copied version of the original array
                        and get those numbers using two pointers and last loop for scanning their indices in
                        the original array.
                    TC -> O(n log n)
                    SC -> O(n) // temp array creation

        Approach 3. Using Hashing, take a hashmap to store the value with its index, if there is a value (target-currentValue)
                    present in the hashmap then we can return those two indices ith and get the value of target-currentNumber
                    TC -> O(n)
                    SC -> O(n) // hashmap
     */

    public static int[] twoSum(int[] nums, int target) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);

        Arrays.sort(temp);

        int left = 0;
        int right = temp.length-1;

        int first = -1;
        int second = -1;

        while(left < right) {
            if(temp[left] + temp[right] == target) {
                first = temp[left];
                second = temp[right];
                break;
            }else if(temp[left] + temp[right] < target){
                left++;
            }else {
                right--;
            }
        }

        if(first == -1 && second == -1) {
            return new int[]{-1, -1};
        }

        int firstIdx = -1;
        int secondIdx = -1;

        for(int i = 0; i< nums.length; i++) {

            if(firstIdx == -1 && nums[i] == first) {
                firstIdx = i;
            }

            else if(secondIdx == -1 && nums[i] == second) {
                secondIdx = i;
            }
        }
        return new int[]{firstIdx, secondIdx};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 7)));
    }
}
