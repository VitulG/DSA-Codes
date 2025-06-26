public class LongestBinarySubsequenceLessThanOrEqualToK {

    public static int longestSubsequence(String s, int k) {
        if(s.isEmpty()) {
            return 0;
        }

        int idx = s.length()-1;
        int stringLength = s.length();
        int longestSubsequenceLength = 0;

        while(idx >= 0) {
            char currentBit = s.charAt(idx);
            if(currentBit == '0') {
                longestSubsequenceLength++;
            }else {
                if(stringLength-idx-1 < 31) {
                    int currentValue = (currentBit -'0') * (1<<stringLength-idx-1);
                    if(currentValue <= k) {
                        longestSubsequenceLength++;
                        k -= currentValue;
                    }
                }
            }
            idx--;
        }
        return longestSubsequenceLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence("1001010", 5));
    }
}
