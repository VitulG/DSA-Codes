import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {

    public static void generateSubsets(int[] nums, int idx, int prev, List<Integer> list, List<Integer> largestSubset) {
        if(idx >= nums.length) {
            if(list.size() > largestSubset.size()) {
                largestSubset.clear();
                largestSubset.addAll(list);
            }
            return;
        }
        generateSubsets(nums, idx+1, prev, list, largestSubset);

        if(prev == -1 || nums[idx] % prev == 0) {
            list.add(nums[idx]);
            generateSubsets(nums, idx+1, nums[idx], list, largestSubset);
            list.remove(list.size()-1);
        }
    }

    // just a variant of LIS
    public static List<Integer> largestDivisibleSubsetBruteForce(int[] nums) {
        Arrays.sort(nums);
        List<Integer> largestSubset = new ArrayList<>();
        generateSubsets(nums, 0, -1, new ArrayList<>(), largestSubset);
        return largestSubset;
    }

    public static List<Integer> largestDivisibleSubsetBottomUpDP(int[] nums) {
        // why to sort -> because we can now easily compare with the prev element
        Arrays.sort(nums);

        // why -> ye batayega ki kitni length ho gyi hai subset ki jo ki ek dusre se divisible hai
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        // why -> ye batayega ki pichle index main kon sa last element the jo curr element se phele divisible tha
        int[] prevIdx = new int[nums.length];
        Arrays.fill(prevIdx, -1);

        // why -> hume track rakhna hoga ki last element kis position pe finish kiya jaha se hum start kar sake element ko list main push karna
        int maxLen = 0;

        List<Integer> largestDivisibleSubset = new ArrayList<>();

        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j]+1;
                    prevIdx[i] = j;
                }
            }

            // ith len > ho gyi max len se to hume update karna hoga ki maxlen max ab ith position ho gyi hai
            if(dp[i] > dp[maxLen]) {
                maxLen = i;
            }
        }

        // why -> ab un element ko add kar lo jo ek subset ka part ho
        while(maxLen != -1) {
            largestDivisibleSubset.add(nums[maxLen]);
            maxLen = prevIdx[maxLen];
        }
        Collections.sort(largestDivisibleSubset);

        return largestDivisibleSubset;
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubsetBottomUpDP(new int[]{3,7,28,63,79,81,99}));
    }
}
