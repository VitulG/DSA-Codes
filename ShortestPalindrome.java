public class ShortestPalindrome {
    public static String shortestPalindrome(String str) {
        // we can also use KMP algorithm to calculate the shortest palindrome

        StringBuilder original = new StringBuilder(str);
        StringBuilder reversed = new StringBuilder(original).reverse();

        for(int i=0; i<original.length(); i++) {
            if(original.substring(0, original.length()-i).equals(reversed.substring(i))){
                String rem = reversed.substring(0, i);
                return rem + str;
            }
        }
        return reversed + str;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abcd"));
    }
}
