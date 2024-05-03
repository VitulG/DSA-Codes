public class NumberOfWonderfulSubstrings {

    public static boolean isWonderful(String sub) {
        int[] freq = new int[26];
        boolean hasOdd = false;

        for(int i=0; i<sub.length(); i++) {
            char ch = sub.charAt(i);
            freq[ch-'a']+=1;
        }

        for(int i=0; i<26; i++) {
            if(freq[i]%2!=0 && hasOdd) {
                return false;
            }else if(freq[i]%2!=0 && !hasOdd) {
                hasOdd = true;
            }
        }
        return true;

    }

    public static long wonderfulSubstringsUsingBf(String word) {
        long ans = 0l;

        char[] ch = word.toCharArray();

        for(int i=0; i<ch.length; i++) {
            for(int j=i; j<ch.length; j++) {
                String sub = word.substring(i, j+1);
                if(isWonderful(sub)) {
                    ans++;
                }
            }
        }
        return ans;
    }


    // optimal solution
    public static long wonderfulSubstringsOptimally(String word) {
        if(word.isEmpty()) {
            return 0l;
        }
        
    }

    public static void main(String[] args) {
        System.out.println(wonderfulSubstringsUsingBf("aabb"));
    }
    
}
