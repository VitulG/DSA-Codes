import java.util.HashMap;
import java.util.Map;

public class FindTheLongestSubstringContainingVowelsInEvenCounts {
    public static int findTheLongestSubstring(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }

        int[] vowelsCount = new int[5];

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("00000", -1);

        int result = Integer.MIN_VALUE;

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'a') {
                vowelsCount[0] = (vowelsCount[0]+1)%2;
            }else if(str.charAt(i) == 'e'){
                vowelsCount[1] = (vowelsCount[1]+1)%2;
            }else if(str.charAt(i) == 'i'){
                vowelsCount[2] = (vowelsCount[2]+1)%2;
            }else if(str.charAt(i) == 'o') {
                vowelsCount[3] = (vowelsCount[3]+1)%2;
            }else if(str.charAt(i) == 'u'){
                vowelsCount[4] = (vowelsCount[4]+1)%2;
            }

            StringBuilder currentState = new StringBuilder();

            for(int j=0; j<5; j++) {
                currentState.append(vowelsCount[j]);
            }

            if(map.containsKey(currentState.toString())) {
                result = Math.max(result, i - map.get(currentState.toString()));
            }else{
                map.put(currentState.toString(), i);
            }
        }
        return result == Integer.MIN_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("leetcodeisgreat"));
    }
}
