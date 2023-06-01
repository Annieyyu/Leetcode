public class LC10_RegularExpressionMatching {

    public static void main(String[] args) {
        String s = "aa";
        String p = "ab*";
        LC10_RegularExpressionMatching m = new LC10_RegularExpressionMatching();
        boolean result = m.isMatchs(s,p);
        System.out.println(result);
    }

    public boolean isMatchs(String s, String p) {
        Boolean[][] mem = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, 0, p, 0, mem);
    }
    //idxs=0, idxp=0
    private boolean dfs(String s, int indexs, String p, int indexp, Boolean[][] mem) {
        if (indexp == p.length()) {
            return indexs == s.length();
        }
        if (indexs < s.length() && indexp < p.length() && mem[indexs][indexp] != null) {
            return mem[indexs][indexp];
        }
        if (indexp == p.length() - 1 || p.charAt(indexp + 1) != '*') {
            if (indexs < s.length() && match(s, indexs, p, indexp)) {
                boolean ret = dfs(s, indexs + 1, p, indexp + 1, mem);  //idxs=1, idxp=1
                //idxs=2, idxp=2
                //3,5
                mem[indexs][indexp] = ret;
                return mem[indexs][indexp];
            } else {
                mem[indexs][indexp] = false;
                return false;
            }
        } else {//s=abc(3) p=aba*c(5)
            //idxs=2, idsxp=2
            int i = indexs - 1;  //i=1,

            while(i < s.length() && (i == indexs - 1 || match(s, i, p, indexp))) {
                if (dfs(s, i + 1, p, indexp + 2, mem)) { //idxs=2, idxp=4
                    mem[indexs][indexp] = true;
                    return true;
                }
                i++;
            }
            mem[indexs][indexp] = false;
            return false;
        }
    }

    private boolean match(String s, int indexs, String p, int indexp) {
        if (p.charAt(indexp) == '.' || p.charAt(indexp) == s.charAt(indexs)) {
            return true;
        }
        return false;
    }
}
