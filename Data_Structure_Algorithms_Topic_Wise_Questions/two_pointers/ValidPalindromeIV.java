package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class ValidPalindromeIV {

    public static boolean possibleToMakePalindrome(String str) {
        if(str.isEmpty()) {
            return true;
        }

        int le = 0;
        int ri = str.length()-1;
        int mismatches = 0;

        while(le < ri) {
            if(str.charAt(le) != str.charAt(ri)) {
                mismatches++;
            }
            le++;
            ri--;
        }
        return mismatches <= 2;
    }

    public static void main(String[] args) {
        System.out.println(possibleToMakePalindrome("abcdef"));
    }
}
