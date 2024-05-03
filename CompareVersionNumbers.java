public class CompareVersionNumbers {

    public static int compareVersion(String version1, String version2) {

        String[] words1 = version1.split("\\.");
        String[] words2 = version2.split("\\.");

        int length = Math.max(words1.length, words2.length);

        for(int i=0; i<length; i++) {
            int v1 = (i < words1.length) ? Integer.parseInt(words1[i]) : 0;
            int v2 = (i < words2.length) ? Integer.parseInt(words2[i]) : 0;

            if(v1 < v2) {
                return -1;
            }else if(v1 > v2) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0.1", "1"));
    }
}
