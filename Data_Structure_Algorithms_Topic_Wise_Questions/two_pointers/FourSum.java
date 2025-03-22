package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<>();

        for(int i=0; i<nums.length-3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for(int j = i+1; j < nums.length-2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int k = j+1;
                int l = nums.length-1;

                while(k < l) {
                    if((long) nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        while(k < l && nums[k] == nums[k-1]) {
                            k++;
                        }

                        while(l > k && nums[l] == nums[l+1]) {
                            l--;
                        }

                    }else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        k++;
                    }else {
                        l--;
                    }
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }
}
