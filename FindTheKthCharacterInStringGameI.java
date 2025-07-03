public class FindTheKthCharacterInStringGameI {

    public static char kthCharacter(int k) {
        if(k == 1) {
            return 'a';
        }

        StringBuilder word = new StringBuilder("a");

        while(word.length() < k) {
            StringBuilder temp = new StringBuilder();

            for(char ch : word.toString().toCharArray()) {
                char next = (ch == 'z') ? 'a' : (char) (ch+1);
                temp.append(next);
            }
            word.append(temp);
        }
        return word.charAt(k-1);
    }

    public static void main(String[] args) {
        System.out.println(kthCharacter(10));
    }
}
