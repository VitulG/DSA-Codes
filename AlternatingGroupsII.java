public class AlternatingGroupsII {

    public static boolean isAlternatives(int[] colors, int start, int k, int len) {
        for(int i=0; i<k-1; i++) {
            if(colors[(start + i) % len] == colors[(start + i + 1)%len]) {
                return false;
            }
        }
        return true;
    }

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int len = colors.length;
        int groups = 0;

        if(isAlternatives(colors, 0, k, len)) {
            groups++;
        }

        for(int i=1; i<len; i++) {
            if(isAlternatives(colors, i, k, len)) {
                groups++;
            }
        }
        return groups;
    }

    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[]{0,1,0,0,1,0,1}, 6));
    }
}
