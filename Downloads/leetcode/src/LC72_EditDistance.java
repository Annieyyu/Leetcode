public class LC72_EditDistance {

    public static void main(String[] args){
        String word1 = "horse";
        String word2 = "ros";
        LC72_EditDistance m = new LC72_EditDistance();
        int res = m.minDistance(word1,word2);
        System.out.println(res);
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        //代表[0, i)和[0,j)匹配的最小次数
        int[][] mem = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <= len1; i++) {
            mem[i][0] = i;
        }
        for(int j = 1; j <= len2; j++) {
            mem[0][j] = j;
        }
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    mem[i][j] = mem[i - 1][j - 1];
                } else {
                    // 可以画图看出j - 1就是在1上加了个字母
                    mem[i][j] = Math.min(mem[i][j - 1] + 1,
                            Math.min(mem[i - 1][j] + 1,
                                    mem[i - 1][j - 1] + 1));
                }
            }
        }
        return mem[len1][len2];
    }
}
