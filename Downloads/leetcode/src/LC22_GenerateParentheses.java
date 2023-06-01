import java.util.ArrayList;
import java.util.List;

public class LC22_GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;
        LC22_GenerateParentheses m = new LC22_GenerateParentheses();
        List<String> result = m.generateParenthesis(n);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), n, 0, 0, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder path, int n, int index,
                     int left, int right) {
        // success
        if (index == 2 * n && left == n && right == n) {
            res.add(path.toString());
        }

        // failure
        if (index >= 2 * n || left < right || left > n) {
            return;
        }

        path.append("(");
        dfs(res, path, n, index + 1, left + 1, right);
        path.setLength(path.length() -  1);

        path.append(")");
        dfs(res, path, n, index + 1, left, right + 1);
        path.setLength(path.length() -  1);


    }
}
