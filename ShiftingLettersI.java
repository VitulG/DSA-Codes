import java.util.Arrays;

public class ShiftingLettersI {

    public static String shiftingLetters(String str, int[] shifts) {
        StringBuilder shiftingString = new StringBuilder(str);

        int[] preShifts = new int[shifts.length];
        preShifts[preShifts.length-1] = shifts[shifts.length-1];

        for(int i=preShifts.length-2; i>=0; i--) {
            preShifts[i] = (preShifts[i+1] + shifts[i]) % 26;
        }

        for(int i=0; i<str.length(); i++) {
            int nextChar = ((str.charAt(i) -'a') + preShifts[i]) % 26;
            shiftingString.setCharAt(i, (char) (nextChar+'a'));
        }
        return shiftingString.toString();
    }

    public static void main(String[] args) {
        System.out.println(shiftingLetters("xyz", new int[]{3,5,9}));
    }
}
