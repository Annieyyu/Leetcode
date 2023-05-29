public class RegularExpressionMatch {


    public static void main(String[] args) {

        RegularExpressionMatch m = new RegularExpressionMatch();

        System.out.println(m.isMatch("aa", "a*"));

        //System.out.println(m.isMatch("aa", "b*"));


    }

    public boolean isMatch(String s, String p) {
        Boolean[][] mem = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, 0, p, 0, mem);
    }

    private boolean dfs(String S, int indexS, String P, int indexP, Boolean[][] mem) {
        System.out.println(indexS);
        if (indexP == P.length()) {
            return indexS == S.length();
        }

        if (indexS < S.length() && indexP < P.length() && mem[indexS][indexP] != null) {
            return mem[indexS][indexP];
        }
        // 非 a* 结构
        if (indexP == P.length() - 1 || P.charAt(indexP + 1) != '*') {
            if(indexS < S.length() && isMatch(S, indexS, P, indexP)) {
                boolean ret = dfs(S, indexS + 1, P, indexP + 1, mem);
                mem[indexS][indexP] = ret;
                return ret;
            } else {
                mem[indexS][indexP] = false;
                return false;
            }
        } else { // a* 结构
            int i = indexS - 1;
            while (i < S.length() && (i == indexS - 1 || isMatch(S, i, P, indexP))) {
                if (dfs(S, i + 1, P, indexP + 2, mem)) {
                    mem[indexS][indexP] = true;
                    return true;
                }
                i++;
            }
            mem[indexS][indexP] = false;
            return false;
        }
    }

    private boolean isMatch(String S, int indexS, String P, int indexP) {
        return P.charAt(indexP) == '.' || P.charAt(indexP) == S.charAt(indexS);
    }
}
