public class ThreeConsecutiveOdds {
    public static boolean threeConsecutiveOdds(int[] arr) {
        int consecutive = 0;
        
        for(int num : arr) {
            consecutive = (num%2!=0) ? consecutive + 1 : 0;

            if(consecutive == 3) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12}));
    }
}
