public class MaxDifferenceYouCanGetFromChangingAnInteger {

    public static int maxDiff(int num) {
        StringBuilder min = new StringBuilder(String.valueOf(num));
        StringBuilder max = new StringBuilder(String.valueOf(num));

        int pos = 0;

        while(pos < max.length() && max.charAt(pos) == '9') {
            pos++;
        }

        if(pos < max.length()) {
            char ch = max.charAt(pos);
            while (pos < max.length()) {
                if(max.charAt(pos) == ch) {
                    max.setCharAt(pos, '9');
                }
                pos++;
            }
        }


        pos = 0;
        while(pos < min.length() && min.charAt(pos) == '1') {
            pos++;
        }

        if(pos < min.length()) {
            char ch = min.charAt(pos);
            if(pos == 0) {
                while(pos < min.length()) {
                    if(min.charAt(pos) == ch) {
                        min.setCharAt(pos, '1');
                    }
                    pos++;
                }
            }else {
                while(pos < min.length()) {
                    if(min.charAt(pos) == ch) {
                        min.setCharAt(pos, '0');
                    }
                    pos++;
                }
            }
        }
        return Integer.parseInt(max.toString()) - Integer.parseInt(min.toString());
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(1919));
    }
}
