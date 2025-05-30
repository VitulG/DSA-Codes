package Data_Structure_Algorithms_Topic_Wise_Questions.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {

    /*
        Difficulty -> Hard
        Asked By -> Flipkart, Amazon, Microsoft, MMT, Google, Streamoid, Media.net, Atlassian, Goldman Sachs,
                        LinkedIn, Oracle, Adobe, VMware, Walmart

        Approach 1. Brute force is Generate all the substring and check which substring length has the minimum
                        and containing all the chars of t in that substring.
                    TC -> O(n^3)
                    SC -> O(n) // every time which substring length >= t length then I have to check and create a map

        Approach 2. Optimal Using Sliding window + hashing.
                    Step 1. put all those characters of t in a map or frequency array kyuki wo hame chaiye ek substring main
                         2. initialize two pointer left and right and using sliding window caterpillar technique.
                         3. right character ke frequence ko decrease karte raho kyuki vo hamari substring main aa chuke hai aur utno
                                ki ab need nahi hai isiliye.
                         4. uske baad agar jitne hume character required hai agar utne mil gaye hai to check karo uski length and
                                window shrink karna hai jo bhi left character window se hatt rahe hai unki frequence add karni hai
                                kyuki wo character in future hume required ho sakte hai agar kissi character ki freq > 0 ho jaati hai
                                to iska matlab ki vo character chaiye jo ki present hona hi chaiye substring main.
                         5. ese hi right jab exhausted ho jaayega to check karo ki kya koi substring milli hai jiski length hai agar nahi
                                to return "" else starting index + jo bhi window ki length hai.

                         TC -> O(n)
                         SC -> O(58)
     */

    public static String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        int[] freq = new int[58];
        for(char ch : t.toCharArray()) {
            freq[ch-'A']++;
        }

        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int requiredChars = t.length();

        int startingSubstringIndex = -1;

        while(right < s.length()) {
            char currentCharacter = s.charAt(right);

            if(freq[currentCharacter-'A'] > 0) {
                requiredChars--;
            }

            freq[currentCharacter - 'A']--;

            while(requiredChars == 0) {
                int currentLength = right - left + 1;
                if(currentLength < minLength) {
                    startingSubstringIndex = left;
                    minLength = currentLength;
                }

                int leftChar = s.charAt(left);
                freq[leftChar - 'A']++;

                if (freq[leftChar - 'A'] > 0) {
                    requiredChars++;
                }
                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(startingSubstringIndex, startingSubstringIndex + minLength);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
