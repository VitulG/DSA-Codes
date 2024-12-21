public class ValidPalindrome {

    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while(start < end) {
            char left = Character.toLowerCase(str.charAt(start));
            char right = Character.toLowerCase(str.charAt(end));

            if(!Character.isLetterOrDigit(left)) {
                start++;
            } else if(!Character.isLetterOrDigit(right)) {
                end--;
            } else if(left!= right) {
                return false;
            } else {
                start++;
                end--;
            }
        }

        return true;  // if all characters match or we've gone through the entire string
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
