import java.util.Arrays;

public class PushDominoes {

    public static String pushDominoes(String dominoes) {
        if(dominoes.isEmpty()) {
            return "";
        }

        int[] closestRFromLeftToRight = new int[dominoes.length()];
        closestRFromLeftToRight[0] = (dominoes.charAt(0) == 'R') ? 0 : -1;

        for(int i=1; i<dominoes.length(); i++) {
            if(dominoes.charAt(i) == 'L') {
                closestRFromLeftToRight[i] = -1;
            }else if(dominoes.charAt(i) == 'R') {
                closestRFromLeftToRight[i] = i;
            }else {
                closestRFromLeftToRight[i] = closestRFromLeftToRight[i-1];
            }
        }

        int[] closestLFromRightToLeft = new int[dominoes.length()];
        closestLFromRightToLeft[dominoes.length()-1] = dominoes.charAt(dominoes.length()-1) == 'L' ? dominoes.length()-1 : -1;

        for(int i = dominoes.length()-2; i>=0; i--) {
            if(dominoes.charAt(i) == 'R') {
                closestLFromRightToLeft[i] = -1;
            }else if(dominoes.charAt(i) == 'L') {
                closestLFromRightToLeft[i] = i;
            }else {
                closestLFromRightToLeft[i] = closestLFromRightToLeft[i+1];
            }
        }

        StringBuilder ans = new StringBuilder();

        for(int i=0; i<dominoes.length(); i++) {
            if(closestRFromLeftToRight[i] == -1 && closestLFromRightToLeft[i] == -1) {
                ans.append(".");
            }else if(closestLFromRightToLeft[i] == -1) {
                ans.append("R");
            }else if(closestRFromLeftToRight[i] == -1) {
                ans.append("L");
            }else {
                int rDistance = Math.abs(i - closestRFromLeftToRight[i]);
                int lDistance = Math.abs(i - closestLFromRightToLeft[i]);

                if(rDistance == lDistance) {
                    ans.append(".");
                }else {
                    if(rDistance < lDistance) {
                        ans.append("R");
                    }else{
                        ans.append("L");
                    }
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(pushDominoes(".L.R...LR..L.."));
    }
}
