package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class ValidPalindromeII {

    public static boolean isPalindrome(String str, int st, int en) {
        while(st < en) {
            if(str.charAt(st) != str.charAt(en)) {
                return false;
            }
            st++;
            en--;
        }
        return true;
    }

    public static boolean validPalindrome(String str) {
        if(str.length() <= 2) {
            return true;
        }

        int le = 0;
        int ri = str.length()-1;

        while(le < ri) {
            if(str.charAt(le) != str.charAt(ri)) {
                // agar mismatch hai to mujhe left se bhi aur right se bhi check karna hoga ki vo
                // palindrome hai ki nahi agar hai to return true kyuki humne sab check kar liya hai
                // else return false nahi mila koi palindrome
                return isPalindrome(str, le+1, ri) || isPalindrome(str, le, ri-1);
            }
            le++;
            ri--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }
}
