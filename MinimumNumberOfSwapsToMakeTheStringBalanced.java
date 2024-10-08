public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    public static int minSwaps(String str) {
        if(str.isEmpty()) {
            return 0;
        }

        int openBracket = 0;

        for(char ch : str.toCharArray()) {
            if(ch == '[') {
                openBracket++;
            }else if(openBracket > 0) {
                openBracket--;
            }
        }
        return (openBracket+1)/2;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps("][]["));
    }
}
