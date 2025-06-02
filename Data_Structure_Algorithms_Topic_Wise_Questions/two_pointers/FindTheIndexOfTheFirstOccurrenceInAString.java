package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    /*
        Approach: - Key approach is to use String matching when we find a first character of needle in haystack
                        just check if its same throughout needle's length if yes return that index which we
                        saw first character or else return -1.
                    TC -> O(n*m)
                    SC -> O(1)
     */

    public static int strStr(String haystack, String needle) {
        if(haystack.isEmpty()) {
            return -1;
        }

        if(needle.isEmpty()) {
            return 0;
        }

        for(int i=0; i<=haystack.length() - needle.length(); i++) {
            int j = i;
            int k = 0;

            while(j < haystack.length() && k < needle.length() && haystack.charAt(j) == needle.charAt(k)) {
                j++;
                k++;
            }

            if(k == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("abc", "c"));
    }
}
