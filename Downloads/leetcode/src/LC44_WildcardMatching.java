public class LC44_WildcardMatching {

    public static void main(String[] args) {
        String s = "aa";
        String p = "*";
        LC44_WildcardMatching m = new LC44_WildcardMatching();
        boolean result = m.isMatch(s,p);
        System.out.println(result);
    }
    public boolean isMatch(String s, String p) {
        //corner case
        if (s == null && p == null) {
            return true;
        }
        if (s== null || p == null) {
            return false;
        }

        int lengths = s.length();
        int lengthp = p.length();

        int sStar = -1; // 用来记录*匹配到的位置
        int pStar = -1; // 用来记录p中*的位置
        int sIndex = 0;
        int pIndex = 0;

        while(sIndex < lengths){
            if(pIndex == lengthp){//false，回溯
                if(pStar == -1) return false;
                pIndex = pStar + 1;
                sIndex = sStar++;
            }
            //两个字符串的相应位置字符相同；或者p出现？匹配任意字符
            else if(p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex)){
                pIndex++;
                sIndex++;
                // 如果p出现 * 号
            }else if(p.charAt(pIndex) == '*'){
                pStar = pIndex;
                sStar = sIndex;
                pIndex = pStar + 1;
                //发现有字符不匹配之后，看前面p有没有*号：
                //没有的话return false；有的话，p中的*号在s中往后匹配一个
            }else{
                if(pStar == -1) return false;
                pIndex = pStar + 1;
                sIndex = sStar++;
            }
        }
        while(pIndex < lengthp){
            if(p.charAt(pIndex) != '*')
                break;
            pIndex++;
        }
        return pIndex == lengthp;
    }
}
