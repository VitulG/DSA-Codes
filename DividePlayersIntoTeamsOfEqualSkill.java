import java.util.Arrays;

public class DividePlayersIntoTeamsOfEqualSkill {
    public static long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int le = 0;
        int ri = skill.length - 1;

        long fixTotal = skill[le] + skill[ri];
        long ans = 0L;

        while(le < ri) {
            long currSum = (long) skill[le] + skill[ri];
            if(currSum != fixTotal) {
                return -1;
            }
            ans += (long) skill[le] * skill[ri];
            le++;
            ri--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(dividePlayers(new int[]{1,1,2,3}));
    }
}
