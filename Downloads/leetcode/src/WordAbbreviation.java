
import java.util.ArrayList;
import java.util.List;

public class WordAbbreviation {

    public static void main(String[] args) {

        WordAbbreviation m = new WordAbbreviation();
        System.out.println(m.generateAbbreviations("word"));

    }
    public List<String> generateAbbreviations(String word) {
        // corner case
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), word, 0, 0);
        return res;
    }
    private void dfs(List<String> res, StringBuilder sb, String word, int idx, int count){

        if(idx == word.length()){
            int originalLen = sb.length();
            if(count != 0){
                sb.append(count);
            }
            res.add(sb.toString());
            sb.setLength(originalLen);
            return;
        }
        dfs(res, sb, word, idx + 1, count + 1);
        int originalLen = sb.length();
        if(count != 0){
            sb.append(count);
        }
        sb.append(word.charAt(idx));
        dfs(res, sb, word, idx + 1, 0);
        sb.setLength(originalLen);
    }
}
