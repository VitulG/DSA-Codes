public class DeleteCharactersToMakeFancyString {

    public static String makeFancyString(String str) {
        if(str == null || str.isEmpty()) {
            return "";
        }

        int count = 1;
        StringBuilder ans = new StringBuilder();
        ans.append(str.charAt(0));

        char prevCh = str.charAt(0);

        for(int i=1; i<str.length(); i++) {
            char currCh = str.charAt(i);

            if(currCh == prevCh) {
                count++;
                if(count >= 3) {
                    continue;
                }else {
                    ans.append(currCh);
                }
            }else {
                prevCh = currCh;
                count = 1;
                ans.append(currCh);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeFancyString("aaabaaaa"));
    }
}
