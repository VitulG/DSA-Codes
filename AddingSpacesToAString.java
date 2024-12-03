public class AddingSpacesToAString {

    public static String addSpaces(String str, int[] spaces) {
        int spIdx = 0;
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<str.length(); i++) {
            if(spIdx < spaces.length && i == spaces[spIdx]) {
                ans.append(" ").append(str.charAt(i));
                spIdx++;
            }else{
                ans.append(str.charAt(i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(addSpaces("spacing", new int[]{0,1,2,3,4,5,6}));
    }
}
