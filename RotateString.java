public class RotateString {

    public static boolean rotateString(String str, String goal) {
        if(str.length() != goal.length()) {
            return false;
        }

        String temp = str + str;
        return temp.contains(goal);
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "abced"));
    }
}
