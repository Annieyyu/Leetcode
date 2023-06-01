public class LC91_DecodeWays {

    public static void main(String[] args) {
        String s = "12";
        LC91_DecodeWays m = new LC91_DecodeWays();
        int result = m.numDecodings(s);
        System.out.println(result);
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int a = s.charAt(i - 1);
            int b = s.charAt(i - 2);
            if (a >= '1' && a <= '9') {
                dp[i] = dp[i - 1];
            }
            if (b == '1' || (b == '2' && a <= '6' && a >= '0')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
