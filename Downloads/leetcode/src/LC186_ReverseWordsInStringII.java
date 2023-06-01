public class LC186_ReverseWordsInStringII {

    public static void main(String[] args) {
        char[] s = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        LC186_ReverseWordsInStringII m = new LC186_ReverseWordsInStringII();
        m.reverseWords(s);
        System.out.print(s);
    }

    public void reverseWords(char[] s) {
        if(s == null || s.length == 0) return;
        reverse(s, 0, s.length - 1);
        int slow = 0;
        int fast;

        for(fast = 0; fast < s.length; fast++){
            if(s[fast] == ' '){
                reverse(s, slow, fast - 1);
                slow = fast + 1;
            }
        }
        reverse(s, slow, fast - 1);
        return;
    }

    private void reverse(char[] s, int left, int right){
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
