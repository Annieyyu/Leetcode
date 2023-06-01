public class LC115_DistinctSubsequences {

    public static void main(String[] args){
        String s = "babgbag";
        String t = "bag";
        LC115_DistinctSubsequences m = new LC115_DistinctSubsequences();
        int res = m.numDistinct(s,t);
        System.out.println(res);
    }

    public int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int[][] dp = new int[lenS + 1][lenT + 1];
        dp[0][0] = 0;
        for(int i = 0; i <= lenS; i++){
            dp[i][0] = 1;
        }
        /*
        for(int j = 0; j <= lenT; j++){
            dp[0][j] = 0;
        }
        */
        for(int i = 1; i <= lenS; i++){ //i is dp index
            char cs = s.charAt(i - 1); // i - 1 转为 string index
            for(int j = 1; j <= lenT; j++){
                char ct = t.charAt(j - 1);
                if(cs != ct){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[lenS][lenT];
    }
}
