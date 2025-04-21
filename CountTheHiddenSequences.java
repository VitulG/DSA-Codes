public class CountTheHiddenSequences {

    public static int numberOfArrays(int[] differences, int lower, int upper) {
        int curr = 0;

        int minValue = 0;
        int maxValue = 0;

        for(int difference : differences) {
            curr += difference;
            minValue = Math.min(minValue, curr);
            maxValue = Math.max(maxValue, curr);

            if((upper - maxValue) - (lower - minValue)  + 1 <= 0) {
                return 0;
            }
        }
        return (upper - maxValue) - (lower - minValue) + 1;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArrays(new int[]{1,-3,4}, 1, 6));
    }
}
