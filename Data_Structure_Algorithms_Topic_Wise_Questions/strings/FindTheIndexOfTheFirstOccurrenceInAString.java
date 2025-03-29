package Data_Structure_Algorithms_Topic_Wise_Questions.strings;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static int strStr(String haystack, String needle) {

        // my brute force solution with Time Complexity is O(haystack length * needle length)
        if(needle.length() > haystack.length()) {
            return -1;
        }

        if(haystack.equals(needle)) {
            return 0;
        }

        for(int i=0; i<haystack.length(); i++) {
            int j = 0;

            while(j < needle.length() && i+j < haystack.length() &&
                    haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
            }

            if(j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "but"));
    }
}
