import java.util.List;

public class LC151_ReverseWordsInString {

    public static void main(String[] args) {
        String s = "a good   example";
        LC151_ReverseWordsInString m = new LC151_ReverseWordsInString();
        String result = m.reverseWords(s);
        System.out.println(result);
    }

    public String reverseWords(String s) {
        String ts = trimSpaces(s);
        char[] chars = ts.toCharArray();
        reverse(chars, 0, ts.length() - 1);
        reverseEachWord(chars);
        return String.valueOf(chars);
    }
    private String trimSpaces(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') left++;
        while (left <= right && s.charAt(right) == ' ') right--;
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') sb.append(c);
            else if (sb.charAt(sb.length() - 1) != ' ') sb.append(c);
            left++;
        }
        return sb.toString();
    }
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
    private void reverseEachWord(char[] chars) {
        int n = chars.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            while (j < n && chars[j] != ' ') j++;
            reverse(chars, i, j - 1);
            i = j + 1;
            j++;
        }
    }
}
