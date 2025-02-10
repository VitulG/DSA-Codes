public class ClearDigits {

    public static String clearDigits(String str) {
        StringBuilder ans = new StringBuilder();

        for(char ch : str.toCharArray()) {
            if(Character.isDigit(ch)) {
                if(!ans.isEmpty()) {
                    ans.deleteCharAt(ans.length()-1);
                }
            }else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(clearDigits("cb34"));
    }
}
