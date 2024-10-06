public class SentenceSimilarityIII {

    public static boolean isMatchWords(String[] words1, String[] words2) {
        int i = 0;
        int j = words1.length-1;
        int k = 0;
        int l = words2.length-1;

        while(i < words1.length && k < words2.length && words1[i].equals(words2[k])) {
            i++;
            k++;
        }

        if(k == words2.length) {
            return true;
        }

        while(j >= 0 && l >= 0 && words1[j].equals(words2[l])) {
            j--;
            l--;

            if(l < k) {
                return true;
            }
        }
        return false;
    }


    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split("\\s+");
        String[] words2 = sentence2.split("\\s+");

        if(words1.length < words2.length) {
            return isMatchWords(words2, words1);
        }
        return isMatchWords(words1, words2);
    }

    public static void main(String[] args) {
        System.out.println(areSentencesSimilar("Eating right now", "Eating"));
    }
}
