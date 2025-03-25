package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class ReverseString {

    public static void reverseString(char[] str) {
        int le = 0;
        int ri = str.length-1;

        while(le < ri) {
            char temp = str[le];
            str[le] = str[ri];
            str[ri] = temp;
            le++;
            ri--;
        }
    }

    public static void main(String[] args) {

    }
}
