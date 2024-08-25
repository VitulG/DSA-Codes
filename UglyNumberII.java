public class UglyNumberII {

    public static int nthUglyNumber(int num) {

        if(num == 0) {
            return 0;
        }

        int[] uglyNumbers = new int[num+1];
        uglyNumbers[1] = 1;
        
        int n2;
        int n3;
        int n5;

        n2 = n3 = n5 = 1;

        for(int i=2; i<=num; i++) {
            int t2Num = uglyNumbers[n2]*2;
            int t3Num = uglyNumbers[n3]*3;
            int t5Num = uglyNumbers[n5]*5;

            int minUglyNumber = Math.min(t2Num, Math.min(t3Num, t5Num));

            uglyNumbers[i] = minUglyNumber;

            if(minUglyNumber == t2Num) {
                n2++;
            }

            if(minUglyNumber == t3Num) {
                n3++;
            }

            if(minUglyNumber == t5Num) {
                n5++;
            }
        }
        return uglyNumbers[num];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(0));
    }
}
