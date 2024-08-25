public class CountNumberOfTeams {

    public static int numTeams(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }

        int len = ratings.length;
        int teams = 0;

        for(int mid = 0; mid < len; mid++) {
            int leftSmaller = 0;
            int leftLarger = 0;
            int rightSmaller = 0;
            int rightLarger = 0;

            for(int small =0; small < mid; small++) {
                if(ratings[small] < ratings[mid]) {
                    leftSmaller++;
                }else if(ratings[small] > ratings[mid]) {
                    leftLarger++;
                }
            }

            for(int large = mid+1; large < len; large++) {
                if(ratings[large] < ratings[mid]) {
                    rightSmaller++;
                }else if(ratings[large] > ratings[mid]) {
                    rightLarger++;
                }
            }
            teams += leftLarger * rightSmaller + rightLarger * leftSmaller;
        }
        return teams;
    }


    public static void main(String[] args) {
        System.out.println(numTeams(new int[]{2,5,3,4,1}));
    }
}
