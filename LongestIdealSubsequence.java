public class LongestIdealSubsequence {
    
    public static int longestIdealString(String s, int k) {
        int[] freq = new int[26];

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch-'a';
            int left  = Math.max(0, idx-k);
            int right = Math.min(25, idx+k);

            int max = Integer.MIN_VALUE;

            for(int j = left; j<=right; j++) {
                max = Math.max(max, freq[j]);
            }
            freq[idx] = max+1;

        }

        int len = Integer.MIN_VALUE;

        for(int val : freq) {
            len = Math.max(len, val);
        }
        return len;

    }

    public static void main(String[] args) {
        System.out.println(longestIdealString("acfgbd", 2));
    }
}