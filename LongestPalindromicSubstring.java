public class LongestPalindromicSubstring {

    public static String longestPalindromicSubstring(String str) {

        int len = str.length();
        String ans = "";
        int currlen = 0;
        
        for(int i=0; i<len; i++) {
            //check for odd length
            int left = i, right = i;
            while(left >= 0 && right < len && str.charAt(left) == str.charAt(right)) {
                if(currlen < right-left+1) {
                    ans = str.substring(left, right+1);
                    currlen = right-left+1;
                }
                left--;
                right++;
            }

            //check for right length
            left = i; 
            right = i+1;
            while(left >= 0 && right < len && str.charAt(left) == str.charAt(right)) {
                if(currlen < right-left+1){
                    ans = str.substring(left,right+1);
                    currlen = right-left+1;
                }
                left--;
                right++;
            }

        }
        return ans;

    }

    public static void main(String[] args) {

        System.out.println(longestPalindromicSubstring("aaaabbaa"));
    }

}