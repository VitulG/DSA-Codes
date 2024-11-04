public class StringCompressionIII {

    public static String compressedString(String word) {
        if(word == null || word.isEmpty()) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        int st = 0;

        while(st < word.length()) {
            char currCh = word.charAt(st);
            int count = 1;

            while(st < word.length()-1 && word.charAt(st+1) == currCh && count < 9) {
                count++;
                st++;
            }
            ans.append(count).append(currCh);
            st++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressedString("aaaaaaaaaaaaaabb"));
    }
}
