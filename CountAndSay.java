public class CountAndSay {

    public static String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }

        String str = countAndSay(n-1);

        StringBuilder newString = new StringBuilder();
        int idx = 0;

        while(idx < str.length()) {
            char ch = str.charAt(idx);
            int count = 1;
            int next = idx+1;

            while(next < str.length() && str.charAt(next) == ch) {
                count++;
                next++;
            }
            newString.append(count).append(ch);
            idx = next;
        }
        return newString.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
