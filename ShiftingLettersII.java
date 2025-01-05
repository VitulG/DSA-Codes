import java.util.Arrays;

public class ShiftingLettersII {

    public static String shiftingLetters(String str, int[][] shifts) {
        // we will use difference array technique
        // step 1. build difference array using shifts index and their direction
        int[] diffArr = new int[str.length()];

        for(int[] shift : shifts) {
            int le = shift[0];
            int ri = shift[1];
            int dir = shift[2];

            if(dir == 0) {
                diffArr[le] -= 1;
                if(ri + 1 < str.length()) {
                    diffArr[ri+1] += 1;
                }
            }else {
                diffArr[le] += 1;
                if(ri + 1 < str.length()) {
                    diffArr[ri+1] -= 1;
                }
            }
        }

        // step 2. find the cumulative sum in the diff array
        for(int i=1; i<diffArr.length; i++) {
            diffArr[i] = diffArr[i] + diffArr[i-1];
        }

        // step 3. build the new string
        StringBuilder ans = new StringBuilder(str);

        for(int i=0; i<str.length(); i++) {
            int charShifts = diffArr[i]%26;

            if(charShifts < 0) {
                charShifts += 26;
            }

            int totalShifts = ((ans.charAt(i)-'a') + charShifts)%26;
            ans.setCharAt(i, (char)(totalShifts+'a'));
        }
        return ans.toString();
    }

    // TC => O(Q+N)
    // SC => O(N)

    public static void main(String[] args) {
        System.out.println(shiftingLetters("ctmw", new int[][]{
                {0,1,0},
                {1,2,1},
                {1,3,1},
                {2,3,0}
        }));
    }
}
