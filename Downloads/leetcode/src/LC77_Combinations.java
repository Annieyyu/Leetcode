import java.util.ArrayList;
import java.util.List;

public class LC77_Combinations {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        LC77_Combinations m = new LC77_Combinations();
        List<List<Integer>> result = m.combine(n,k);
        System.out.println(result);
    }

    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        // cc

        this.n = n;
        this.k = k;
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int index) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i <= n; i++) {
            path.add(i);
            dfs(res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
