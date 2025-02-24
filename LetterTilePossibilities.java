import java.util.*;

public class LetterTilePossibilities {

    public static void generateLetterTile(String tiles, StringBuilder currString, Set<String> tilesSet, boolean[] isUsed) {
        tilesSet.add(currString.toString());

        for(int i=0; i<tiles.length(); i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                currString.append(tiles.charAt(i));
                generateLetterTile(tiles, currString, tilesSet, isUsed);

                currString.deleteCharAt(currString.length()-1);
                isUsed[i] = false;
            }
        }

    }

    public static int numTilePossibilities(String tiles) {
        Set<String> tilesSet = new HashSet<>();
        boolean[] isUsed = new boolean[tiles.length()];

        generateLetterTile(tiles, new StringBuilder(), tilesSet, isUsed);

        return tilesSet.size()-1;
    }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
    }
}
