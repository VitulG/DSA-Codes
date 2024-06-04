import java.util.HashSet;
import java.util.Set;

public class LonestPalindrome {

    public static int longestPalindrome(String str) {
        if(str.length() == 1) {
            return 1;
        }

        Set<Character> set = new HashSet<Character>();

        int ans = 0;

        for(int i =0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(set.contains(ch)) {
                ans += 2;
                set.remove(ch);
            }else{
                set.add(ch);
            }
        }

        if(!set.isEmpty()) {
            ans+=1;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("lifeisarace"));
    }
    
}
