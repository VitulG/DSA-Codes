public class AppendCharactersToStringToMakeSubsequence {

    public static int appendCharacter(String s, String t) {
        if(s.equals(t)) {
            return 0;
        }
        
        int len = s.length();

        int tlen = t.length();
        int tidx = 0;

        for(int i=0; i<len && tidx < t.length(); i++) {
            char ch = s.charAt(i);
            char tch = t.charAt(tidx);

            if(ch == tch) {
                tidx++;
            }
        }
        return tlen-tidx;
    }


    public static void main(String[] args) {
        System.out.println(appendCharacter("z", "abcde"));
    }
}