package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

public class IsPalindrome {

    public static boolean checkStringPalindrome(String str, int st, int en) {
        if(st > en) {
            return true;
        }

        if(str.charAt(st) != str.charAt(en)) {
            return false;
        }

        return checkStringPalindrome(str, st+1, en-1);
    }


    public static boolean isStringPalindrome(String str) {
        if(str.isEmpty() || str.length() == 1) {
            return true;
        }
        return checkStringPalindrome(str, 0, str.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(isStringPalindrome("vitul"));
    }
}
