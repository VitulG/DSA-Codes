import java.util.HashMap;
import java.util.Map;

public class CountOfSubstringsContainingEveryVowelAndKConsonantsII {

    public static long countOfSubstrings(String word, int k) {
        if(word.length() < k+5) {
            return 0;
        }

        Map<Character, Integer> vowels = new HashMap<>();
        Map<Character, Integer> consonants = new HashMap<>();
        int consonantCount = 0;

        long substrings = 0;

        for(int i=0; i<k+5; i++) {
            char ch = word.charAt(i);

            if("aeiou".indexOf(ch) != -1) {
                vowels.put(ch, vowels.getOrDefault(ch, 0) + 1);
            }else {
                consonants.put(ch, consonants.getOrDefault(ch, 0) + 1);
                consonantCount++;
            }
        }

        if(vowels.size() == 5 && consonantCount == k) {
            substrings++;
        }

        for(int i=k+5; i<word.length(); i++) {
            char prevCh = word.charAt(i - (k+5));
            if("aeiou".indexOf(prevCh) != -1) {
                int freq = vowels.get(prevCh)-1;
                vowels.put(prevCh, freq);

                if(freq == 0) {
                    vowels.remove(prevCh);
                }

            }else {
                int freq = consonants.get(prevCh)-1;
                consonantCount--;
                consonants.put(prevCh, freq);

                if(freq == 0) {
                    consonants.remove(prevCh);
                }
            }

            char nextChar = word.charAt(i);
            if("aeiou".indexOf(nextChar) != -1) {
                vowels.put(nextChar, vowels.getOrDefault(nextChar, 0) + 1);
            }else  {
                consonants.put(nextChar, consonants.getOrDefault(nextChar, 0) + 1);
                consonantCount++;
            }

            if(vowels.size() == 5 && consonantCount == k) {
                substrings++;
            }
        }
        return substrings;
    }

    public static void main(String[] args) {
        System.out.println(countOfSubstrings("iqeaouqi", 2));
    }
}
