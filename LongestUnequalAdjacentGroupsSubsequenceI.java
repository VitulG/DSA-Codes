import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {

    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        int len = words.length;

        List<String> ans = new ArrayList<>();
        ans.add(words[0]);

        int bit = groups[0];

        for(int i=0; i<len; i++) {
            if(bit != groups[i]) {
                ans.add(words[i]);
                bit = groups[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getLongestSubsequence(new String[]{"a","b","c","d"}, new int[]{1,0,1,1}));
    }
}
