public class FindMissingObservations {

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean * (m + n);

        int currentElementSum = 0;

        for(int roll : rolls) {
            currentElementSum += roll;
        }

        int missingSum = totalSum - currentElementSum;

        if(missingSum < n || missingSum > 6*n)  {
            return new int[]{};
        }

        int[] missingRolls = new int[n];
        int idx = -1;

        while(n > 0) {
            int dice = Math.min(6, missingSum - n + 1);
            missingRolls[++idx] = dice;
            missingSum -= dice;
            n -= 1;
        }
        return missingRolls;
    }

    public static void main(String[] args) {
        int[] result = missingRolls(new int[]{3,2,4,3}, 4, 2);
        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}
