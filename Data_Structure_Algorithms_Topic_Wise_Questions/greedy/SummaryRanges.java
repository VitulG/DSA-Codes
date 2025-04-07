package Data_Structure_Algorithms_Topic_Wise_Questions.greedy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {

        List<String> ranges = new ArrayList<>();

        for(int i=0; i<nums.length;) {
            int j = i;
            int currNumber = nums[i];
            while(j < nums.length && currNumber == nums[j]) {
                currNumber = currNumber+1;
                j++;
            }
            if(i == j-1) {
                ranges.add(nums[i]+"");
                i++;
            }else {
                ranges.add(nums[i]+"->"+nums[j-1]);
                i = j;
            }
        }
        return ranges;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
}
