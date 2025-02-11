public class RemoveAllOccurrencesOfASubstring {

    public static String removeOccurrencesWithUsingBuiltinMethod(String str, String part) {
        StringBuilder ans = new StringBuilder(str);

        while(ans.indexOf(part) != -1) {
            int idx = ans.indexOf(part);
            ans.delete(idx, idx+part.length());
        }
        return ans.toString();
    }

    public static String removeOccurrences(String str, String part) {
        StringBuilder ans = new StringBuilder();

        for(char ch : str.toCharArray()) {
            ans.append(ch);

            if(ans.length() >= part.length()) {
                boolean isMatched = true;
                for(int i=0; i<part.length(); i++) {
                    if(part.charAt(i) != ans.charAt(ans.length() - part.length() + i)) {
                        isMatched = false;
                        break;
                    }
                }

                if(isMatched) {
                    ans.setLength(ans.length() - part.length());
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }
}
