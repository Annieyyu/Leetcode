public class LC344_ReverseString {

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        LC344_ReverseString  m = new LC344_ReverseString ();
        m.reverseString(s);
        System.out.print(s);
    }
    public void reverseString(char[] s) {
        int len = s.length;
        int left = 0;
        int right = len - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
