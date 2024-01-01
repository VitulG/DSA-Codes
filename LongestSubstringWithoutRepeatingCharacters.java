import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int longestSubstring(String str) {

        //naive solution is O(N^3) or O(N^2)
        // optimize solution is O(N)

        int left = 0;
        int right = 0;
        int len = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<Character>();
        
        while(right < str.length()) {
            char ch = str.charAt(right);
            if(!set.contains(ch)) {
                len = Math.max(len, right-left+1);
                set.add(ch);
            }else{
                while(str.charAt(left) != ch) {
                    set.remove(str.charAt(left));
                    left++; 
                }
                left++;
            }
            right++;

        }
        return len;

    }


    public static void main(String[] args) {

        System.out.println(longestSubstring("aab"));
        
    }
    
}
