import java.util.ArrayList;
import java.util.List;

public class LC216_CombinationSumIII {

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        LC216_CombinationSumIII m = new LC216_CombinationSumIII();
        List<List<Integer>> result = m.combinationSum3(k,n);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, k, n, 0, 0, new ArrayList<>(), 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, int k, int n, int count, int sum, List<Integer> path, int index) {
        if (sum == n && count == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum >= n || count >= k || index > 9) {
            return;
        }
        for (int i = index; i <= 9; i++) {
            path.add(i);
            dfs(res, k, n, count + 1, sum + i, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
