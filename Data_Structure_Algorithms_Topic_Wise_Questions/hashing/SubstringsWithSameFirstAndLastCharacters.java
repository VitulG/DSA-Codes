package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

public class SubstringsWithSameFirstAndLastCharacters {

    /*
        Approach 1. Brute force approach generates all possible substrings and checks if the first and last character
                        matches or not if yes count that substring.
                    TC -> O(n^2)
                    SC -> O(1)

        Approach 2. Using Hashing, the first key observation is a character can form by itself or if the length >= 2 so
                        first and last character must be matched. so we can take subarray formula it will get those substrings
                        which will count that it will form that many substring of character c with its frequency f.
                    TC -> O(n)
                    SC -> O(1)
     */

    public static int countSubstrings(String s) {
        if(s.isEmpty()) {
            return 0;
        }

        int[] frequencies = new int[26];

        for(char ch : s.toCharArray()) {
            frequencies[ch-'a']++;
        }

        int substrings = 0;

        for(int frequency : frequencies ) {
            substrings += (frequency * (frequency +1) /2);
        }
        return substrings;

    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abcdcabb"));
    }
}
