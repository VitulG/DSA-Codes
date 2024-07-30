public class MinimumDeletionsToMakeStringBalanced {

    public static int minimumDeletions(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }

        int bcount = 0;
        int removals = 0;

        for(char ch : str.toCharArray()) {
            if(ch == 'b') {
                bcount++;
            }else if(ch == 'a') {
                if(bcount > 0) {
                    removals++;
                    bcount--;
                }
            }
        }
        return removals;
    }

    public static void main(String[] args) {
        System.out.println(minimumDeletions("bbaaaaabb"));
    }
}
