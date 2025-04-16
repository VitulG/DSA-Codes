public class CountSymmetricIntegers {

    public static int getSum(String str) {
        int sum = 0;

        for(char ch : str.toCharArray()) {
            sum += (ch-'0');
        }
        return sum;
    }

    public static int countSymmetricIntegers(int low, int high) {
        int ints = 0;

        for(int i=low; i<=high; i++) {
            String str = String.valueOf(i);

            if(str.length()%2 == 0) {
                String leftSub = str.substring(0, str.length()/2);
                String rightSub = str.substring(str.length()/2);

                int leftSum = getSum(leftSub);
                int rightSum = getSum(rightSub);

                if(leftSum == rightSum) {
                    ints++;
                }
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1, 100));
    }
}
