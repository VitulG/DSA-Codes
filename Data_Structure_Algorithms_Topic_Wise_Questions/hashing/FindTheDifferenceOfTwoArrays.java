package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.*;

public class FindTheDifferenceOfTwoArrays {

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();

        for(int num : nums1) {
            firstSet.add(num);
        }

        for(int num : nums2) {
            secondSet.add(num);
        }

        Arrays.sort(nums1);
        List<Integer> firstUniqueElements = new ArrayList<>();
        for(int i=0; i<nums1.length; i++) {
            if(i > 0 && nums1[i] == nums1[i-1]) {
                continue;
            }
            if(!secondSet.contains(nums1[i])) {
                firstUniqueElements.add(nums1[i]);
            }
        }

        Arrays.sort(nums2);
        List<Integer> secondUniqueElements = new ArrayList<>();
        for(int i = 0; i<nums2.length; i++) {
            if(i > 0 && nums2[i] == nums2[i-1]) {
                continue;
            }
            if(!firstSet.contains(nums2[i])) {
                secondUniqueElements.add(nums2[i]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(firstUniqueElements);
        ans.add(secondUniqueElements);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }
}
