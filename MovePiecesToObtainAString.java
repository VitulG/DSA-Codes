public class MovePiecesToObtainAString {

    public static boolean canChange(String start, String target) {
        int si = 0;
        int ti = 0;

        int len = start.length();

        while(si < len || ti < len) {
            while(si < len && start.charAt(si) == '_') {
                si++;
            }

            while(ti < len && target.charAt(ti) == '_') {
                ti++;
            }

            if(si == len || ti == len) {
                return si == len && ti == len;
            }

            if(start.charAt(si) != target.charAt(ti)) {
                return false;
            }

            if(start.charAt(si) == 'L' && ti > si) {
                return false;
            }

            if(start.charAt(si) == 'R' && si > ti) {
                return false;
            }
            si++;
            ti++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canChange("_____LRLR", "L___L__RR"));
    }
}
