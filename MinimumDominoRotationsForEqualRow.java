public class MinimumDominoRotationsForEqualRow {

    public static int getRotations(int[] tops, int[] bottoms, int val) {
        int len = tops.length;

        int rotationsFromTop = 0;
        int rotationsFromBottom = 0;

        for(int i=0; i<len; i++) {
            if(tops[i] != val && bottoms[i] != val) {
                return -1;
            }else if(tops[i] != val) {
                rotationsFromTop++;
            }else {
                rotationsFromBottom++;
            }
        }
        return Math.min(rotationsFromTop, rotationsFromBottom);
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int minRotations = Integer.MAX_VALUE;

        for(int i=1; i<=6; i++) {
            int currRotations = getRotations(tops, bottoms, i);
            if(currRotations != -1) {
                minRotations = Math.min(minRotations, currRotations);
            }
        }
        return minRotations == Integer.MAX_VALUE ? -1 : minRotations;
    }

    public static void main(String[] args) {
        System.out.println(minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
    }
}
