public class FindTheStudentThatWillReplaceTheChalk {

    public static int chalkReplacer(int[] chalks, int k) {
        int idx = 0;

        long totalChalkRequired = 0;

        for(int chalk : chalks) {
            totalChalkRequired += chalk;
        }

        int remainingChalk = (int) (k % totalChalkRequired);

        while(chalks[idx] <= remainingChalk) {
            remainingChalk -= chalks[idx];
            idx++;
        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println(chalkReplacer(new int[]{3,4,1,2}, 25));
    }
}
