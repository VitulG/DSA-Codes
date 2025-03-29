package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.util.HashSet;
import java.util.Set;

public class MinimumCommonValue {

    // brute force -> TLE O(n^2)
    public static int getCommon(int[] nums1, int[] nums2) {
        int minElement = Integer.MAX_VALUE;
        for (int k : nums1) {
            for (int i : nums2) {
                if (i == k) {
                    minElement = Math.min(minElement, k);
                }
            }
        }
        return minElement == Integer.MAX_VALUE ? -1 : minElement;
    }

    // better using Set O(2N) -> accepted
    public static int getCommonUsingSet(int[] nums1, int[] nums2) {
        int minElement = Integer.MAX_VALUE;

        Set<Integer> set = new HashSet<>();
        for(int num : nums2) {
            set.add(num);
        }

        for (int j : nums1) {
            if (set.contains(j)) {
                minElement = Math.min(minElement, j);
            }
        }
        return minElement == Integer.MAX_VALUE ? -1 : minElement;
    }


    // optimal using two pointer
    public static int getCommonUsingTwoPointer(int[] nums1, int[] nums2) {
        int fp = 0;
        int sp = 0;

        while(fp < nums1.length && sp < nums2.length) {
            if(nums1[fp] == nums2[sp]) {
                return nums1[fp];
            }else if(nums1[fp] < nums2[sp]) {
                fp++;
            }else {
                sp++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getCommonUsingTwoPointer(new int[]{5,6,7,12}, new int[]{10,11,12}));
    }
}
