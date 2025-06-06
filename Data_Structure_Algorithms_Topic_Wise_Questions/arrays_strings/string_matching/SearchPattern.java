package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings.string_matching;

public class SearchPattern {

    /*
        Approach: -
            - Use brute force to check whether the pattern exists in the given text.
            - Iterate through the text and compare each substring of length equal to the pattern.
            - Return true if a match is found, else return false.

            Time Complexity: O(t * p), where 't' is the length of the text and 'p' is the length of the pattern.
            Space Complexity: O(1)
     */

    public static boolean isPatternPresent(String txt, String pat) {
        if(txt.isEmpty() || pat.isEmpty() || pat.length() > txt.length()) {
            return false;
        }

        for(int i=0; i<=txt.length() - pat.length(); i++) {
            int j = 0;

            while(j < pat.length() && pat.charAt(j) == txt.charAt(i+j)) {
                j++;
            }

            if(j == pat.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPatternPresent("aaabc", "aabc"));
    }
}
