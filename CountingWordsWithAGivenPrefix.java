public class CountingWordsWithAGivenPrefix {

    public static int prefixCount(String[] words, String pref) {
        int strings = 0;

        for(String word : words) {
            if(word.startsWith(pref)) {
                strings+=1;
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        System.out.println(prefixCount(new String[]{"pay","attention","practice","attend"}, "at"));
    }
}
