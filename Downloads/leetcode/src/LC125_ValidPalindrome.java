public class LC125_ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        LC125_ValidPalindrome m = new LC125_ValidPalindrome();
        boolean result = m.isPalindrome(s);
        System.out.println(result);
    }
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while ((left < right) && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while ((left < right) && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
