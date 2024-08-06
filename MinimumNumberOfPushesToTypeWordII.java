import java.util.Arrays;

public class MinimumNumberOfPushesToTypeWordII {

    public static int minimumPushes(String word) {
        if(word == null || word.isEmpty()) {
            return 0;
        }

        Integer[] freq = new Integer[26];
        Arrays.fill(freq, 0);

        for(char ch : word.toCharArray()) {
            freq[ch-'a']++;
        }

        Arrays.sort(freq, (a,b) -> b.compareTo(a));

        int minPushes = 0;
        int start = 0;
        int time = 1;

        for(; start < 26 && freq[start] != 0; start++) {
            if(start >= 8 && start%8 == 0) {
                time++;
            }
            minPushes += (freq[start]*time);
        }
        return minPushes;

    }

    public static void main(String[] args) {
        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}
