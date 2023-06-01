public class LC9_PalindromeNumber {

    public static void main(String[] args) {
        int x = 1225221;
        LC9_PalindromeNumber m = new LC9_PalindromeNumber();
        boolean result = m.isPalindrome(x);
        System.out.println(result);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        String s = String.valueOf(x);

        for (int left = 0, right = s.length() - 1; left <= right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
