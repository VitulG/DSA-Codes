package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = nums.length-1;

            while(j < k) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j-1]) {
                        j++;
                    }

                    while(k > j && nums[k] == nums[k+1]) {
                        k--;
                    }
                }else if(nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }else {
                    k--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0,1,1}));
    }
}
