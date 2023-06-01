import java.util.HashMap;

public class LC76_MinimumWindowSubstring {

    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        LC76_MinimumWindowSubstring m = new LC76_MinimumWindowSubstring();
        String res = m.minWindow(s,t);
        System.out.println(res);
    }
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        HashMap<Character, Integer> mapT = new HashMap<>();
        HashMap<Character, Integer> mapS = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (mapT.containsKey(c)) {
                mapS.put(c, mapS.getOrDefault(c, 0) + 1);
                if (mapT.get(c).equals(mapS.get(c))) {
                    valid++;
                }
            }
            while (valid == mapT.size()) {
                if (minLen > right - left) {
                    minLen = right - left;
                    start = left;
                }
                char ch = s.charAt(left++);
                if (mapT.containsKey(ch)) {
                    if (mapS.get(ch).equals(mapT.get(ch))) {
                        valid--;
                    }
                    mapS.put(ch, mapS.get(ch) - 1);
                }

            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
