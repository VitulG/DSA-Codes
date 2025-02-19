public class FindThePunishmentNumberOfAnInteger {

    public static boolean canPartitionSubstring(String str, int idx, int currSum, int target) {
        if(idx >= str.length()) {
            return currSum == target;
        }

        for(int currIdx = idx; currIdx < str.length(); currIdx++) {
            int value = Integer.parseInt(str.substring(idx, currIdx+1));

            if(canPartitionSubstring(str, currIdx+1, currSum + value, target)) {
                return true;
            }

        }
        return false;
    }

    public static int punishmentNumber(int num) {
        int punishmentNum = 0;

        for(int i=1; i<=num; i++) {
            int square = i * i;

            if(canPartitionSubstring(String.valueOf(square), 0, 0, i)) {
                punishmentNum += square;
            }
        }
        return punishmentNum;
    }

    public static void main(String[] args) {
        System.out.println(punishmentNumber(10));
    }
}
