public class DivisibleAndNonDivisibleSumsDifference {

    public static int differenceOfSums(int n, int m) {
//        int divisibleSum = 0;
//        int notDivisibleSum = 0;
//
//        for(int i=1; i<=n; i++) {
//            if(i % m == 0) {
//                divisibleSum += i;
//            }else {
//                notDivisibleSum += i;
//            }
//        }
//        return notDivisibleSum - divisibleSum;

        //simple maths
        int k = n/m;

        int totalSum = n * (n + 1) / 2;

        return totalSum - m * k * (k + 1);
    }

    public static void main(String[] args) {
        System.out.println(differenceOfSums(5, 6));
    }
}
