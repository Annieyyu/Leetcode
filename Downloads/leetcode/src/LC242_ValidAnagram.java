import java.util.HashMap;
import java.util.Map;

public class LC242_ValidAnagram {

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        LC242_ValidAnagram m = new LC242_ValidAnagram();
        boolean result = m.isAnagram(s,t);
        System.out.println(result);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}
