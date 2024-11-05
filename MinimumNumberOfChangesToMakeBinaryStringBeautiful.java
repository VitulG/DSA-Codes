public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {

    public static int minChanges(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }

        int minChanges = 0;

        for(int i=0; i<str.length(); i+=2) {
            if (str.charAt(i) != str.charAt(i+1)) {
                minChanges++;
            }
        }
        return minChanges;
    }

    public static void main(String[] args) {
        System.out.println(minChanges("11000111"));
    }
}
