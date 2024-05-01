public class ValidParenthesesString {

    public static boolean checkValidString(String str) {
        int open =0;
        int close =0;

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(') {
                open+=1;
                close+=1;
            }else if(ch == ')') {
                open-=1;
                close-=1;
            }else if(ch == '*') {
                open-=1;
                close+=1;
            }

            if(close < 0) {
                return false;
            }

            if(open < 0) {
                open = 0;
            }

        }
        return open == 0;

    }

    public static void main(String[] args) {
        System.out.println(checkValidString("(*))"));
    }    
}
