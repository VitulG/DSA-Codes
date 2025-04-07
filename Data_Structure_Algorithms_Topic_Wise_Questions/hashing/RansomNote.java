package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineArr = new int[26];

        for(char ch : magazine.toCharArray()) {
            magazineArr[ch-'a']++;
        }

        for(char ch : ransomNote.toCharArray()) {
            if(magazineArr[ch-'a'] == 0) {
                return false;
            }
            magazineArr[ch-'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("vitul", "vgitueldisf"));
    }
}
