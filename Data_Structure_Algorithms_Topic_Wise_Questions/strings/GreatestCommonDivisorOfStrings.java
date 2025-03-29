package Data_Structure_Algorithms_Topic_Wise_Questions.strings;

public class GreatestCommonDivisorOfStrings {

    public static String gcdOfStrings(String str1, String str2) {
        // agar string 1 choti hai toh swap karna hai taaki index out of bound na aa jaaye
        if(str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }

        // agar string 2 empty hai to str1 divisible hai jo dono ko divide karega
        if(str2.isEmpty()) {
            return str1;
        }

        // agar prefix string 2 se divide karta hai to uske aage ki string hum check karenge
        if(str1.startsWith(str2)) {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }

        // agar common nahi hai to return nothing
        return "";

    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
    }
}
