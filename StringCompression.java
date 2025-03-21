public class StringCompression {

    public static int compress(char[] chars) {
        if(chars.length == 1) {
            return 1;
        }

        StringBuilder compressedString = new StringBuilder();
        int idx = 0;

        while(idx < chars.length) {
            char currentCharacter = chars[idx];
            int characterCount = 0;

            while(idx < chars.length && chars[idx] == currentCharacter) {
                characterCount++;
                idx++;
            }

            compressedString.append(currentCharacter);

            if(currentCharacter > 1) {
                for(char ch : String.valueOf(characterCount).toCharArray()) {
                    compressedString.append(ch);
                }
            }
        }
        return compressedString.length();
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
    }
}
