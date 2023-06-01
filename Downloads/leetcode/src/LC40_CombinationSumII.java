import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40_CombinationSumII {

    public static void main(String[] args) {
        int[]nums = new int[]{10,1,2,7,6,1,5};
        int k = 8;
        LC40_CombinationSumII m = new LC40_CombinationSumII();
        List<List<Integer>> result = m.combinationSum2(nums,k);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(res, candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] can, int target, int index, List<Integer> path) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < can.length; i++) {
            if(i > index && can[i] == can[i - 1]) continue;
            path.add(can[i]);
            dfs(res, can, target - can[i], i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
