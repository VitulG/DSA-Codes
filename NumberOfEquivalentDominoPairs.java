public class NumberOfEquivalentDominoPairs {

    /*
        Approach 1. to make every pair with each domino
            TC -> O(n^2), SC -> O(1)

        Approach 2. using hashing, we can check if we have found that domino previously stores it in a map how much time it occurs
                        and make a pair
            TC -> O(n), SC -> O(n)
     */

    public static int numEquivDominoPairs(int[][] dominoes) {
        int pairs = 0;
        for(int i=0; i<dominoes.length; i++) {
            int[] currentDomino = dominoes[i];
            for(int j=i+1; j<dominoes.length; j++) {
                int[] nextDomino = dominoes[j];

                if((currentDomino[0] == nextDomino[0] && currentDomino[1] == nextDomino[1]) ||
                        (currentDomino[0] == nextDomino[1] &&  currentDomino[1] == nextDomino[0])) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(numEquivDominoPairs(new int[][]{
                {1,2},
                {1,2},
                {1,1},
                {1,2},
                {2,2}
        }));
    }
}
