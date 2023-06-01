import java.util.HashMap;

public class LC13_RomanToInteger {

    public static void main(String[] args) {
        String s = "III";
        LC13_RomanToInteger m = new LC13_RomanToInteger();
        int result = m.romanToInt(s);
        System.out.print(result);
    }



    public int romanToInt(String s) {
        //cc
        if (s == null || s.length() == 0){
            return -1;
        }
        //create a hashmap to store the symbol with corresponding value
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int result = map.get(s.charAt(len - 1));
        //start the iteration from the second to the end of the string
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }
        return result;
    }
}
