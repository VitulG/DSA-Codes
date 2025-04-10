public class CountTheNumberOfPowerfulIntegers {

    public static long getPowerfulIntegers(long start, long finish, int limit, String str, StringBuilder curr) {
        if(!curr.isEmpty() && (Long.parseLong(curr.toString()) > finish || Long.parseLong(curr.toString()) < start)) {
            return 0L;
        }

        if(!curr.isEmpty() && Long.parseLong(curr.toString()) >= start && Long.parseLong(curr.toString()) <= finish) {
            return 1L;
        }

        long count = 0L;

        for(int i=1; i<=limit; i++) {
            int len = curr.length();
            curr.append(i).append(str);
            count += getPowerfulIntegers(start, finish, limit, str, curr);
            curr.setLength(len);
        }
        return count;
    }

    /*
    * We need to study about Digit DP and combinatorics
    * Here I have used Backtracking here,
    * but I don't think it's an efficient solution
    * nevertheless I will come back to this question
    */


    public static long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long powerIntegers = getPowerfulIntegers(start, finish, limit, s, new StringBuilder());
        long currNumber = Integer.parseInt(s);

        return currNumber >= start && currNumber <= finish ? powerIntegers + 1 : powerIntegers;
    }

    public static void main(String[] args) {
        System.out.println(numberOfPowerfulInt(1, 6000, 4, "124"));
    }
}
