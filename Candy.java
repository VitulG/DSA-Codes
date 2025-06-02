import java.util.Arrays;

public class Candy {

    public static int candy(int[] ratings) {
        if(ratings.length == 0) {
            return 0;
        }

        int[] distributedCandies = new int[ratings.length];
        Arrays.fill(distributedCandies, 1);

        for(int i = 1; i<ratings.length; i++) {
            distributedCandies[i] = (ratings[i] > ratings[i-1]) ? distributedCandies[i-1] + 1 : distributedCandies[i];
        }

        for(int i = ratings.length-2; i>=0; i--) {
            distributedCandies[i] = (ratings[i] > ratings[i+1] && distributedCandies[i] <= distributedCandies[i+1]) ?
                    distributedCandies[i+1] + 1 : distributedCandies[i];
        }

        int totalCandiesDistributed = 0;

        for(int candies : distributedCandies) {
            totalCandiesDistributed += candies;
        }
        return totalCandiesDistributed;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,2,2}));
    }
}
