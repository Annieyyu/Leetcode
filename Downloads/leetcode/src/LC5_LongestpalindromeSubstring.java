public class LC5_LongestpalindromeSubstring {

    public static void main(String[] args){
        String s = "badad";
        LC5_LongestpalindromeSubstring m = new LC5_LongestpalindromeSubstring();
        String res = m.longestPalindrome(s);
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(j == i){
                    dp[i][j] = true;
                    if(j - i + 1 > res.length()){
                        res = s.substring(i, j + 1);

                    }
                    //bcacb
                    //i=1, j=4
                }else if(s.charAt(i) == s.charAt(j)){
                    if(j == i + 1 || dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        if(j - i + 1 > res.length()){
                            res = s.substring(i, j + 1);
                        }

                    }

                }//else res="null";




            }
        }

        return res;
    }
}
