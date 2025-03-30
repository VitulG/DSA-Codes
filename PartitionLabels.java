import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public static List<Integer> partitionLabels(String str) {
        List<Integer> partitions = new ArrayList<>();

        if(str.length() == 1) {
            partitions.add(1);
            return partitions;
        }

        // phehle step mein main store kar kiya har character ka last index in map
        Map<Character, Integer> charLstIdx = new HashMap<>();

        for(int i=0; i<str.length(); i++) {
            charLstIdx.put(str.charAt(i), i);
        }

        // step 2. har index ke character ko leke ek window banaunga jaha uska last index hai
        // agar uss window main kiss char ka last index > curr End se to main update kar dunga current window ke
        // last index ko

        int idx = 0;

        while(idx < str.length()) {
            char currChar = str.charAt(idx);
            int currWindowEnd = charLstIdx.get(currChar);
            int j = idx;

            while(j <= currWindowEnd) {
                char nextChar = str.charAt(j);
                int nextWindowEnd = charLstIdx.get(nextChar);
                currWindowEnd = Math.max(currWindowEnd, nextWindowEnd);
                j++;
            }
            partitions.add(j - idx);
            idx = j;
        }
        return partitions;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
