package Leetcode_75.two_pointers;

public class ValidPalindrome {

    public static boolean isPalindrome(String str) {
        if(str.length() == 1 && Character.isLetterOrDigit(str.charAt(0))) {
            return true;
        }


        int le = 0;
        int ri = str.length()-1;

        while(le < ri) {
            while(le < ri && !Character.isLetterOrDigit(str.charAt(le))) {
                le++;
            }

            while(le < ri && !Character.isLetterOrDigit(str.charAt(ri))) {
                ri--;
            }

            if(Character.toLowerCase(str.charAt(le)) != Character.toLowerCase(str.charAt(ri))) {
                return false;
            }
            le++;
            ri--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(".,"));
    }
}
