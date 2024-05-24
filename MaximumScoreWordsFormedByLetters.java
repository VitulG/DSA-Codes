public class MaximumScoreWordsFormedByLetters {

    public static int generateMaxScore(String[] words, int idx, int[] letterCount, int[] score) {
        if(idx >= words.length) {
            return 0;
        }

        int notTake = generateMaxScore(words, idx + 1, letterCount, score);

        // Case 2: Try to include the current word if possible
        String currWord = words[idx];
        boolean canTake = true;
        int wordScore = 0;

        for (char ch : currWord.toCharArray()) {
            if (--letterCount[ch - 'a'] < 0) {
                canTake = false;
            }
            wordScore += score[ch - 'a'];
        }

        int take = 0;
        if (canTake) {
            take = wordScore + generateMaxScore(words, idx + 1, letterCount, score);
        }

        // Restore the letter count array
        for (char ch : currWord.toCharArray()) {
            letterCount[ch - 'a']++;
        }
        return Math.max(take, notTake);

    }


    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letterCount = new int[26];
        for(char ch : letters) {
            letterCount[ch-'a']++;
        }
        return generateMaxScore(words, 0, letterCount, score);
    }


    public static void main(String[] args) {
        System.out.println(maxScoreWords(new String[]{"azb","ax","awb","ayb","bpppp"}, 
                    new char[]{'z','a','w','x','y','b','p','p','p'}, 
                    new int[]{10,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,3,2,3,3}));
    }
}
