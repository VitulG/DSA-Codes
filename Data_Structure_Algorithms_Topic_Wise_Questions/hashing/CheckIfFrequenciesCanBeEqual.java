package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

public class CheckIfFrequenciesCanBeEqual {

    public static boolean containsSameFrequencies(int[] freq) {
        int start = 0;

        for(int f : freq) {
            if(f != 0) {
                if (start != 0) {
                    if (start - f != 0) {
                        return false;
                    }
                }
                start = f;
            }
        }
        return true;
    }

    public static boolean sameFreq(String s) {
        // code here
        if(s.isEmpty()) {
            return true;
        }

        int[] freq = new int[26];

        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }

        if(containsSameFrequencies(freq)) {
            return true;
        }

        for(int i = 0; i<26; i++) {
            if(freq[i] == 0) {
                continue;
            }

            freq[i]--;

            if(containsSameFrequencies(freq)) {
                return true;
            }
            freq[i]++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(sameFreq("edbceeed"));
    }
}
