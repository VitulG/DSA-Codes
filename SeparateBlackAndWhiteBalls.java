public class SeparateBlackAndWhiteBalls {

    public static long minimumSteps(String str) {
        long blacks = 0L;
        long steps = 0L;

        for(char ch : str.toCharArray()) {
            if(ch == '0') {
                steps += blacks;
            }else {
                blacks++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(minimumSteps("100110011"));
    }
}
