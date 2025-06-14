
public class MaximumDifferenceByRemappingADigit {

    public static int minMaxDifference(int num) {
        if(num <= 0) {
            return -1;
        }

        StringBuilder maxStr = new StringBuilder(String.valueOf(num));
        StringBuilder minStr = new StringBuilder(String.valueOf(num));

        int pos = 0;

        while(pos < maxStr.length() && maxStr.charAt(pos) == '9') {
            pos++;
        }

        if(pos == maxStr.length()) {
            return num;
        }

        char currentDigit = maxStr.charAt(pos);

        while(pos< maxStr.length()) {
            if(maxStr.charAt(pos) == currentDigit) {
                maxStr.setCharAt(pos, '9');
            }
            pos++;
        }

        currentDigit = minStr.charAt(0);
        pos = 0;

        while(pos < minStr.length()) {
            if(minStr.charAt(pos) == currentDigit) {
                minStr.setCharAt(pos, '0');
            }
            pos++;
        }

        return Integer.parseInt(maxStr.toString()) - Integer.parseInt(minStr.toString());
    }

    public static void main(String[] args) {
        System.out.println(minMaxDifference(99999));
    }
}
