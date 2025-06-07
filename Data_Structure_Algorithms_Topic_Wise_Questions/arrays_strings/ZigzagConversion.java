package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

    /*
         Approach:
            - To convert the string into a zigzag pattern:
                1. Use a list of StringBuilder objects to represent each row.
                2. Traverse the input string and add each character to the appropriate row.
                3. Use a direction flag (`isDown`) to simulate the zigzag by moving up/down the rows.
                4. When the top or bottom row is reached, flip the direction.
                5. After all characters are placed in rows, concatenate all rows to get the final result.

            Time Complexity: O(n), where n is the length of the input string.
                - Each character is processed once and added to a row.

            Space Complexity: O(r), where r is the number of rows.
                - We store r StringBuilders which collectively hold n characters.
     */

    public static String convert(String str, int numRows) {
        if(str.isEmpty()) {
            return "";
        }

        if(numRows == 1) {
            return str;
        }

        List<StringBuilder> rows = new ArrayList<>();

        for(int i=0; i<numRows; i++) {
            rows.add(new StringBuilder());
        }

        boolean isDown = true;
        int row = 0;

        for(int i =0; i<str.length(); i++) {
            rows.get(row).append(str.charAt(i));
            if(isDown) {
                row += 1;
            }else {
                row -= 1;
            }
            if(row == rows.size()-1 || row == 0) {
                isDown =! isDown;
            }
        }

        StringBuilder zigzagString = new StringBuilder();

        for(StringBuilder r : rows) {
            zigzagString.append(r);
        }
        return zigzagString.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("VITULGUPTAISLOOKINGFORAJOB", 7));
    }
}
