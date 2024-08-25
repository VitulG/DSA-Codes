import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class NumberOfAtoms {

    public static String countOfAtoms(String formula) {
        if (formula == null || formula.isEmpty()) {
            return "";
        }

        Stack<TreeMap<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        int idx = 0;
        int len = formula.length();

        while (idx < len) {
            if (formula.charAt(idx) == '(') {
                stack.push(new TreeMap<>());
                idx++;
            } else if (formula.charAt(idx) == ')') {
                TreeMap<String, Integer> currMap = stack.pop();
                idx++;

                StringBuilder multiplierSb = new StringBuilder();
                while (idx < len && Character.isDigit(formula.charAt(idx))) {
                    multiplierSb.append(formula.charAt(idx));
                    idx++;
                }

                int multiplier = multiplierSb.length() > 0 ? Integer.parseInt(multiplierSb.toString()) : 1;
                for (Map.Entry<String, Integer> entry : currMap.entrySet()) {
                    String key = entry.getKey();
                    int value = entry.getValue();
                    currMap.put(key, value * multiplier);
                }

                // Merge with previous map
                TreeMap<String, Integer> prevMap = stack.peek();
                for (Map.Entry<String, Integer> entry : currMap.entrySet()) {
                    String key = entry.getKey();
                    int value = entry.getValue();
                    prevMap.put(key, prevMap.getOrDefault(key, 0) + value);
                }
            } else {
                StringBuilder currAtom = new StringBuilder();
                currAtom.append(formula.charAt(idx));
                idx++;
                
                while (idx < len && Character.isLowerCase(formula.charAt(idx))) {
                    currAtom.append(formula.charAt(idx));
                    idx++;
                }

                StringBuilder moleculesSb = new StringBuilder();
                while (idx < len && Character.isDigit(formula.charAt(idx))) {
                    moleculesSb.append(formula.charAt(idx));
                    idx++;
                }

                int count = moleculesSb.length() > 0 ? Integer.parseInt(moleculesSb.toString()) : 1;
                stack.peek().put(currAtom.toString(), stack.peek().getOrDefault(currAtom.toString(), 0) + count);
            }
        }

        StringBuilder ans = new StringBuilder();
        TreeMap<String, Integer> map = stack.pop();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            ans.append(key);
            if (value > 1) {
                ans.append(value);
            }
        }
        return ans.toString();

    }

    public static void main(String[] args) {
        System.out.println(countOfAtoms("H11He49NO35B7N46Li20"));
    }    
}
