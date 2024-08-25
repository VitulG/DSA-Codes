public class ReverseString {

    public static void reverseString(char[] str) {
        int left  = 0;
        int right = str.length-1;

        while(left <= right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }
 
    public static void main(String[] args) {
        char[] str = {'h','e','l','l','o'};
        reverseString(str);

        for(char ch : str) {
            System.out.print(ch+" ");
        }
    }
}
