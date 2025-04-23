package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.*;

public class DetermineIfTwoStringsAreClose {

    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }

        // key idea same keys and same frequencies but shuffled

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for(char ch : word1.toCharArray()) {
            freq1[ch-'a']++;
            set1.add(ch);
        }

        for(char ch : word2.toCharArray()) {
            freq2[ch-'a']++;
            set2.add(ch);
        }

        if(!set1.equals(set2)) {
            return false;
        }

        for(int i=0; i<26; i++) {
            if(freq1[i] != 0) {
                boolean isFound = false;
                for(int j=0; j<26; j++) {
                    if(freq1[i] == freq2[j]) {
                        isFound = true;
                        freq2[j] = 0;
                        break;
                    }
                }
                if(!isFound) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(closeStrings("cabbba", "abbccc"));
    }
}
