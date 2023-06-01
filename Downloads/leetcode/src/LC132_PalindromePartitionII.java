public class LC132_PalindromePartitionII {

    public static void main(String[] args){
        String s = "aabbc";
        LC132_PalindromePartitionII m = new LC132_PalindromePartitionII();
        int res = m.minCut(s);
        System.out.println(res);
    }
    public int minCut(String s) {
        if(s==null || s.length()==0) return 0;
        int len=s.length();
        int [] dp = new int[len+1];
        dp[len]=0;
        boolean [][] isP = new boolean[len][len];

        for(int i=len-1; i>=0; i--){//String idx
            dp[i]=len-i;
            for(int j=i; j<len;j++){
                if(i==j || s.charAt(i)==s.charAt(j)&&(i+1==j||isP[i+1][j-1])){
                    isP[i][j]=true;
                    dp[i]=Math.min(dp[i],dp[j+1]+1);
                }
            }
        }

        return dp[0]-1;
    }
}
