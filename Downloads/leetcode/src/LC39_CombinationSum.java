import java.util.ArrayList;
import java.util.List;

public class LC39_CombinationSum {

    public static void main(String[] args) {
        int[]nums = new int[]{2, 3, 6, 7};
        int k = 7;
        LC39_CombinationSum m = new LC39_CombinationSum();
        List<List<Integer>> result = m.combinationSum(nums,k);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        combinationSumDFS(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void combinationSumDFS(int[] candidates, int index, int target, List<Integer> path, List<List<Integer>> res) {
        //Base case
        if(target <0) return;
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }


        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            combinationSumDFS(candidates, i, target - candidates[i], path, res);
            path.remove(path.size() - 1);
        }
    }
}
